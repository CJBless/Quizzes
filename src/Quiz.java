import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {

    String quizName;
    public ArrayList<Question> fullQuiz = new ArrayList<>();
    public ArrayList<Double> tally = new ArrayList<>();

    Quiz(String aQuizName){
        this.quizName = aQuizName;
    }

    public void addQuizQuestion(Question questionAnswer){
        fullQuiz.add(questionAnswer);
    }

    public void runQuiz(){
        Scanner input;
        String userAnswer;
        System.out.println("WELCOME TO THE " + quizName + " QUIZ!\n");
        input = new Scanner(System.in);
        for(Question aQuestion : fullQuiz){
            String className = aQuestion.getClass().getName();

            String correctAnswer;

            if(className.equals("TrueOrFalse")){
                TrueOrFalse tFQuestion = (TrueOrFalse)aQuestion;
                tFQuestion.displayTFQuestion();
                tFQuestion.displayTFAnswer();
                correctAnswer = tFQuestion.getPossibleAnswers().get(0);

                userAnswer = input.nextLine();
                if(correctAnswer.startsWith(userAnswer.toUpperCase())){
                    tally.add(1.0);
                    System.out.println("Correct!\n");
                } else {
                    tally.add(0.0);
                    System.out.println("Incorrect\n");
                }
            }else if(className.equals("MultipleChoice")){
                MultipleChoice mPQuestion = (MultipleChoice)aQuestion;
                mPQuestion.displayMCQuestion();
                mPQuestion.displayMCAnswers();
                correctAnswer = mPQuestion.getPossibleAnswers().get(0);

                userAnswer = input.nextLine();
                if(correctAnswer.startsWith(userAnswer.toLowerCase())){
                    tally.add(1.0);
                    System.out.println("Correct!\n");
                } else {
                    tally.add(0.0);
                    System.out.println("Incorrect\n");
                }
            }else if(className.equals("Checkbox")){
                Checkbox cBQuestion = (Checkbox)aQuestion;
                cBQuestion.displayCheckboxQuestion();
                cBQuestion.displayCheckboxAnswers();
                int totalCheck = 0;
                ArrayList<String> inputCount = new ArrayList<>();
                //get user input while not "", compares input with correct answers
                do {
                    userAnswer = input.nextLine();
                    inputCount.add(userAnswer);
                    for (String options : cBQuestion.getPossibleAnswers()) {
                        String optionsChar = options.substring(0, 1);
                        if(userAnswer.equalsIgnoreCase(optionsChar)) {
                            totalCheck++;
                        }
                    }
                }while(!userAnswer.isEmpty());

                if(totalCheck == cBQuestion.getPossibleAnswers().size() && inputCount.size() == cBQuestion.getPossibleAnswers().size() + 1){
                    tally.add(1.0);
                    System.out.println("Correct!\n");
                } else {
                    tally.add(0.0);
                    System.out.println("Incorrect\n");
                }
            }

        }
        input.close();
    }

    public void scoreQuiz(){
        Double score = 0.0;
        for(Double points : tally){
            score += points;
        }
        score = (score/tally.size())*100.0;
        System.out.println("You scored a " + score);
    }

}
