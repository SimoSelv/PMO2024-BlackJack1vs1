package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Unit tests for UserPlayer class with console output.
 */
class UserPlayerTest {
    private UserPlayer player;
    private final InputStream systemIn = System.in;

    @BeforeEach
    void setUp() {
        // Separation line as in your previous tests
        System.out.println("-----------------");
    }

    @AfterEach
    void restoreSystemIn() {
        System.setIn(systemIn);
    }

    /**
     * Helper to simulate console input
     */
    private void provideInput(String data) {
        System.out.println("User Input: " + data.trim());
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    void testDecideMoveHit() {
        System.out.println("TEST: Hit");
        provideInput("H\n");
        
        player = new UserPlayer("TestPlayer");
        player.drawCard(new Card("Hearts", "7"));
        System.out.println(player.toString());
        
        boolean result = player.decideMove();
        
        System.out.println("Decision result: " + (result ? "HIT" : "STAND"));
        assertTrue(result, "Should return true when user inputs 'H'");
    }

    @Test
    void testDecideMoveStand() {
        System.out.println("TEST: Stand");
        provideInput("S\n");
        
        player = new UserPlayer("TestPlayer");
        player.drawCard(new Card("Diamonds", "10"));
        System.out.println(player.toString());
        
        boolean result = player.decideMove();
        
        System.out.println("Decision result: " + (result ? "HIT" : "STAND"));
        assertFalse(result, "Should return false when user inputs 'S'");
    }

    @Test
    void testDecideMoveAutoStandOn21() {
        System.out.println("TEST: Automatic Stand on 21 or more");
        player = new UserPlayer("TestPlayer");
        player.drawCard(new Card("Spades", "10"));
        player.drawCard(new Card("Hearts", "A")); // Score: 21
        
        System.out.println(player.toString());
        System.out.println("Checking if it asks for input (it shouldn't)...");
        
        boolean result = player.decideMove();
        
        System.out.println("Decision result: " + (result ? "HIT" : "STAND"));
        assertFalse(result, "Should return false automatically if score is 21 or more");
    }
    
    @Test
    void testHitThenStand() {
        System.out.println("TEST: Hit then Stand");
        
        // Simulate user typing 'H' then 'S'
        provideInput("H\nS\n");
        
        player = new UserPlayer("TestPlayer");
        
        // Initial State: 10 of Hearts
        player.drawCard(new Card("Hearts", "10"));
        System.out.println("Step 1 " + player.toString());
        
        // First decision: User says 'H' (Hit)
        boolean firstMove = player.decideMove();
        System.out.println("First Decision: " + (firstMove ? "HIT" : "STAND"));
        assertTrue(firstMove, "First move should be HIT");
        
        // Simulate drawing the 7 of Clubs
        player.drawCard(new Card("Clubs", "7"));
        System.out.println("Step 2 " + player.toString());
        
        // Second decision: User says 'S' (Stand)
        boolean secondMove = player.decideMove();
        System.out.println("Second Decision: " + (secondMove ? "HIT" : "STAND"));
        assertFalse(secondMove, "Second move should be STAND");
        
        assertEquals(17, player.calculateScore(), "Final score should be 17");
    }
    
    @Test
    void testInputs() {
        System.out.println("TEST: Multiple Inputs ");
        
        // Preparazione sequenza input: 
        // 1. 'x' -> Errore (il ciclo continua)
        // 2. 's' -> Stand (esce dal primo decideMove)
        // 3. 'S' -> Stand (per il secondo decideMove)
        provideInput("x\ns\nS\nh\nH\n");
        
        player = new UserPlayer("TestPlayer");
        player.drawCard(new Card("Hearts", "10")); // Punteggio fisso a 10
        
        System.out.println(player.toString());
        System.out.println("Step 1: Entering 'x' then 's'");
        boolean firstResult = player.decideMove();         
        System.out.println("Result of Step 1: " + (firstResult ? "HIT" : "STAND"));
        assertFalse(firstResult, "Should return STAND (false) after an invalid input and a lowercase 's'");
        System.out.println("Step 2: Entering uppercase 'S'");
        boolean secondResult = player.decideMove();
        System.out.println("Result of Step 2: " + (secondResult ? "HIT" : "STAND"));
        assertFalse(secondResult, "Should return STAND (false) for uppercase 'S'");
        System.out.println("Step 3: Entering lowercase 'h'");
        boolean thirdResult = player.decideMove();
        System.out.println("Result of Step 3: " + (thirdResult ? "HIT" : "STAND"));
        assertTrue(thirdResult, "Should return HIT (true) for lowercase 'h'");
        System.out.println("Step 4: Entering uppercase 'H'");
        boolean fourthResult = player.decideMove();
        System.out.println("Result of Step 4: " + (fourthResult ? "HIT" : "STAND"));
        assertTrue(fourthResult, "Should return HIT (true) for uppercase 'h'");
    }
    
    
}