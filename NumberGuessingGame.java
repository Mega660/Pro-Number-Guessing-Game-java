
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    static int highScore = Integer.MAX_VALUE;

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            Random random = new Random();
            boolean playAgain = true;

            System.out.println("🎯 WELCOME TO THE PRO NUMBER GUESSING GAME 🎯");

            while (playAgain) {

                int maxNumber = chooseDifficulty(sc);
                int numberToGuess = random.nextInt(maxNumber) + 1;
                int attempts = 0;
                int maxAttempts = 7;
                boolean guessed = false;

                System.out.println("\nI picked a number between 1 and " + maxNumber);
                System.out.println("You have " + maxAttempts + " attempts!");

                while (attempts < maxAttempts && !guessed) {
                    System.out.print("Enter your guess: ");
                    int guess = sc.nextInt();
                    attempts++;

                    if (guess < numberToGuess) {
                        System.out.println("⬆ Too low!");
                    } else if (guess > numberToGuess) {
                        System.out.println("⬇ Too high!");
                    } else {
                        guessed = true;
                        System.out.println("✅ CORRECT! You guessed in " + attempts + " attempts!");

                        if (attempts < highScore) {
                            highScore = attempts;
                            System.out.println("🏆 NEW HIGH SCORE!");
                        }
                    }

                    System.out.println("Attempts left: " + (maxAttempts - attempts));
                }

                if (!guessed) {
                    System.out.println("❌ Game Over! The number was: " + numberToGuess);
                }

                System.out.println("🔥 Current High Score: "
                        + (highScore == Integer.MAX_VALUE ? "None yet" : highScore));

                System.out.print("\nPlay again? (yes/no): ");
                sc.nextLine(); // consume newline
                String response = sc.nextLine();
                playAgain = response.equalsIgnoreCase("yes");
            }

            System.out.println("👋 Thanks for playing!");
        }
    }

    static int chooseDifficulty(Scanner sc) {
        System.out.println("\nSelect Difficulty:");
        System.out.println("1. Easy (1 - 50)");
        System.out.println("2. Medium (1 - 100)");
        System.out.println("3. Hard (1 - 200)");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> {
                return 50;
            }
            case 2 -> {
                return 100;
            }
            case 3 -> {
                return 200;
            }
            default -> {
                System.out.println("Invalid choice. Defaulting to Medium.");
                return 100;
            }
        }
    }
}
