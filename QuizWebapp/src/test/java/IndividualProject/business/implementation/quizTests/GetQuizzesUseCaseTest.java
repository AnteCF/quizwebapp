package IndividualProject.business.implementation.quizTests;

import IndividualProject.business.CreateQuizUseCase;
import IndividualProject.business.GetQuizzesUseCase;
import IndividualProject.business.implementation.CreateQuizUseCaseImpl;
import IndividualProject.business.implementation.GetQuizzesImpl;
import IndividualProject.domain.CreateQuizRequest;
import IndividualProject.domain.GetQuizzesResponse;
import IndividualProject.domain.Quiz;
import IndividualProject.persistence.entity.QuizEntity;
import IndividualProject.persistence.implementation.QuizRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@ExtendWith or @SpringBootTest
//@ExtendWith builds whole application context(more appropriate for integration test?)
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class GetQuizzesUseCaseTest {

    @Autowired
    private QuizRepository quizRepository;

    @Test
    void shouldCreateAndGetAllQuizzes(){

        CreateQuizUseCase createQuizUseCase = new CreateQuizUseCaseImpl(quizRepository);
        GetQuizzesUseCase getQuizzesUseCase = new GetQuizzesImpl(quizRepository);

        //creating quiz one
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
        CreateQuizRequest request = CreateQuizRequest.builder()
                .name("society")
                .questions(quizOne)
                .creatorId(5L)
                .description("a interactive quiz about society")
                .possibleAnswers(quizOneAnswers)
                .correctAnswers(correctAnswers)
                .build();

        createQuizUseCase.createQuiz(request);

        //creating quiz two
        Map<Integer, String> quizTwo = new HashMap<>();
        quizTwo.put(1,"quiz two question one?");
        quizTwo.put(2,"quiz two question two");
        quizTwo.put(3, "quiz two question three");

        Map<Integer, List<String>> quizTwoAnswers = new HashMap<>();

        List<String> quizTwoAnswersOne = new ArrayList<>();
        quizTwoAnswersOne.add("question one answer one");
        quizTwoAnswersOne.add("question one answer two");
        quizTwoAnswersOne.add("question one answer three");
        quizTwoAnswersOne.add("question one answer four");
        quizTwoAnswers.put(1,quizTwoAnswersOne);

        List<String> quizTwoAnswersTwo = new ArrayList<>();
        quizTwoAnswersTwo.add("question two answer one");
        quizTwoAnswersTwo.add("question two answer two");
        quizTwoAnswersTwo.add("question two answer three");
        quizTwoAnswersTwo.add("question two answer four");
        quizTwoAnswers.put(2, quizTwoAnswersTwo);

        List<Integer> quizTwoCorrectAnswers = new ArrayList<>();
        quizTwoCorrectAnswers.add(4);
        quizTwoCorrectAnswers.add(4);

        CreateQuizRequest requestTwo = CreateQuizRequest.builder()
                .name("history")
                .questions(quizTwo)
                .creatorId(2L)
                .description("a fun quiz about history")
                .possibleAnswers(quizTwoAnswers)
                .correctAnswers(quizTwoCorrectAnswers)
                .build();

        createQuizUseCase.createQuiz(requestTwo);

        //creating expected quizzes

        Quiz expectedQuizOne = Quiz.builder()
                .name("society")
                .questions(quizOne)
                .creatorId(5L)
                .description("a interactive quiz about society")
                .possibleAnswers(quizOneAnswers)
                .correctAnswers(correctAnswers)
                .rating(0F)
                .build();

        Quiz expectedQuizTwo = Quiz.builder()
                .name("history")
                .questions(quizTwo)
                .creatorId(2L)
                .description("a fun quiz about history")
                .possibleAnswers(quizTwoAnswers)
                .correctAnswers(quizTwoCorrectAnswers)
                .rating(0F)
                .build();

        List<Quiz> expectedQuizzesList = new ArrayList<>();
        expectedQuizzesList.add(expectedQuizTwo);
        expectedQuizzesList.add(expectedQuizOne);

        GetQuizzesResponse expectedQuizzes = GetQuizzesResponse.builder()
                .quizzes(expectedQuizzesList)
                .build();

        GetQuizzesResponse actualQuizzes = getQuizzesUseCase.getQuizzes();

        assertEquals(expectedQuizzes, actualQuizzes);
    }
}
