package IndividualProject.business.implementation;

import IndividualProject.business.GetUsersUseCase;
import IndividualProject.domain.GetUsersResponse;
import IndividualProject.persistence.FakeDataStore;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetUsersUseCaseImpl implements GetUsersUseCase {
    private final FakeDataStore fakeDataStore;

    @Override
    public GetUsersResponse getUsers(){
        return GetUsersResponse.builder().users(fakeDataStore.getUsers()).build();
    }

}
