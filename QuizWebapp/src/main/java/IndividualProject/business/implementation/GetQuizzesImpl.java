package IndividualProject.business.implementation;

import IndividualProject.business.GetQuizzesUseCase;
import IndividualProject.domain.GetQuizzesResponse;
import IndividualProject.persistence.FakeDataStore;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetQuizzesImpl implements GetQuizzesUseCase {

    private final FakeDataStore fakeDataStore;

    @Override
    public GetQuizzesResponse getQuizzes(){
        return GetQuizzesResponse.builder().quizzes(fakeDataStore.getQuizzes()).build();
    }
}
