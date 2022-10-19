package IndividualProject.business;

import IndividualProject.domain.IncrementUserScoreRequest;

public interface IncrementTotalScoreUseCase {

    void incrementUserScore(IncrementUserScoreRequest request);
}
