package IndividualProject.business;

import IndividualProject.domain.GetQuizzesResponse;

public interface GetQuizzesByRatingUseCase {

    GetQuizzesResponse getQuizzesByRating(Float rating);
}
