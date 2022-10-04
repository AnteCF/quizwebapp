package IndividualProject.business.implementation;

import IndividualProject.business.CreateQuizUseCase;
import IndividualProject.domain.CreateQuizRequest;
import IndividualProject.persistence.FakeDataStore;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateQuizUseCaseImpl implements CreateQuizUseCase {
    private final FakeDataStore fakeDataStore;

    @Override
    public Boolean createQuiz(CreateQuizRequest request){
        return fakeDataStore.createQuiz(request);
    }
}
