package model;
/**
 * Represents the dealer in the Blackjack game.
 * It's controlled by CPU
 * */

public class DealerCPU extends Player {
	
	/**Constructs a DealerCPU with default name*/
	public DealerCPU() {
		super("Dealer");
	}
	
	/**
	 * The dealers draw cards until his score is under 17
	 * @param deck The deck from which the dealer draws cards
	 * */
	public void playTurn(Deck deck) {
		while (calculateScore() < 17) {
			drawCard(deck.takeOutCard());
		}
	}
	
}
