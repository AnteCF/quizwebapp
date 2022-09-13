package IndividualProject.persistence.entity;


import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class Quiz {

    private String name;
    private Map<Integer, String> questions;
    private Long creatorId;
    private Float rating;
    private String description;
}
