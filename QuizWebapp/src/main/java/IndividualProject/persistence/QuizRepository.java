package IndividualProject.persistence;

import IndividualProject.persistence.entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<QuizEntity, String> {
    List<QuizEntity> findAllByCreatorId(Long creatorId);

    List<QuizEntity> findAllByRatingGreaterThanEqual(Float rating);
}
