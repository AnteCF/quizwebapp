package IndividualProject.persistence.entity;

import IndividualProject.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class UserTest {

    @Test
    void getNameTest() {
        User testUser = User.builder().name("Ante").id(1L).totalScore(10).build();
        assertEquals("Ante", testUser.getName());
    }

    @Test
    void getId() {
        User testUser = User.builder().name("Ante").id(1L).totalScore(10).build();
        assertEquals(1L, testUser.getId());
    }

    @Test
    void getTotalScore() {
        User testUser = User.builder().name("Ante").id(1L).totalScore(10).build();
        assertEquals(10, testUser.getTotalScore());
    }

    @Test
    void setName() {
        User testUser = User.builder().name("Ante").id(1L).totalScore(10).build();
        testUser.setName("Marcus");
        assertEquals("Marcus", testUser.getName());
    }
}