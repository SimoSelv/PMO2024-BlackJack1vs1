
package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for Player class
 */
class PlayerTest {
	
	private Player player;
	
	@BeforeEach
	void setStdPlayer() {
		player = new Player("Test Name");
	}

	/**
	 * Test method for {@link model.Player#Player(java.lang.String)}.
	 
	@Test
	void testPlayer() {
		fail("Not yet implemented");
	}*/

	/**
	 * Test method for {@link model.Player#drawCard(model.Card)}.
	 */
	@Test
	void testDrawCard() {
		assertEquals(0,player.calculateScore(),"Initial score should be 0");
		player.drawCard(new Card("Hearts","10"));
		System.out.println(player.toString());
		assertEquals(10,player.calculateScore(),"Score should be 10");
		player.drawCard(new Card("Clubs","K"));
		System.out.println(player.toString());
		assertEquals(20,player.calculateScore(),"Score should be 20");
	}

	/**
	 * Test method for {@link model.Player#calculateScore()}.
	 */
	@Test
	void testCalculateScore() {
		assertEquals(0,player.calculateScore(),"Initial score should be 0");
		player.drawCard(new Card("Hearts","A"));
		System.out.println(player.toString());
		assertEquals(11,player.calculateScore(),"Score should be 11");
		player.drawCard(new Card("Clubs","K"));
		System.out.println(player.toString());
		assertEquals(21,player.calculateScore(),"Score should be 21");
		player.drawCard(new Card("Diamonds","3"));
		System.out.println(player.toString());
		assertEquals(14,player.calculateScore(),"Score should be 14");
		player.drawCard(new Card("Diamonds","8"));
		System.out.println(player.toString());
		assertEquals(22,player.calculateScore(),"Score should be 22");
	}
	
	/**
	 * Test method for {@link model.Player#calculateScore()}.
	 */
	@Test
	void onlyAces() {
		assertEquals(0,player.calculateScore(),"Initial score should be 0");
		player.drawCard(new Card("Hearts","A"));
		System.out.println(player.toString());
		assertEquals(11,player.calculateScore(),"Score should be 11");
		player.drawCard(new Card("Clubs","A"));
		System.out.println(player.toString());
		assertEquals(12,player.calculateScore(),"Score should be 12");
		player.drawCard(new Card("Diamonds","A"));
		System.out.println(player.toString());
		assertEquals(13,player.calculateScore(),"Score should be 13");
	}

}
