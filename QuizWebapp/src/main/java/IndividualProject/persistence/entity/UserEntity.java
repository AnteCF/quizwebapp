package IndividualProject.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "quizzes")
public class UserEntity {

    @NotBlank
    @Length(min = 1, max = 20)
    @Column(name = "name")
    private String name;

    @NotBlank
    @Length(min = 4, max = 5)
    @Column(name = "role")
    private String role;

    @NotBlank
    @Length(min = 1, max = 50)
    @Column(name = "password")
    private String password;

    @NotBlank
    @Id
    @Column(name = "id")
    private long id;

    @NotBlank
    @Length(min = 1, max = 20)
    @Column(name = "totalScore")
    private Integer totalScore;

}
