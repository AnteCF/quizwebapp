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
public class EditQuizRequest {

    private String name;

    private Long creatorId;

    private List<String> questions;

    private Map<Integer, List<String>> possibleAnswers;

    private List<Integer> correctAnswers;

    private String description;
}
