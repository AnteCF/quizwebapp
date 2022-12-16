package IndividualProject.business;

import IndividualProject.domain.GetQuizzesResponse;

public interface GetQuizzesByCreatorIdUseCase {
    GetQuizzesResponse getQuizzesByCreatorId(String creatorId);
}
