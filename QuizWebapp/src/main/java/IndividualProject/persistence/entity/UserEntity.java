package IndividualProject.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "role")
    private String role;

    @NotBlank
    @Column(name = "password")
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Min(0)
    @Column(name = "totalScore")
    private Integer totalScore;

}
