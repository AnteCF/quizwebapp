package IndividualProject.business.implementation;

import IndividualProject.business.GetUserScoreUseCase;
import IndividualProject.persistence.UserRepository;
import IndividualProject.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class GetUserScoreUseCaseImpl implements GetUserScoreUseCase {

        private final UserRepository userRepository;

        @Override
        public Integer getUserScore(Long id) {

               Optional<UserEntity> user= userRepository.findById(id);

               if(user.isPresent())
                       return user.get().getTotalScore();

               return null;
        }
}
