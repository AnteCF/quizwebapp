package IndividualProject.business.implementation;

import IndividualProject.domain.Quiz;
import IndividualProject.persistence.entity.QuizEntity;

final class QuizConverter {

    private QuizConverter() {

    }

    public static Quiz convert(QuizEntity quizEntity){
        return Quiz.builder()
                .name(quizEntity.getName())
                .questions(quizEntity.getQuestions())
                .creatorId(quizEntity.getCreatorId())
                .rating(quizEntity.getRating())
                .description(quizEntity.getDescription())
                .possibleAnswers(quizEntity.getPossibleAnswers())
                .correctAnswers(quizEntity.getCorrectAnswers())
                .build();
    }
}
