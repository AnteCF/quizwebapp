package IndividualProject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateQuizRequest {

    private String name;

    private List<String> questions;

    private Long creatorId;

    private String description;

    private Map<Integer, List<String>> possibleAnswers;

    private List<Integer> correctAnswers;

}
