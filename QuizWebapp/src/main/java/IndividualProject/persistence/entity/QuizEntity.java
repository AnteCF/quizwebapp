package IndividualProject.persistence.entity;



import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "quizzes")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class QuizEntity {

    @NotBlank
    @Id
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Type(type = "json")
    @Column(name = "questions")
    private Map<Integer, String> questions;

    @Min(0)
    @Column(name = "creatorId")
    private Long creatorId;

    @Digits(integer = 1, fraction = 2)
    @Column(name = "rating")
    private Float rating;

    @NotBlank
    @Column(name = "description")
    private String description;

    @NotEmpty
    @Type(type = "json")
    @Column(name = "possibleAnswers")
    private Map<Integer, List<String>> possibleAnswers;

    @NotEmpty
    @Type(type = "json")
    @Column(name = "correctAnswers")
    private List<Integer> correctAnswers;

}
