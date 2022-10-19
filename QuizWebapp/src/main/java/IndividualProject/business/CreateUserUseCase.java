package IndividualProject.business;

import IndividualProject.domain.CreateUserRequest;

public interface CreateUserUseCase {

    Boolean createUser(CreateUserRequest request);
}
