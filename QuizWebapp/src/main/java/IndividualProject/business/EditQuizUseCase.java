package IndividualProject.business;

import IndividualProject.domain.EditQuizRequest;
import IndividualProject.persistence.entity.Quiz;

public interface EditQuizUseCase {

    String editQuiz(EditQuizRequest request);
}
