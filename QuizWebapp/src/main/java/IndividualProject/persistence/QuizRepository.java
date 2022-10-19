package IndividualProject.persistence;

import IndividualProject.persistence.entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<QuizEntity, String> {
}