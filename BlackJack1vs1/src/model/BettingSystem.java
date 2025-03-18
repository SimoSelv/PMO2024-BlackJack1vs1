package model;

/**
 * Manage the betting system*/
public class BettingSystem {
	private int chips;
	
	/**
	 * Constructs a betting system with initial number of chips
	 * @param startingChips the initial number of chips
	 * @throws IllegalArgumentException if the initial number of chips is negative*/
	public BettingSystem(int startingChips) {
		if (startingChips < 0) {
			throw new IllegalArgumentException("Initial chips cannot be negative");
		}
		
		this.chips = startingChips;
	}
	
	/**
	 * Places a bet
	 * @param bet The amount to bet
	 * @throws IllegalArgumentException if the bet is invalid (bet more chips than you have)
	 * */
	public void placeBet(int bet) {
		if (bet <= 0) {
			throw new IllegalArgumentException("Bet must be greater than zero");
		}
		if (bet > chips) {
			throw new IllegalArgumentException("Not enough chips for this bet");
		}
		
		chips -= bet;
	}
	
	/**
	 * Adds winnings to the player's chips
	 * @param chipsWon the amount won
	 * */
	public void win(int chipsWon) {
		chips += chipsWon;
	}
	
	/**
	 * Gets the current number of chips
	 * @return the number of chips
	 * */
	public int getChips() {
		return chips;
	}

}
