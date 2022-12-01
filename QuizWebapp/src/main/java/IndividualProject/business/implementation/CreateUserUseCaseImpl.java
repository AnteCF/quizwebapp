package IndividualProject.business.implementation;

import IndividualProject.business.CreateUserUseCase;
import IndividualProject.domain.CreateUserRequest;
import IndividualProject.persistence.UserRepository;
import IndividualProject.persistence.entity.RoleEnum;
import IndividualProject.persistence.entity.UserEntity;
import IndividualProject.persistence.entity.UserRoleEntity;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Boolean createUser(CreateUserRequest request){

        String encodedPassword = passwordEncoder.encode(request.getPassword());
        RoleEnum role = RoleEnum.USER;
        if(request.getRole().equals("ADMIN")){
            role = RoleEnum.ADMIN;
        }

        //building a new user
        UserEntity newUser = UserEntity.builder()
                .name(request.getName())
                .password(encodedPassword)
                .totalScore(0)
                .build();

        //setting the role set for the user
        newUser.setUserRoles(Set.of(
                UserRoleEntity.builder()
                        .user(newUser)
                        .role(role)
                        .build()));

        userRepository.save(newUser);
        return true;
    }
}
