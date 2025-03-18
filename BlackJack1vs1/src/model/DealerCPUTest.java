/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for DealerCPU class
 */
class DealerCPUTest {
	private DealerCPU dealer;
	private Deck deck;
	
	@BeforeEach
	void setting() {
		dealer = new DealerCPU();
		deck = new Deck(1);
		System.out.println("_____________");
	}

	/**
	 * Test method for {@link model.DealerCPU#playTurn(model.Deck)}.
	 */
	@Test
	
	void testStopAtSevenenteen() {
		assertEquals(0,dealer.calculateScore(),"Initial score should be 0");
		dealer.drawCard(new Card("Hearts","10"));
		System.out.println(dealer.toString());
		assertEquals(10,dealer.calculateScore(),"Score should be 10");
		dealer.drawCard(new Card("Clubs","K"));
		System.out.println(dealer.toString());
		assertEquals(20,dealer.calculateScore(),"Score should be 20");
		dealer.playTurn(deck);
		System.out.println("Dealer can't draw cards");
		assertEquals(20,dealer.calculateScore(),"If score is over 17 dealer can't play another turn");
	}
	
	@Test
	void testDrawBelowSeventeen() {
		assertEquals(0,dealer.calculateScore(),"Initial score should be 0");
		dealer.playTurn(deck);
		System.out.println(dealer.toString());
	}

}
