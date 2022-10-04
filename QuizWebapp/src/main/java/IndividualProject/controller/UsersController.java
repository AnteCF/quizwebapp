package IndividualProject.controller;

import IndividualProject.business.GetUserScoreUseCase;
import IndividualProject.business.GetUsersUseCase;
import IndividualProject.domain.GetUsersResponse;
import IndividualProject.persistence.entity.Quiz;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {
    private final GetUsersUseCase getUsersUseCase;
    private final GetUserScoreUseCase getUserScoreUseCase;

    @GetMapping("/all")
        public ResponseEntity<GetUsersResponse> getUsers(){
        return ResponseEntity.ok(getUsersUseCase.getUsers());
    }

    @GetMapping
    public ResponseEntity<Integer> getUserScore(@RequestParam(value = "id") final Long id){
        return ResponseEntity.ok(getUserScoreUseCase.getUserScore(id));
    }
}
