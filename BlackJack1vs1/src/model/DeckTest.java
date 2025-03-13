
package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * Unit tests for the Deck class
 */
class DeckTest {
	private Deck deck;
	
	/**
	 * create a standard deck with 52 cards*/
	@BeforeEach
	void createStdDeck() {
		deck = new Deck(1);
	}
	

	/**
	 * Test method for {@link model.Deck#Deck(int)}.
	 * Test the size
	 */
	@Test
	void testDeckSize() {
		assertEquals(52, deck.size(), "Deck should start with 52 cards");
	}
	/**
	 * Test method for {@link model.Deck#Deck(int)}.
	 * Test the composition
	 */
	@Test
	void testDeckComposition() {
		 // Expected count of each card
	    Map<String, Integer> cardCount = new HashMap<>();
	    String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
		String[] values = {"A", "K", "Q", "J", "10", "9", "8", "7", "6",
				"5", "4", "3", "2"};
	    
	    // Initialize expected count
	    for (String suit : suits) {
	        for (String value : values) {
	            cardCount.put(value + " of " + suit, 0);
	        }
	    }

	    // Count occurrences of each card
	    while (deck.size() > 0) {
	        Card drawnCard = deck.takeOutCard();
	        String cardKey = drawnCard.toString();
	        cardCount.put(cardKey, cardCount.get(cardKey) + 1);
	    }

	    // Check that each card appears exactly once per deck
	    for (String key : cardCount.keySet()) {
	        assertEquals(1, cardCount.get(key), "Card count mismatch for: " + key);
	    }
	}

	/**
	 * Test method for {@link model.Deck#shuffle()}.
	 */
	@Test
	void testShuffle() {
		Deck testDeck = new Deck(1);
		deck.shuffle();
		testDeck.shuffle();
		assertNotEquals(deck.takeOutCard(), testDeck.takeOutCard(),
				"Shuffled decks should not be in the same order");
	}

	/**
	 * Test method for {@link model.Deck#takeOutCard()}.
	 */
	@Test
	void testTakeOutCard() {
		int counter = 0;
		for (int i=0; i < 52; i++) {
			deck.takeOutCard();
			counter++;
		}
		assertEquals(52, counter, "The deck should be empty after 52 cards drawed");
		Exception exception =
				assertThrows(IllegalStateException.class, () -> deck.takeOutCard());
				assertEquals(exception.getMessage(), "The deck is empty!");
	}

}
