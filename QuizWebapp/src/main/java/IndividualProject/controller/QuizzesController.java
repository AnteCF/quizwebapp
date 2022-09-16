package IndividualProject.controller;


import IndividualProject.business.GetQuizByNameUseCase;
import IndividualProject.business.GetQuizzesUseCase;
import IndividualProject.domain.GetQuizzesResponse;
import IndividualProject.persistence.entity.Quiz;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quizzes")
@AllArgsConstructor
public class QuizzesController {
    private final GetQuizzesUseCase getQuizzesUseCase;
    private final GetQuizByNameUseCase getQuizByNameUseCase;

    @GetMapping("{name}")
    public ResponseEntity<Quiz> getQuizByName(@PathVariable(value = "name") final String name){
        return ResponseEntity.ok(getQuizByNameUseCase.getQuizByName(name));
    }

    @GetMapping("/all")
    public ResponseEntity<GetQuizzesResponse> getQuizzes(){
        return ResponseEntity.ok(getQuizzesUseCase.getQuizzes());
    }

}
