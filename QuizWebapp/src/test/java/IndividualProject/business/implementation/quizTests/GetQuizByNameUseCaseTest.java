package IndividualProject.business.implementation.quizTests;

import IndividualProject.business.CreateQuizUseCase;
import IndividualProject.business.implementation.CreateQuizUseCaseImpl;
import IndividualProject.business.implementation.GetQuizByNameUseCase;
import IndividualProject.domain.CreateQuizRequest;
import IndividualProject.domain.Quiz;
import IndividualProject.persistence.QuizRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class GetQuizByNameUseCaseTest {

    @Autowired
    private QuizRepository quizRepository;

    @Test
    void shouldCreateAndGetQuizByName(){
        CreateQuizUseCase createQuizUseCase = new CreateQuizUseCaseImpl(quizRepository);
        GetQuizByNameUseCase getQuizByNameUseCase = new GetQuizByNameUseCase(quizRepository);

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

        Quiz actualQuiz = getQuizByNameUseCase.getQuizByName("society");

        Quiz expectedQuiz = Quiz.builder()
                .name("society")
                .questions(quizOne)
                .creatorId(5L)
                .description("a interactive quiz about society")
                .possibleAnswers(quizOneAnswers)
                .correctAnswers(correctAnswers)
                .rating(0F)
                .build();

        assertEquals(expectedQuiz, actualQuiz);

    }
}
