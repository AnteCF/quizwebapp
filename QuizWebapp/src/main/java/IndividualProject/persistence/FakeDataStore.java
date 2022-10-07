package IndividualProject.persistence;

import IndividualProject.domain.CreateQuizRequest;
import IndividualProject.domain.DeleteQuizRequest;
import IndividualProject.domain.EditQuizRequest;
import IndividualProject.persistence.entity.Quiz;
import IndividualProject.persistence.entity.User;

import java.util.List;

public interface FakeDataStore {

    User getUserById(Long id);

    List<User> getUsers();

    List<Quiz> getQuizzes();

    Quiz getQuizByName(String name);

    Boolean createQuiz(CreateQuizRequest request);

    void deleteQuiz(DeleteQuizRequest request);

    Integer getUserScore(Long id);

    String editQuiz(EditQuizRequest request);

}
