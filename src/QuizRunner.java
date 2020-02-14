
import java.util.ArrayList;


public class QuizRunner {
    public static void main(String[] args) {

        //Multiple choice example
        ArrayList<String> correctMCAnswer = new ArrayList<>();
        ArrayList<String> wrongMCAnswers = new ArrayList<>();
        wrongMCAnswers.add("Medusa");
        correctMCAnswer.add("Hera");
        wrongMCAnswers.add("Hermes");
        wrongMCAnswers.add("Aphrodite");

        MultipleChoice greek = new MultipleChoice("Who is the wife of Zeus?", correctMCAnswer, wrongMCAnswers);


//        //Checkbox example
        ArrayList<String> correctCheckboxAnswers = new ArrayList<>();
        ArrayList<String> wrongCheckboxAnswers = new ArrayList<>();
        correctCheckboxAnswers.add("Pineapple");
        correctCheckboxAnswers.add("Ham");
        wrongCheckboxAnswers.add("Onion");
        wrongCheckboxAnswers.add("Mushroom");
        wrongCheckboxAnswers.add("Bacon");
//
        Checkbox hawaiian = new Checkbox(
              "What toppings belong on a Hawaiian pizza?",
              correctCheckboxAnswers,
              wrongCheckboxAnswers);


        //True or False example
        ArrayList<String> correctAnswerTF = new ArrayList<>();
        ArrayList<String> incorrectAnswerTF = new ArrayList<>();
        correctAnswerTF.add("True");
        incorrectAnswerTF.add("False");
//
        TrueOrFalse marriage = new TrueOrFalse(
                "Marriage is the number one cause of divorce.",
                correctAnswerTF,
                incorrectAnswerTF);

        ArrayList<String> correctAnswerTFTwo = new ArrayList<>();
        ArrayList<String> incorrectAnswerTFTwo = new ArrayList<>();
        incorrectAnswerTFTwo.add("True");
        correctAnswerTFTwo.add("False");

        TrueOrFalse solveForX = new TrueOrFalse(
                "In the equation : x+(3x-2)=18, x is equal to 9:",
                correctAnswerTFTwo,
                incorrectAnswerTFTwo);

        Quiz firstQuiz = new Quiz("Practice");
        firstQuiz.addQuizQuestion(solveForX);
        firstQuiz.addQuizQuestion(hawaiian);
        firstQuiz.addQuizQuestion(marriage);
        firstQuiz.addQuizQuestion(greek);
        firstQuiz.runQuiz();
        firstQuiz.scoreQuiz();

    }
}
