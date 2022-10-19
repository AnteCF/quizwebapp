package IndividualProject.controller;

import IndividualProject.business.CreateUserUseCase;
import IndividualProject.business.GetUserScoreUseCase;
import IndividualProject.business.GetUsersUseCase;
import IndividualProject.business.IncrementTotalScoreUseCase;
import IndividualProject.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})
public class UsersController {
    private final GetUsersUseCase getUsersUseCase;
    private final GetUserScoreUseCase getUserScoreUseCase;
    private final CreateUserUseCase createUserUseCase;
    private final IncrementTotalScoreUseCase incrementTotalScoreUseCase;

    //fix naming convention - no /all
    @GetMapping("/all")
        public ResponseEntity<GetUsersResponse> getUsers(){
        return ResponseEntity.ok(getUsersUseCase.getUsers());
    }

    @GetMapping
    public ResponseEntity<Integer> getUserScore(@RequestParam(value = "id") final Long id){
        return ResponseEntity.ok(getUserScoreUseCase.getUserScore(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(createUserUseCase.createUser(request));
    }

    @PutMapping("/score")
    public ResponseEntity<Void> editQuiz(@RequestBody IncrementUserScoreRequest request){
        incrementTotalScoreUseCase.incrementUserScore(request);
        return ResponseEntity.noContent().build();
    }
}
