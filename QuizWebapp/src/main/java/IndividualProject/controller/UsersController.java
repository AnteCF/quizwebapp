package IndividualProject.controller;

import IndividualProject.business.GetUserScoreUseCase;
import IndividualProject.business.GetUsersUseCase;
import IndividualProject.domain.GetUsersResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})
public class UsersController {
    private final GetUsersUseCase getUsersUseCase;
    private final GetUserScoreUseCase getUserScoreUseCase;

    //fix naming convention - no /all
    @GetMapping("/all")
        public ResponseEntity<GetUsersResponse> getUsers(){
        return ResponseEntity.ok(getUsersUseCase.getUsers());
    }

    @GetMapping
    public ResponseEntity<Integer> getUserScore(@RequestParam(value = "id") final Long id){
        return ResponseEntity.ok(getUserScoreUseCase.getUserScore(id));
    }
}
