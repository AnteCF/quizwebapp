package IndividualProject.business.implementation;

import IndividualProject.business.CreateUserUseCase;
import IndividualProject.domain.CreateUserRequest;
import IndividualProject.persistence.UserRepository;
import IndividualProject.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserRepository userRepository;

    @Override
    public Boolean createUser(CreateUserRequest request){

        UserEntity newUser = UserEntity.builder()
                .name(request.getName())
                .role(request.getRole())
                .password(request.getPassword())
                .totalScore(0)
                .build();

        userRepository.save(newUser);
        return true;
    }
}
