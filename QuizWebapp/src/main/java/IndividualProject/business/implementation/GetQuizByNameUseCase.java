package IndividualProject.business.implementation;

import IndividualProject.persistence.FakeDataStore;
import IndividualProject.persistence.entity.Quiz;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetQuizByNameUseCase implements IndividualProject.business.GetQuizByNameUseCase {

    private final FakeDataStore fakeDataStore;

    @Override
    public Quiz getQuizByName(String name){
    return fakeDataStore.getQuizByName(name);
    }
}
