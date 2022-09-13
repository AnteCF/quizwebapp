package IndividualProject.persistence;

import IndividualProject.persistence.entity.Quiz;
import IndividualProject.persistence.entity.User;

import java.util.List;

public interface FakeDataStore {

    User getUserById(Long id);

    public List<User> getUsers();

    public List<Quiz> getQuizzes();

    public Quiz getQuizByName(String name);
}
