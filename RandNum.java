//Importing required packages for generating random Numbers:
import java.util.Random;
import java.util.Scanner;

public class RandNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random randomnum = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        
        System.out.println("Welcome to the NUMBER GUESSING GAME!");

        while (playAgain) {
        	// Generate a random number in the range of 1 to 100:
            int randomNumber = randomnum.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean isGuessed = false;

            System.out.println("\nI've generated a random number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess number!");

            // Limit the number of attempts the user has to guess the number.
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int youGuess = scanner.nextInt();
                attempts++;

                // Check the player's guess:
                if (youGuess == randomNumber) {
                    System.out.println("Congratulations! You have guessed the number correctly in " + attempts + " attempts.");
                    totalScore += (maxAttempts - attempts + 1);
                    isGuessed = true;
                    break;
                    
                   /* Compare the player's guess with the generated number and provide feedback on whether the guess
                    is correct, too high, or too low.*/
                    
                } else if (youGuess > randomNumber) {
                    System.out.println("Too high number! Try another number.");
                } else {
                    System.out.println("Too low number! Try another number.");
                }
            }

            // If palyer didn't guess the number:
            if (!isGuessed) {
                System.out.println("Sorry, you've used all " + maxAttempts + " your attempts. The correct number was: " + randomNumber);
            }

           // The option for multiple rounds, allowing the user to play again:
            System.out.print("\n Do you want to play another round? (yes/no): ");
            scanner.nextLine();
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");

            // Display the user's score, which can be based on the number of attempts taken or rounds won:
            System.out.println("Your current score is: " + totalScore);
        }

        // Final message to player:
        System.out.println("\n Thank you for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}
