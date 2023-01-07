package IndividualProject.business.implementation;

import IndividualProject.business.GetQuizzesByCreatorIdUseCase;
import IndividualProject.business.GetQuizzesByRatingUseCase;
import IndividualProject.domain.GetQuizzesResponse;
import IndividualProject.domain.Quiz;
import IndividualProject.persistence.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetQuizzesByRatingUseCaseImpl implements GetQuizzesByRatingUseCase {

    private final QuizRepository quizRepository;

    @Override
    public GetQuizzesResponse getQuizzesByRating(Float rating){
        List<Quiz> quizzes = quizRepository.findAllByRatingGreaterThanEqual(rating).stream().map(QuizConverter::convert).toList();
        return GetQuizzesResponse.builder().quizzes(quizzes).build();
    }
}
