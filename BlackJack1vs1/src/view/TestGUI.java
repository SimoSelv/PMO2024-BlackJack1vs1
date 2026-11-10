package view;

public class TestGUI {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            GameView view = new GameViewImpl("Blackjack 1vs1 - Test GUI");
            view.display();
        });
    }
}