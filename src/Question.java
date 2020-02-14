import java.util.ArrayList;

public class Question {

    private String question;
    private ArrayList<String> possibleAnswers;
    private ArrayList<String> otherIncorrect;

    Question(String aQuestion, ArrayList<String> correctAnswers, ArrayList<String> otherAnswers) {
        this.question = aQuestion;
        this.possibleAnswers = correctAnswers;
        this.otherIncorrect = otherAnswers;
    }

    public String getQuestion(){
        return question;
    }

    public ArrayList<String> getPossibleAnswers(){
        return possibleAnswers;
    }

    public ArrayList<String> getOtherIncorrect(){
        return otherIncorrect;
    }

}
