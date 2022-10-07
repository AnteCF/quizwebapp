package IndividualProject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditQuizRequest {

    private String name;

    private String newName;

    private Long creatorId;

    private Map<Integer, String> questions;

    private String description;
}
