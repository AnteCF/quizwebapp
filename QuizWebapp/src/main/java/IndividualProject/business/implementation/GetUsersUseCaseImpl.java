package IndividualProject.business.implementation;

import IndividualProject.business.GetUsersUseCase;
import IndividualProject.domain.GetUsersResponse;
import IndividualProject.domain.User;
import IndividualProject.persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GetUsersUseCaseImpl implements GetUsersUseCase {
    private final UserRepository userRepository;

    @Override
    public GetUsersResponse getUsers(){
        List<User> users = userRepository.findAll().stream().map(UserConverter::convert).toList();
        return GetUsersResponse.builder().users(users).build();
    }

}
