import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int score = 0;
        
        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            
            
            // Limit the number of attempts
            int attemptsLeft = 10;
            
   
            
            boolean guessedCorrectly = false;
            
            System.out.println("I have generated a number between 1 and 100. Can you guess it?");
            
            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations User! You guessed the number correctly.");
                    guessedCorrectly = true;
                    
                 // More attempts left means better score
                    score += attemptsLeft; 
                    break;
                } else if (userGuess < numberToGuess) {
                	
                    System.out.println("Too low Number! Try again the new number.");
                } else {
                    System.out.println("Too high Number! Try again the new number.");
                }
                
                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, your limit of attempt is over.\nThe number was: " + numberToGuess);
            }
            
            System.out.println("Your current score is: " + score);
            System.out.print("Do you want to play it again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }
        
        System.out.println("Thank You user for playing! Your final score is: " + score);
        scanner.close();
    }
}
