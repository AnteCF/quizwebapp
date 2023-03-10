/*
package IndividualProject.persistence.implementation;

import IndividualProject.domain.CreateQuizRequest;
import IndividualProject.domain.DeleteQuizRequest;
import IndividualProject.domain.EditQuizRequest;
import IndividualProject.persistence.DatabaseAccess;
import IndividualProject.domain.Quiz;
import IndividualProject.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FakeDataStoreImpl implements DatabaseAccess {
    private List<User> users = new ArrayList<>();
    private List<Quiz> quizzes = new ArrayList<>();

    public FakeDataStoreImpl(){
        this.users.add(User.builder().name("Ante").id(1).totalScore(10).build());
        this.users.add(User.builder().name("Luka").id(2).build());

        Map<Integer, String> quizOne = new HashMap<>();
        quizOne.put(1,"What date did world war 2 start?");
        quizOne.put(2,"What date did world war 1 start");

        Map<Integer, List<String>> quizOneAnswers = new HashMap<>();
        List<String> answersOne = new ArrayList<>();
        answersOne.add("question one answer one");
        answersOne.add("question one answer two");
        answersOne.add("question one answer three");
        answersOne.add("question one answer four");
        quizOneAnswers.put(1,answersOne);

        List<String> answersTwo = new ArrayList<>();
        answersTwo.add("question two answer one");
        answersTwo.add("question two answer two");
        answersTwo.add("question two answer three");
        answersTwo.add("question two answer four");
        quizOneAnswers.put(2, answersTwo);

        List<Integer> correctAnswers = new ArrayList<>();
        correctAnswers.add(1);
        correctAnswers.add(2);


        this.quizzes.add(Quiz.builder().name("history").questions(quizOne).possibleAnswers(quizOneAnswers).correctAnswers(correctAnswers).creatorId(1L).rating(2F).description("A fun quiz about history").build());

        Map<Integer, String> quizTwo =new HashMap<>();
        quizTwo.put(1,"What continent is the Netherlands on?");

        this.quizzes.add(Quiz.builder().name("geography").questions(quizOne).creatorId(1L).rating(2F).description("A fun quiz about geography").build());
    }

    @Override
    public User getUserById(Long id){
        for (User u : users){
            if(u.getId()==id) return u;
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    @Override
    public Quiz getQuizByName(String name){
        for (Quiz q : quizzes){
            if(q.getName().equals(name)) return q;
        }
        return null;
    }

    @Override
    public Boolean createQuiz(CreateQuizRequest request)
    {
        this.quizzes.add(Quiz.builder().name(request.getName()).questions(request.getQuestions()).correctAnswers(request.getCorrectAnswers())
                .creatorId(request.getCreatorId()).rating(0F).description(request.getDescription()).build());
        return true;
    }

    @Override
    public void deleteQuiz(DeleteQuizRequest request){
        for (Quiz q : quizzes){
            if(q.getName().equals(request.getName()) && q.getCreatorId().equals(request.getCreatorId())){
                quizzes.remove(q);
            }
        }
    }

    @Override
    public Integer getUserScore(Long id){
        for (User u : users){
            if(u.getId() == id)
                return u.getTotalScore();
        }
        return null;
    }

    @Override
    public String editQuiz(EditQuizRequest request){
        for (Quiz q : quizzes){
            if(q.getName().equals(request.getName()) && q.getCreatorId().equals(request.getCreatorId())){
                quizzes.remove(q);
                quizzes.add(Quiz.builder().name(request.getName()).questions(request.getQuestions()).correctAnswers(request.getCorrectAnswers())
                        .creatorId(request.getCreatorId()).rating(0F).description(request.getDescription()).build());
                return request.getName();
            }
        }
        return "failed";
    }
}

*/
