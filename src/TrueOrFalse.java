import java.util.ArrayList;
import java.util.Collections;

public class TrueOrFalse extends Question{


    TrueOrFalse(String aQuestion, ArrayList<String> correctAnswers, ArrayList<String> otherAnswers) {
        super(aQuestion, correctAnswers, otherAnswers);
    }

    public void displayTFQuestion(){
        System.out.println("True or False - Type 't' for true or 'f' for false\n" + getQuestion());
    }

    public void displayTFAnswer(){
        ArrayList<String> sortedTF = new ArrayList<>();
        if(getPossibleAnswers().get(0).contains("True") && getOtherIncorrect().get(0).contains("False")){
            getPossibleAnswers().set(0, "T- True");
            getOtherIncorrect().set(0, "F- False");
        } else {
            getPossibleAnswers().set(0, "F- False");
            getOtherIncorrect().set(0, "T- True");
        }

        sortedTF.addAll(getPossibleAnswers());
        sortedTF.addAll(getOtherIncorrect());
        Collections.sort(sortedTF, Collections.reverseOrder());
        System.out.println("\n" + sortedTF.get(0) +
                            "\n" + sortedTF.get(1));
    }

}
