package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represent a deck of playing cards for the Blackjack game
 * */

public class Deck {
	private List<Card> cards;
	
	/**
	 * Create a deck with the specified number of decks with 52 cards
	 * @param numDecks The number of standard decks to include in this deck
	 * */
	public Deck(int numDecks) {
		cards = new ArrayList<>();
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
		String[] values = {"A", "K", "Q", "J", "10", "9", "8", "7", "6",
				"5", "4", "3", "2"};
		
		for (int i =0; i < numDecks; i++) {
			for (String suit : suits) {
				for (String value : values) {
					cards.add(new Card(suit,value));
				}
			}
		}
	}
	
	/**
	 * Shuffles the deck randomly
	 * */
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	/**
	 * Draws a card from the top of the deck.
	 * @return the draw card 
	 * @throws IllegalStateException if the deck is empty*/
	
	public Card drawCard() {
		if (cards.isEmpty()) {
			throw new IllegalStateException("The deck is empty!");
			/*TODO gestire errore (non dovrei mai arrivare ad avere il mazzo vuoto
			 * perchè a metà mazzo lo ricreo) e creare nuovo mazzo in automatico (???)*/
		}
		return cards.remove(0);
	}
	
	/**
	 * Return the number of cards in the deck
	 * @return cards in the deck
	 * */
	public int size() {
		return cards.size();
	}
	
	
	
}
