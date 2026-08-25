package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Unit tests for the Game class.
 * Focuses on testing user input handling and game flow initialization.
 */
class GameTest {
    
    private final InputStream systemIn = System.in;

    @BeforeEach
    void setUp() {
        System.out.println("_____________");
    }

    @AfterEach
    void restoreSystemIn() {
        System.setIn(systemIn);
    }

    /**
     * Helper to simulate console input
     */
    private void provideInput(String data) {
        System.out.println("Simulating User Input: " + data.replace("\n", " [ENTER] "));
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @Test
    void testGameInitialization() {
        System.out.println("TEST: Game Initialization");
        Game game = new Game(1, 500, "Simona");
        
        assertNotNull(game, "Game object should be successfully created");
        System.out.println("Game initialized successfully.");
    }

    @Test
    void testPlaceBetValid() {
        System.out.println("TEST: placeBet with valid amount");
        provideInput("50\n");
        Game game = new Game(1, 500, "Simona");
        assertDoesNotThrow(() -> game.placeBet(), "placeBet should complete successfully with valid input");
    }

    @Test
    void testPlaceBetInvalidThenValid() {
        System.out.println("TEST: placeBet with text, over-budget bet, then valid bet");
        provideInput("test\n1000\n100\n");
        
        Game game = new Game(1, 500, "Simona");
        
        assertDoesNotThrow(() -> game.placeBet(), "placeBet should recover from invalid inputs and accept the valid one");
    }
}