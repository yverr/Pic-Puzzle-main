package com.example;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PauseMenu extends JDialog {

    public PauseMenu(JFrame parent, PicPuzzle game) {
        
        super(parent, "Game Paused", true);
        SoundManager.playSound("GameMenu");

        setUndecorated(true); 
        setSize(350, 420);
        setBackground(new Color(19,5,38, 190)); 
        setLocationRelativeTo(parent); // Center the dialog on the game window

        // Panel to hold buttons
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 

        // Resume Button
        JButton resumeButton = new JButton("  Resume  ");
        resumeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        resumeButton.setFocusable(false);
        resumeButton.setFont(new Font("Comic Sans",Font.BOLD,20));
        resumeButton.setOpaque(false);
        resumeButton.setContentAreaFilled(false);   
        resumeButton.setForeground(Color.WHITE);
        resumeButton.addActionListener(e -> {
            SoundManager.playSound("GameMenu");
            dispose();
            game.resumeGame();
        });

        // Restart Button
        JButton restartButton = new JButton("   Restart   ");
        restartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        restartButton.setFocusable(false);
        restartButton.setFont(new Font("Comic Sans",Font.BOLD,20));
        restartButton.setOpaque(false);
        restartButton.setContentAreaFilled(false);   
        restartButton.setForeground(Color.WHITE);
        restartButton.addActionListener(e -> { 
            SoundManager.playSound("PlayGame");
            game.restartGame();
            dispose();  
        });

        // Home Button
        JButton homeButton = new JButton("    Home    ");
        homeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        homeButton.setFocusable(false);
        homeButton.setFont(new Font("Comic Sans",Font.BOLD,20));
        homeButton.setOpaque(false);
        homeButton.setContentAreaFilled(false);   
        homeButton.setForeground(Color.WHITE);
        homeButton.addActionListener(e -> {
            SoundManager.playSound("PlayGame");
            parent.dispose();
            game.stopTimer();
            GameMenu gameMenu = new GameMenu();
            gameMenu.setVisible(true);
        });

        // Add spacing and buttons
        panel.add(Box.createVerticalGlue());
        panel.add(resumeButton);
        panel.add(Box.createVerticalStrut(35));
        panel.add(restartButton);
        panel.add(Box.createVerticalStrut(35));
        panel.add(homeButton);
        panel.add(Box.createVerticalGlue());

        panel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.lightGray));
        panel.setBackground(new Color(19,5,38, 0)); 
        add(panel);

        setVisible(true);
    }

}
