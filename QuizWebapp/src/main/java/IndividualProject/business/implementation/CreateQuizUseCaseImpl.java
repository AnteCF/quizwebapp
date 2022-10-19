package IndividualProject.business.implementation;

import IndividualProject.business.CreateQuizUseCase;
import IndividualProject.domain.CreateQuizRequest;
import IndividualProject.persistence.entity.QuizEntity;
import IndividualProject.persistence.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateQuizUseCaseImpl implements CreateQuizUseCase {
    private final QuizRepository quizRepository;

    @Override
    public Boolean createQuiz(CreateQuizRequest request){

        QuizEntity newQuiz = QuizEntity.builder()
                .name(request.getName())
                .questions(request.getQuestions())
                .creatorId(request.getCreatorId())
                .rating(0F)
                .description(request.getDescription())
                .possibleAnswers(request.getPossibleAnswers())
                .correctAnswers(request.getCorrectAnswers())
                .build();
        QuizEntity savedQuiz =  quizRepository.save(newQuiz);

        if(savedQuiz != null)
            return true;
        return false;
    }
}
