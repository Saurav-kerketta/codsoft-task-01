import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    // Quiz question class
    static class QuizQuestion {
        String question;
        String[] options;
        char correctAnswer;

        public QuizQuestion(String question, String[] options, char correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }

    // Define quiz questions
    static QuizQuestion[] questions = {
        new QuizQuestion("What is the capital of France?", new String[] {"A. Paris", "B. London", "C. Rome", "D. Madrid"}, 'A'),
        new QuizQuestion("Who wrote 'Romeo and Juliet'?", new String[] {"A. William Shakespeare", "B. Charles Dickens", "C. Mark Twain", "D. J.K. Rowling"}, 'A'),
        new QuizQuestion("What is the largest planet in our solar system?", new String[] {"A. Earth", "B. Mars", "C. Jupiter", "D. Saturn"}, 'C')
    };

    static int score = 0;
    static int currentQuestionIndex = 0;
    static boolean answerSubmitted = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (QuizQuestion question : questions) {
            answerSubmitted = false;
            System.out.println("You have 10 seconds to answer each question.");
            displayQuestion(question);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (!answerSubmitted) {
                        System.out.println("Time's up!");
                        currentQuestionIndex++;
                    }
                }
            }, 10000);

            char userAnswer = scanner.next().charAt(0);
            answerSubmitted = true;
            timer.cancel();

            if (userAnswer == question.correctAnswer) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect! The correct answer was: " + question.correctAnswer);
            }
            currentQuestionIndex++;
        }

        displayResults();
        scanner.close();
    }

    static void displayQuestion(QuizQuestion question) {
        System.out.println(question.question);
        for (String option : question.options) {
            System.out.println(option);
        }
        System.out.print("Enter your answer (A, B, C, or D): ");
    }

    static void displayResults() {
        System.out.println("\nQuiz Over!");
        System.out.println("Your final score is: " + score + " out of " + questions.length);
    }
}
