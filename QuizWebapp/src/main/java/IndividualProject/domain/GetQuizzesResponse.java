package IndividualProject.domain;

import IndividualProject.persistence.entity.Quiz;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetQuizzesResponse {

    private List<Quiz> quizzes;
}
