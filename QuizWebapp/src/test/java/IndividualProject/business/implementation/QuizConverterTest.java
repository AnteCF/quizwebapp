package IndividualProject.business.implementation;

import IndividualProject.domain.Quiz;
import IndividualProject.persistence.entity.QuizEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class QuizConverterTest {

    @Test
    void convertQuizEntityToDomainTest() {
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
        QuizEntity quizToBeConverted = QuizEntity.builder()
                .name("history")
                .questions(quizOne)
                .possibleAnswers(quizOneAnswers)
                .correctAnswers(correctAnswers)
                .creatorId(1L)
                .rating(2F)
                .description("A fun quiz about history")
                .build();

        Quiz actual = QuizConverter.convert(quizToBeConverted);

        Quiz expected =Quiz.builder()
                .name("history")
                .questions(quizOne)
                .possibleAnswers(quizOneAnswers)
                .correctAnswers(correctAnswers)
                .creatorId(1L)
                .rating(2F)
                .description("A fun quiz about history")
                .build();

        assertEquals(expected, actual);
    }
}