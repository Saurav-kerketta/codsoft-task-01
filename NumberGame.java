import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int numberOfAttempts = 10;
        boolean playAgain = true;
        int score = 0;

        while (playAgain) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attemptsLeft = numberOfAttempts;

            System.out.println("Welcome to the Number Game!");
            System.out.println("I have generated a random number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + attemptsLeft + " attempts to guess the number.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score++;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attemptsLeft--;
            }

            if (attemptsLeft == 0) {
                System.out.println("Sorry, you ran out of attempts. The correct number was " + generatedNumber + ".");
            }

            System.out.println("Your score is: " + score);
            System.out.print("Do you want to play again? (Y/N): ");
            String playAgainInput = scanner.next();

            if (!playAgainInput.equalsIgnoreCase("Y")) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing!");
    }
}