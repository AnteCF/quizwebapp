package IndividualProject.business.implementation;

import IndividualProject.business.GetQuizzesByCreatorIdUseCase;
import IndividualProject.domain.GetQuizzesResponse;
import IndividualProject.domain.Quiz;
import IndividualProject.persistence.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetQuizzesByCreatorIdUseCaseImpl implements GetQuizzesByCreatorIdUseCase {

    private final QuizRepository quizRepository;

    @Override
    public GetQuizzesResponse getQuizzesByCreatorId(String creatorId){
        List<Quiz> quizzes = quizRepository.findAllByCreatorId(Long.parseLong(creatorId)).stream().map(QuizConverter::convert).toList();
        return GetQuizzesResponse.builder().quizzes(quizzes).build();
    }
}
