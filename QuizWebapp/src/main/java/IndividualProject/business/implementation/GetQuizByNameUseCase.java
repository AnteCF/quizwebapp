package IndividualProject.business.implementation;

import IndividualProject.domain.Quiz;
import IndividualProject.persistence.entity.QuizEntity;
import IndividualProject.persistence.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetQuizByNameUseCase implements IndividualProject.business.GetQuizByNameUseCase {

    private final QuizRepository quizRepository;

    @Override
    public Quiz getQuizByName(String name){

        Optional<QuizEntity> quiz = quizRepository.findById(name);
        if(quiz.isPresent())
        {
            Quiz wantedQuiz = QuizConverter.convert(quiz.get());
            return wantedQuiz;
        }
        return null;
    }
}
