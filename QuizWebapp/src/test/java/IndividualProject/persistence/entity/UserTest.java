package IndividualProject.persistence.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getNameTest() {
        User testUser = User.builder().name("Ante").id(1L).role("user").totalScore(10L).build();
        assertEquals("Ante", testUser.getName());
    }

    @Test
    void getRole() {
        User testUser = User.builder().name("Ante").id(1L).role("user").totalScore(10L).build();
        assertEquals("user", testUser.getRole());
    }

    @Test
    void getId() {
        User testUser = User.builder().name("Ante").id(1L).role("user").totalScore(10L).build();
        assertEquals(1L, testUser.getId());
    }

    @Test
    void getTotalScore() {
        User testUser = User.builder().name("Ante").id(1L).role("user").totalScore(10L).build();
        assertEquals(10L, testUser.getTotalScore());
    }

    @Test
    void setName() {
        User testUser = User.builder().name("Ante").id(1L).role("user").totalScore(10L).build();
        testUser.setName("Marcus");
        assertEquals("Marcus", testUser.getName());
    }
}