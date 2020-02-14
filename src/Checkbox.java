import java.util.ArrayList;
import java.util.Collections;

public class Checkbox extends Question {

    Checkbox(String aQuestion, ArrayList<String> correctAnswers, ArrayList<String> otherAnswers) {
        super(aQuestion, correctAnswers, otherAnswers);
    }

    public void displayCheckboxQuestion(){
        String checkboxPrefix = "Checkbox - Type letter of each correct answer then hit ENTER," +
                " hit ENTER when done\n";
        checkboxPrefix += getQuestion();
        System.out.println(checkboxPrefix);
    }

    public void displayCheckboxAnswers() {

        ArrayList<String> allAnswers = new ArrayList<>();
        //add all answers to one arraylist
        allAnswers.addAll(getPossibleAnswers());
        allAnswers.addAll(getOtherIncorrect());
        //sort arraylist alphabetically
        Collections.sort(allAnswers);

        //add letter selection before each answer
            for (char alph = 'a'; alph <= 'z'; alph++) {
                int counter = 0;
                for (String answers : allAnswers) {
                    answers = alph + ": " + answers;
                    System.out.println(answers);
                    alph++;
                    counter++;
                //add correct answers with letter prefix back to original arraylist
                    for(int i = 0; i < getPossibleAnswers().size(); i++) {
                        if (answers.contains(getPossibleAnswers().get(i))) {
                            getPossibleAnswers().set(i, answers);
                        }
                    }
                }
                //stops iteration of alpha prefix
                if(counter == allAnswers.size()){
                    System.out.println("\n");
                    break;
                }
            }


    }

}
