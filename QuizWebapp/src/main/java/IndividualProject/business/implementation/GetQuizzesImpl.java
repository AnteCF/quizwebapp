package IndividualProject.business.implementation;

import IndividualProject.business.GetQuizzesUseCase;
import IndividualProject.domain.GetQuizzesResponse;
import IndividualProject.domain.Quiz;
import IndividualProject.persistence.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetQuizzesImpl implements GetQuizzesUseCase {

    private final QuizRepository quizRepository;

    @Override
    public GetQuizzesResponse getQuizzes(){
        List<Quiz> quizzes = quizRepository.findAll().stream().map(QuizConverter::convert).toList();
        return GetQuizzesResponse.builder().quizzes(quizzes).build();
    }
}
