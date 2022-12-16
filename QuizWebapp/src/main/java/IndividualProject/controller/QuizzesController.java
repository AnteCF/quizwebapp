package IndividualProject.controller;


import IndividualProject.business.*;
import IndividualProject.domain.CreateQuizRequest;
import IndividualProject.domain.DeleteQuizRequest;
import IndividualProject.domain.EditQuizRequest;
import IndividualProject.domain.GetQuizzesResponse;
import IndividualProject.domain.Quiz;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quizzes")
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})
public class QuizzesController {
    private final GetQuizzesUseCase getQuizzesUseCase;
    private final GetQuizByNameUseCase getQuizByNameUseCase;
    private final CreateQuizUseCase createQuizUseCase;
    private final DeleteQuizUseCase deleteQuizUseCase;
    private final EditQuizUseCase editQuizUseCase;
    private final GetQuizzesByCreatorIdUseCase getQuizzesByCreatorIdUseCase;
    private final GetQuizzesByRatingUseCase getQuizzesByRatingUseCase;

    @GetMapping("/{name}")
    public ResponseEntity<Quiz> getQuizByName(@PathVariable(value = "name") String name){
        return ResponseEntity.ok(getQuizByNameUseCase.getQuizByName(name));
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<GetQuizzesResponse> getQuizByName(@PathVariable(value = "rating") Float rating){
        return ResponseEntity.ok(getQuizzesByRatingUseCase.getQuizzesByRating(rating));
    }

    @GetMapping("/creator/{creatorId}")
    public ResponseEntity<GetQuizzesResponse> getQuizzesByCreatorId(@PathVariable(value = "creatorId") String creatorId){
        return ResponseEntity.ok(getQuizzesByCreatorIdUseCase.getQuizzesByCreatorId(creatorId));
    }

    @GetMapping()
    public ResponseEntity<GetQuizzesResponse> getQuizzes(){
        return ResponseEntity.ok(getQuizzesUseCase.getQuizzes());
    }

    @PostMapping
    public ResponseEntity<Boolean> createQuiz(@RequestBody CreateQuizRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(createQuizUseCase.createQuiz(request));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteQuiz(@RequestBody DeleteQuizRequest request){
        deleteQuizUseCase.deleteQuiz(request);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<String> editQuiz(@RequestBody EditQuizRequest request){
        return ResponseEntity.ok(editQuizUseCase.editQuiz(request));
    }
}