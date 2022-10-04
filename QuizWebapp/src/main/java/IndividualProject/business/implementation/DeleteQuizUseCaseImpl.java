package IndividualProject.business.implementation;

import IndividualProject.business.DeleteQuizUseCase;
import IndividualProject.domain.DeleteQuizRequest;
import IndividualProject.persistence.FakeDataStore;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteQuizUseCaseImpl implements DeleteQuizUseCase {

    private final FakeDataStore fakeDataStore;

    @Override
    public void deleteQuiz(DeleteQuizRequest request){
        fakeDataStore.deleteQuiz(request);
    }
}
