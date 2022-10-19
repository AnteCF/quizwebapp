package IndividualProject.business.implementation;

import IndividualProject.business.IncrementTotalScoreUseCase;
import IndividualProject.domain.IncrementUserScoreRequest;
import IndividualProject.persistence.UserRepository;
import IndividualProject.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class IncrementTotalScoreUseCaseImpl implements IncrementTotalScoreUseCase {
    private final UserRepository userRepository;

    @Override
    public void incrementUserScore(IncrementUserScoreRequest request){
        Optional<UserEntity> user = userRepository.findById(request.getUserId());
        if(user.isPresent()){
            UserEntity editUser = user.get();
            editUser.setTotalScore(editUser.getTotalScore()+request.getScoreAmount());
            userRepository.save(editUser);
        }
    }

}
