package model;

import java.util.Scanner;

/**
 * Orchestrates the Blackjack game logic, managing the player, dealer, deck, and betting.
 */
public class Game {
    private Deck deck;
    private UserPlayer player;
    private DealerCPU dealer;
    private BettingSystem bettingSystem;
    private int currentBet;
    private Scanner scanner;

    /**
     * Initializes a new Game with the specified number of decks, initial chips and player's name.
     * @param numDecks Number of 52-card decks to use
     * @param initialChips Starting amount of chips for the player
     * @param playerName Custom name for the user player
     */
    public Game(int numDecks, int initialChips, String playerName) {
        this.deck = new Deck(numDecks);
        this.player = new UserPlayer(playerName);
        this.dealer = new DealerCPU();
        this.bettingSystem = new BettingSystem(initialChips);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Starts a new hand, resetting players' hands and shuffling if necessary.
     */
    public void startHand() {
        System.out.println("\n--- New Hand Starting ---");
        player.clearHand();
        dealer.clearHand(); 
        
        // TODO reshuffle if the deck is low
        // For now, we assume the deck is sufficient
    }

    /**
     * Handles the betting phase.
     */
    public void placeBet() {
        System.out.println("Current chips: " + bettingSystem.getChips());
        boolean validBet = false;
        
        while (!validBet) {
            try {
                System.out.print("Enter your bet: ");
                int amount = Integer.parseInt(scanner.nextLine());
                bettingSystem.placeBet(amount);
                this.currentBet = amount;
                validBet = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid bet: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    /**
     * Deals the first two cards to both player and dealer.
     */
    public void initialCards() {
        player.drawCard(deck.takeOutCard());
        dealer.drawCard(deck.takeOutCard());
        player.drawCard(deck.takeOutCard());
        dealer.drawCard(deck.takeOutCard());

        System.out.println("Cards dealt.");
        System.out.println("Player's hand: " + player.calculateScore() + " " + player.toString());
        // In Blackjack, one dealer card is usually hidden, but here we show the initial state
    }

    /**
     * Logic for the player's turn.
     */
    private void playerTurn() {
        while (player.calculateScore() < 21 && player.decideMove()) {
            player.drawCard(deck.takeOutCard());
            System.out.println("Player draws a card. New state: " + player.toString());
        }
    }

    /**
     * Logic for the dealer's turn.
     */
    public void dealerTurn() {
        System.out.println("Dealer's turn...");
        dealer.playTurn(deck);
        System.out.println("Dealer's final hand: " + dealer.toString());
    }

    /**
     * Determines the winner and updates the betting system.
     */
    public void winnerIs() {
        int playerScore = player.calculateScore();
        int dealerScore = dealer.calculateScore();

        System.out.println("\n--- Final Results ---");
        System.out.println("Player Score: " + playerScore);
        System.out.println("Dealer Score: " + dealerScore);

        if (playerScore > 21) {
            System.out.println("Player Busts! Dealer wins.");
        } else if (dealerScore > 21 || playerScore > dealerScore) {
            System.out.println("Player wins!");
            bettingSystem.win(currentBet * 2);
        } else if (playerScore < dealerScore) {
            System.out.println("Dealer wins.");
        } else {
            System.out.println("It's a Tie (Push). Bet returned.");
            bettingSystem.win(currentBet);
        }
    }

    /**
     * Asks if the player wants to play another hand.
     * @return true if yes, false if no or out of chips
     */
    private boolean nextHand() {
        if (bettingSystem.getChips() <= 0) {
            System.out.println("You are out of chips! Game Over.");
            return false;
        }
        
        System.out.print("Do you want to play another hand? (Y/N): ");
        String choice = scanner.nextLine().trim().toUpperCase();
        return choice.equals("Y");
    }

    /**
     * Main game loop to run the game in console mode.
     */
    public void play() {
        boolean keepPlaying = true;
        while (keepPlaying) {
            startHand();
            placeBet();
            initialCards();
            
            playerTurn();
            
            if (player.calculateScore() <= 21) {
                dealerTurn();
            }
            
            winnerIs();
            keepPlaying = nextHand();
        }
        System.out.println("Thanks for playing!");
    }
}