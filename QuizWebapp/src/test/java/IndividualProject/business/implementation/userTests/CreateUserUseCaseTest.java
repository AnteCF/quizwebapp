package IndividualProject.business.implementation.userTests;

import IndividualProject.business.CreateUserUseCase;
import IndividualProject.business.implementation.CreateUserUseCaseImpl;
import IndividualProject.domain.CreateUserRequest;
import IndividualProject.persistence.UserRepository;
import IndividualProject.persistence.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CreateUserUseCaseTest {

    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Test
    void shouldCreateAUser(){

        CreateUserUseCase createUserUseCase = new CreateUserUseCaseImpl(userRepository, passwordEncoder);

        CreateUserRequest request = CreateUserRequest.builder()
                .name("userOne")
                .role("User")
                .password("userOnePassword")
                .build();

        createUserUseCase.createUser(request);

        UserEntity actualUser = null;
        Optional<UserEntity> user = userRepository.findById(1L);
        if(user.isPresent())
            actualUser = user.get();

        UserEntity expectedUser = UserEntity.builder()
                .name("userOne")
                .role("User")
                .password("userOnePassword")
                .id(1L)
                .totalScore(0)
                .build();

        assertEquals(expectedUser, actualUser);
    }

}
