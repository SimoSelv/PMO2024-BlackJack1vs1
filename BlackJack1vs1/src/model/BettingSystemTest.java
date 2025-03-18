/**
 * 
 */
package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class BettingSystemTest {
	private BettingSystem bettingSystem;

	@BeforeEach
	void setUp() {
		bettingSystem = new BettingSystem(500);
	}

	@Test
	void testPlaceBet() {
		assertEquals(500,bettingSystem.getChips(),"Initial chips should be 500");
		bettingSystem.placeBet(20);
		assertEquals(480,bettingSystem.getChips(),"After bet, chips should be 480");
		assertThrows(IllegalArgumentException.class, () -> bettingSystem.placeBet(0),
				"Bet must be greater than zero");
		assertThrows(IllegalArgumentException.class, () -> bettingSystem.placeBet(800),
				"Not enough chips for this bet");
	}
	@Test
	void testWin() {
		bettingSystem.win(20);
		assertEquals(520,bettingSystem.getChips(),"After win, chips should be 520");
	}
	
	@Test
	void testStartingChips() {
		assertThrows(IllegalArgumentException.class, () -> new BettingSystem(-100),
				"Initial chips cannot be negative");
	}
	
}
