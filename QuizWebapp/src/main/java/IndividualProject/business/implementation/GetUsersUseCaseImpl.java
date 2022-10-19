package IndividualProject.business.implementation;

import IndividualProject.business.GetUsersUseCase;
import IndividualProject.domain.GetUsersResponse;
import IndividualProject.persistence.DatabaseAccess;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetUsersUseCaseImpl implements GetUsersUseCase {
    private final DatabaseAccess databaseAccess;

    @Override
    public GetUsersResponse getUsers(){
        return GetUsersResponse.builder().users(databaseAccess.getUsers()).build();
    }

}
