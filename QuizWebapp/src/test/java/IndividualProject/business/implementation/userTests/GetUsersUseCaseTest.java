package IndividualProject.business.implementation.userTests;

import IndividualProject.business.CreateUserUseCase;
import IndividualProject.business.GetUsersUseCase;
import IndividualProject.business.implementation.CreateUserUseCaseImpl;
import IndividualProject.business.implementation.GetUsersUseCaseImpl;
import IndividualProject.domain.CreateUserRequest;
import IndividualProject.domain.GetUsersResponse;
import IndividualProject.domain.User;
import IndividualProject.persistence.UserRepository;
import IndividualProject.persistence.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class GetUsersUseCaseTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldCreateAndGetAllUsers(){

        GetUsersUseCase getUsersUseCase = new GetUsersUseCaseImpl(userRepository);

        UserEntity userOne = UserEntity.builder()
                .name("userOne")
                .role("User")
                .password("userOnePassword")
                .id(1L)
                .totalScore(0)
                .build();

        UserEntity userTwo = UserEntity.builder()
                .name("userTwo")
                .role("Admin")
                .password("userTwoPassword")
                .id(2L)
                .totalScore(110)
                .build();

        userRepository.save(userOne);
        userRepository.save(userTwo);


        //creating expected users
        User expectedUserOne = User.builder()
                .name("userOne")
                .role("User")
                .id(1L)
                .totalScore(0)
                .build();

        User expectedUserTwo = User.builder()
                .name("userTwo")
                .role("Admin")
                .id(2L)
                .totalScore(110)
                .build();

        List<User> users = new ArrayList<>();
        users.add(expectedUserOne);
        users.add(expectedUserTwo);

        GetUsersResponse expectedUsers = GetUsersResponse.builder()
                        .users(users)
                        .build();

        GetUsersResponse actualUsers = getUsersUseCase.getUsers();

        assertEquals(expectedUsers, actualUsers);
    }
}
