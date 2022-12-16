package IndividualProject.business.implementation;

import IndividualProject.domain.Quiz;
import IndividualProject.domain.User;
import IndividualProject.persistence.entity.QuizEntity;
import IndividualProject.persistence.entity.UserEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserConverterTest {

    @Test
    void convertUserEntityToDomainTest() {

        UserEntity userToBeConverted = UserEntity.builder()
                .name("testUser")
                .password("password")
                .id(2L)
                .totalScore(5)
                .build();
        User actual = UserConverter.convert(userToBeConverted);

        User expected = User.builder()
                .name("testUser")
                .id(2L)
                .totalScore(5)
                .build();

        assertEquals(expected, actual);
    }
}