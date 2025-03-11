package model;

/*Represents a single playing card in the Blackjack game*/

public class Card {
	private String suit; 	//The suit of the card: Hearts, Diamonds, Clubs, Spades
	private String value; 	//The value of the card: A, K, Q, J, 10, ... , 2

	/*
	 * Constructs a Card with the given suit and value
	 * @param suit The suit of the card ("Hearts", "Diamonds", "Clubs", "Spades")
	 * @param value The value of the card ("A", "K", "Q", "J", "10", ... , "2")
	 * */
	public Card(String suit, String value) {
		this.suit = suit;
		this.value = value;
		
	}

	/**
	 * Gets the suit of the card
	 * @return The suit of the card 
	 */
	public String getSuit() {
		return suit;
	}

	/**
	 * Gets the value of the card
	 * @return The value of the card
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Calculates the point value of the card
	 * @return The point value of the card*/
	public int getPoints() {
		switch(value) {
		case "A": return 11; /*Ace can be 1 or 11, but this will be handled in the "Player" class*/
		case "K": return 10;
		case "Q": return 10;
		case "J": return 10;
		default: return Integer.parseInt(value); /*Convert value card to int*/
		}
	}
	
	@Override
	public String toString() {
		return value + " of " + suit;
	}
	
}
