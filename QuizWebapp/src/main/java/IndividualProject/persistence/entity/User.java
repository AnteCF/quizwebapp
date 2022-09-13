package IndividualProject.persistence.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String name;
    private String role;
    private long id;
    private long totalScore;

}
