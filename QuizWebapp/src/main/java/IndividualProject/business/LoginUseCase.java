package IndividualProject.business;

import IndividualProject.domain.LoginRequest;
import IndividualProject.domain.LoginResponse;

public interface LoginUseCase {

    LoginResponse login(LoginRequest request);
}
