package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	protected String name;
	protected List<Card> hand;
	
	/**
	 * Constructor for a Player 
	 * @param name The player's name
	 * */
	public Player(String name) {
		this.name = name;
		this.hand = new ArrayList<>();
	}
	
	/**
	 * Adds a card to the player's hand
	 * @param card The card to be added
	 * */
	public void drawCard(Card card) {
		hand.add(card);
	}
	
	/**
     * Clears the cards in the player's hand for a new round.
     */
    public void clearHand() {
        this.hand.clear();
    }
	
	/**
	 * Calculates the total score of the player's hand
	 * @return The total score
	 * */
	public int calculateScore() {
		int score = 0;
		int aceCount = 0;
		
		for (Card card : hand) {
			score += card.getPoints();
			if (card.getValue().equals("A")) {
				aceCount++;
			}
		}
		
		/*Correct Ace's point: default they count 11
		 *  but when the score is over 21, they count 1*/
		while (score > 21 && aceCount > 0) {
			score -= 10;
			aceCount--;
		}
		
		return score;
		
	}
	
	
	
}
