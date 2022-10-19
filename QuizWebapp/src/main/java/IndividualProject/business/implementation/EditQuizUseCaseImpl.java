package IndividualProject.business.implementation;

import IndividualProject.business.EditQuizUseCase;
import IndividualProject.domain.EditQuizRequest;
import IndividualProject.persistence.DatabaseAccess;
import IndividualProject.persistence.entity.QuizEntity;
import IndividualProject.persistence.implementation.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EditQuizUseCaseImpl implements EditQuizUseCase {

    private final QuizRepository quizRepository;

    @Override
    public String editQuiz(EditQuizRequest request) {
        Optional<QuizEntity> quiz = quizRepository.findById(request.getName());
        if(quiz.isPresent()) {
            QuizEntity editQuiz = quiz.get();
            editQuiz.setQuestions(request.getQuestions());
            editQuiz.setDescription(request.getDescription());
            editQuiz.setPossibleAnswers(request.getPossibleAnswers());
            editQuiz.setCorrectAnswers(request.getCorrectAnswers());
            quizRepository.save(editQuiz);
            return request.getName();
        }
        return "failed";
    }
}
