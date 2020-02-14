import java.util.ArrayList;
import java.util.Collections;

public class MultipleChoice extends Question {

    MultipleChoice(String aQuestion, ArrayList<String> correctAnswers, ArrayList<String> wrongAnswers) {
        super(aQuestion, correctAnswers, wrongAnswers);
    }

    public void displayMCQuestion(){
        String multipleChoicePrefix = "Multiple Choice - Type letter of answer\n";
        multipleChoicePrefix += getQuestion();
        System.out.println(multipleChoicePrefix);
    }

    public void displayMCAnswers() {

        ArrayList<String> allAnswers = new ArrayList<>();

        allAnswers.addAll(getPossibleAnswers());
        allAnswers.addAll(getOtherIncorrect());
        Collections.sort(allAnswers);

        for (char alph = 'a'; alph <= 'z'; alph++) {
            int counter = 0;

            for (String answers : allAnswers) {
                answers = alph + ": " + answers;
                System.out.println(answers);
                alph++;
                counter++;
                //add correct answers with letter prefix back to original arraylist
                if(answers.contains(getPossibleAnswers().get(0))){
                    getPossibleAnswers().set(0, answers);
                }
            }
            //stops iteration of alpha prefix
            if (counter == allAnswers.size()) {
                System.out.println("\n");
                break;
            }
        }
    }

}
