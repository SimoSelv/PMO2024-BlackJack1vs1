package main;

import model.Game;
import java.util.Scanner;

/**
 * Main entry point for the console-based Blackjack 1vs1 game.
 * Dynamically requests player preferences upon startup.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("   WELCOME TO BLACKJACK 1VS1     ");
        System.out.println("=================================\n");

        // 1. Richiesta del nome
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine().trim();
        if (playerName.isEmpty()) {
            playerName = "Player";
        }

        // 2. Richiesta delle fiches iniziali
        int initialChips = 500; // Valore di fallback
        System.out.print("Enter starting chips (default 500): ");
        String chipsInput = scanner.nextLine().trim();
        if (!chipsInput.isEmpty()) {
            try {
                initialChips = Integer.parseInt(chipsInput);
                if (initialChips <= 0) {
                    System.out.println("Chips must be positive. Defaulting to 500.");
                    initialChips = 500;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Defaulting to 500 chips.");
            }
        }

        // 3. Richiesta del numero di mazzi
        int numDecks = 1; // Valore di fallback
        System.out.print("Enter number of decks (1 to 6, default 1): ");
        String decksInput = scanner.nextLine().trim();
        if (!decksInput.isEmpty()) {
            try {
                numDecks = Integer.parseInt(decksInput);
                if (numDecks < 1 || numDecks > 6) {
                    System.out.println("Number of decks must be between 1 and 6. Defaulting to 1.");
                    numDecks = 1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Defaulting to 1 deck.");
            }
        }

        System.out.println("\n---------------------------------");
        System.out.println("Initializing game for " + playerName + " with " + initialChips + " chips and " + numDecks + " deck(s)...");
        System.out.println("---------------------------------\n");

        // Inizializzazione dinamica del gioco
        Game blackjack = new Game(numDecks, initialChips, playerName);

        // Avvio del loop di gioco
        blackjack.play();
        
        scanner.close();
    }
}