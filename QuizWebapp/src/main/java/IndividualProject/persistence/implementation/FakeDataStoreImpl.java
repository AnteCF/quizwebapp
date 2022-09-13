package IndividualProject.persistence.implementation;

import IndividualProject.persistence.FakeDataStore;
import IndividualProject.persistence.entity.Quiz;
import IndividualProject.persistence.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FakeDataStoreImpl implements FakeDataStore {
    private List<User> users;
    private List<Quiz> quizzes;

public FakeDataStoreImpl(){
 this.users.add(User.builder().name("Ante").role("user").id(1).totalScore(10L).build());
 this.users.add(User.builder().name("Luka").role("user").id(2).build());

Map<Integer, String> quizOne =new HashMap<>();
quizOne.put(1,"What date did world war 2 start?");
quizOne.put(2,"What date did world war 1 start");

 this.quizzes.add(Quiz.builder().name("history").questions(quizOne).creatorId(1L).rating(2F).description("A fun quiz about history").build());
}

    public User getUserById(Long id){
        for (User u : users){
            if(u.getId()==id) return u;
        }
        return null;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public Quiz getQuizByName(String name){
    for (Quiz q : quizzes){
        if(q.getName()==name) return q;
    }
    return null;
    }
}
