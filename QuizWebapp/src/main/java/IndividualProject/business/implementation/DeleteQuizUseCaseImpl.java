package IndividualProject.business.implementation;

import IndividualProject.business.DeleteQuizUseCase;
import IndividualProject.domain.DeleteQuizRequest;
import IndividualProject.persistence.entity.QuizEntity;
import IndividualProject.persistence.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DeleteQuizUseCaseImpl implements DeleteQuizUseCase {

    private final QuizRepository quizRepository;

    @Override
    public void deleteQuiz(DeleteQuizRequest request){
        Optional<QuizEntity> quiz = quizRepository.findById(request.getName());
        QuizEntity quizToBeDeleted = null;
        if(quiz.isPresent()) {
            quizToBeDeleted = quiz.get();
            if (quizToBeDeleted.getCreatorId().equals(request.getCreatorId()))
                quizRepository.delete(quizToBeDeleted);
        }
    }
}
