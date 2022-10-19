package IndividualProject.business.implementation.quizTests;

import IndividualProject.business.CreateQuizUseCase;
import IndividualProject.business.DeleteQuizUseCase;
import IndividualProject.business.implementation.CreateQuizUseCaseImpl;
import IndividualProject.business.implementation.DeleteQuizUseCaseImpl;
import IndividualProject.domain.CreateQuizRequest;
import IndividualProject.domain.DeleteQuizRequest;
import IndividualProject.persistence.entity.QuizEntity;
import IndividualProject.persistence.implementation.QuizRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DeleteQuizUseCaseTest {

    @Autowired
    private QuizRepository quizRepository;

    @Test
    void shouldCreateAndThenDeleteTheQuiz(){
        CreateQuizUseCase createQuizUseCase = new CreateQuizUseCaseImpl(quizRepository);
        DeleteQuizUseCase deleteQuizUseCase = new DeleteQuizUseCaseImpl(quizRepository);

        Map<Integer, String> quizOne = new HashMap<>();
        quizOne.put(1,"What date did world war 2 start?");
        quizOne.put(2,"What date did world war 1 start");

        Map<Integer, List<String>> quizOneAnswers = new HashMap<>();
        List<String> answersOne = new ArrayList<>();
        answersOne.add("question one answer one");
        answersOne.add("question one answer two");
        answersOne.add("question one answer three");
        answersOne.add("question one answer four");
        quizOneAnswers.put(1,answersOne);

        List<String> answersTwo = new ArrayList<>();
        answersTwo.add("question two answer one");
        answersTwo.add("question two answer two");
        answersTwo.add("question two answer three");
        answersTwo.add("question two answer four");
        quizOneAnswers.put(2, answersTwo);

        List<Integer> correctAnswers = new ArrayList<>();
        correctAnswers.add(1);
        correctAnswers.add(2);
        CreateQuizRequest createRequest = CreateQuizRequest.builder()
                .name("society")
                .questions(quizOne)
                .creatorId(5L)
                .description("a interactive quiz about society")
                .possibleAnswers(quizOneAnswers)
                .correctAnswers(correctAnswers)
                .build();

        createQuizUseCase.createQuiz(createRequest);

        DeleteQuizRequest deleteRequest = DeleteQuizRequest.builder()
                .name("society")
                .creatorId(5L)
                .build();

        deleteQuizUseCase.deleteQuiz(deleteRequest);

        Optional<QuizEntity> quiz = quizRepository.findById("society");
        QuizEntity actualQuiz = null;
        if(quiz.isPresent())
            actualQuiz= quiz.get();

        assertNull(actualQuiz);

    }
}
