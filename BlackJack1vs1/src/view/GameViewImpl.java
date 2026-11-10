package view;

import javax.swing.*;
import java.awt.*;

/**
 * Concrete implementation of GameView using Java Swing components.
 */
public class GameViewImpl implements GameView {
    private final JFrame frame;
    
    public GameViewImpl(String title) {
        this.frame = new JFrame();
        this.frame.setTitle(title);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(800, 600);
        this.frame.setLocationRelativeTo(null);
        this.frame.getContentPane().setLayout(new BorderLayout());
 
        initPanels();
    }
    
    private void initPanels() {
        // Spazio Dealer
        JPanel dealerPanel = new JPanel();
        dealerPanel.setBorder(BorderFactory.createTitledBorder("Dealer"));
        dealerPanel.setBackground(new Color(34, 139, 34)); 
        frame.getContentPane().add(dealerPanel, BorderLayout.NORTH);
        
        // Spazio giocatore
        JPanel playerPanel = new JPanel();
        playerPanel.setBorder(BorderFactory.createTitledBorder("PlayerName"));//TODO nome personalizzato UserPlayer
        playerPanel.setBackground(new Color(34, 139, 34));
        frame.getContentPane().add(playerPanel, BorderLayout.CENTER);
        
        // Spazio controlli
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        controlPanel.setBackground(new Color(42, 47, 53));
        frame.getContentPane().add(controlPanel, BorderLayout.SOUTH);
    }

    @Override
    public void display() {
        this.frame.setVisible(true);
    }
}