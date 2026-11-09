package model;

import java.util.Scanner;

/**
 * Represents the player in the Blackjack game.
 * It's controlled by user.
 */
public class UserPlayer extends Player {

    private Scanner input;

    /**
     * Constructs a UserPlayer with the specified name.
     * @param name The name of the player
     */
    public UserPlayer(String name) {
        super(name);
        this.input = new Scanner(System.in);
    }

    /**
     * Implements the player's decision-making process.
     * Returns true if the player chooses to "Hit" (draw another card),
     * or false if the player chooses to "Stand" (stop).
     * @return true for Hit, false for Stand
     */
    public boolean decideMove() {
        // Automatically Stand if the score is 21 or higher
        if (calculateScore() >= 21) {
            return false;
        }

        while (true) {
            System.out.println(name + ", your current score is: " + calculateScore());
            System.out.print("Do you want to Hit (H) or Stand (S)? ");
            String choice = input.nextLine().trim().toUpperCase();

            if (choice.equals("H")) {
                return true;
            } else if (choice.equals("S")) {
                return false;
            } else {
                System.out.println("Invalid choice. Please enter 'H' for Hit or 'S' for Stand.");
            }
        }
    }

}
