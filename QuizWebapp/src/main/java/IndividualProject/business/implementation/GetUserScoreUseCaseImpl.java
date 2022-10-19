package IndividualProject.business.implementation;

import IndividualProject.business.GetUserScoreUseCase;
import IndividualProject.persistence.DatabaseAccess;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class GetUserScoreUseCaseImpl implements GetUserScoreUseCase {

        private final DatabaseAccess databaseAccess;

        @Override
        public Integer getUserScore(Long id) {
                return databaseAccess.getUserScore(id);
        }
}
