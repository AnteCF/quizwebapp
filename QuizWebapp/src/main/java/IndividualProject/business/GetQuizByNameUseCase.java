package IndividualProject.business;

import IndividualProject.persistence.entity.Quiz;

public interface GetQuizByNameUseCase {
    Quiz getQuizByName(String name);
}
