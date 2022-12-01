package IndividualProject.business.implementation;

import IndividualProject.business.AccessTokenEncoder;
import IndividualProject.business.LoginUseCase;
import IndividualProject.business.exception.InvalidCredentialsException;
import IndividualProject.domain.AccessToken;
import IndividualProject.domain.LoginRequest;
import IndividualProject.domain.LoginResponse;
import IndividualProject.persistence.UserRepository;
import IndividualProject.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AccessTokenEncoder accessTokenEncoder;

    @Override
    public LoginResponse login(LoginRequest request){
        UserEntity user = userRepository.findByName(request.getName());
        if(user == null){
            throw new InvalidCredentialsException();
        }

        if (!matchesPassword(request.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException();
        }

        String accessToken = generateAccessToken(user);
        return LoginResponse.builder().accessToken(accessToken).build();

    }

    private boolean matchesPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    private String generateAccessToken(UserEntity user) {
        Long userId = user.getId() != null ? user.getId() : null;
        List<String> roles = user.getUserRoles().stream()
                .map(userRole -> userRole.getRole().toString())
                .toList();

        return accessTokenEncoder.encode(
                AccessToken.builder()
                        .subject(user.getName())
                        .roles(roles)
                        .userId(userId)
                        .build());
    }

}
