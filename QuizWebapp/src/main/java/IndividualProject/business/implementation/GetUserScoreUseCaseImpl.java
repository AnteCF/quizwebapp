package IndividualProject.business.implementation;

import IndividualProject.business.GetUserScoreUseCase;
import IndividualProject.persistence.FakeDataStore;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class GetUserScoreUseCaseImpl implements GetUserScoreUseCase {

        private final FakeDataStore fakeDataStore;

        @Override
        public Integer getUserScore(Long id) {
                return fakeDataStore.getUserScore(id);
        }
}
