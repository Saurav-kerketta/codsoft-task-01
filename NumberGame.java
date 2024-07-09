import java.util.Random;
import java.util.Scanner;

public class RandomNumberGuessingGame {
    public static void main(String[] args) {
        // Define the range
        int min = 1;
        int max = 100;
        int maxAttempts = 3; // Maximum number of attempts per round
        int score = 0; // User's score

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        while (playAgain) {
            // Generate a random number within the specified range
            int randomNumber = random.nextInt((max - min) + 1) + min;
            int attempts = 0;
            boolean correctGuess = false;

            System.out.println("A new round has started! You have " + maxAttempts + " attempts to guess the number.");

            // Loop until the user guesses correctly or runs out of attempts
            while (attempts < maxAttempts && !correctGuess) {
                System.out.println("Guess a number between " + min + " and " + max + ": ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
                    correctGuess = true;
                    score += maxAttempts - attempts + 1; // Increase score based on attempts remaining
                }
            }

            if (!correctGuess) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + randomNumber);
            }

            System.out.println("Your current score is: " + score);

            // Ask if the user wants to play another round
            System.out.println("Do you want to play another round? (yes/no)");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}
