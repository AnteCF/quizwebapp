package IndividualProject.business.implementation.quizTests;

import IndividualProject.business.CreateQuizUseCase;
import IndividualProject.business.EditQuizUseCase;
import IndividualProject.business.implementation.CreateQuizUseCaseImpl;
import IndividualProject.business.implementation.EditQuizUseCaseImpl;
import IndividualProject.domain.CreateQuizRequest;
import IndividualProject.domain.EditQuizRequest;
import IndividualProject.persistence.entity.QuizEntity;
import IndividualProject.persistence.QuizRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EditQuizUseCaseTest {

    @Autowired
    private QuizRepository quizRepository;

    @Test
    void shouldCreateAndThenEditTheQuiz(){
        CreateQuizUseCase createQuizUseCase = new CreateQuizUseCaseImpl(quizRepository);
        EditQuizUseCase editQuizUseCase = new EditQuizUseCaseImpl(quizRepository);

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

        Map<Integer, String> newQuiz = new HashMap<>();
        newQuiz.put(1,"What date did world war 2 start?");
        newQuiz.put(2,"What date did world war 1 start");

        Map<Integer, List<String>> newAnswers = new HashMap<>();
        List<String> newAnswersOne = new ArrayList<>();
        answersOne.add("new question one answer one");
        answersOne.add("new question one answer two");
        answersOne.add("new question one answer three");
        answersOne.add("new question one answer four");
        newAnswers.put(1,newAnswersOne);

        List<String> newAnswersTwo = new ArrayList<>();
        answersTwo.add("new question two answer one");
        answersTwo.add("new question two answer two");
        answersTwo.add("new question two answer three");
        answersTwo.add("new question two answer four");
        newAnswers.put(2, newAnswersTwo);

        List<Integer> newCorrectAnswers = new ArrayList<>();
        newCorrectAnswers.add(2);
        newCorrectAnswers.add(4);

        EditQuizRequest editRequest = EditQuizRequest.builder()
                .name("society")
                .questions(newQuiz)
                .creatorId(5L)
                .description("new society quiz")
                .possibleAnswers(newAnswers)
                .correctAnswers(newCorrectAnswers)
                .build();

        QuizEntity expectedQuiz = QuizEntity.builder()
                .name("society")
                .questions(newQuiz)
                .creatorId(5L)
                .rating(0F)
                .description("new society quiz")
                .possibleAnswers(newAnswers)
                .correctAnswers(newCorrectAnswers)
                .build();

        editQuizUseCase.editQuiz(editRequest);

        Optional<QuizEntity> quiz = quizRepository.findById("society");
        QuizEntity actualQuiz = null;
        if(quiz.isPresent())
            actualQuiz= quiz.get();

        assertEquals(expectedQuiz, actualQuiz);

    }
}
