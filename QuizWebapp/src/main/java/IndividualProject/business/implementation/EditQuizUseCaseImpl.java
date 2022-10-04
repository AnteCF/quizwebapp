package IndividualProject.business.implementation;

import IndividualProject.business.EditQuizUseCase;
import IndividualProject.domain.EditQuizRequest;
import IndividualProject.persistence.FakeDataStore;
import IndividualProject.persistence.entity.Quiz;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EditQuizUseCaseImpl implements EditQuizUseCase {

    private final FakeDataStore fakeDataStore;

    @Override
    public String editQuiz(EditQuizRequest request) {
        return fakeDataStore.editQuiz(request);
    }
}
