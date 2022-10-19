package IndividualProject.business.implementation;

import IndividualProject.business.DeleteQuizUseCase;
import IndividualProject.domain.DeleteQuizRequest;
import IndividualProject.persistence.entity.QuizEntity;
import IndividualProject.persistence.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteQuizUseCaseImpl implements DeleteQuizUseCase {

    private final QuizRepository quizRepository;

    @Override
    public void deleteQuiz(DeleteQuizRequest request){
        QuizEntity quiz = quizRepository.getById(request.getName());
        if(quiz.getCreatorId().equals(request.getCreatorId()))
            quizRepository.delete(quiz);
    }
}
