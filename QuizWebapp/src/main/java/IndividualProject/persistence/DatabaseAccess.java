package IndividualProject.persistence;

import IndividualProject.domain.CreateQuizRequest;
import IndividualProject.domain.DeleteQuizRequest;
import IndividualProject.domain.EditQuizRequest;
import IndividualProject.domain.Quiz;
import IndividualProject.domain.User;
import IndividualProject.persistence.entity.QuizEntity;
import IndividualProject.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatabaseAccess{

    User getUserById(Long id);

    List<User> getUsers();

    List<Quiz> getQuizzes();

    Quiz getQuizByName(String name);

    Boolean createQuiz(CreateQuizRequest request);

    void deleteQuiz(DeleteQuizRequest request);

    Integer getUserScore(Long id);

    String editQuiz(EditQuizRequest request);

}

