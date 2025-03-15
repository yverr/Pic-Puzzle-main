package com.example;

import javax.swing.*;
import java.awt.*;

public class Settings extends JDialog {
    private JButton volumeButton, themeButton, closeButton;
    
    public Settings(JFrame parent, GameMenu gameMenu) {
        super(parent, "Settings", true);
        setSize(370, 450);
        setLocationRelativeTo(parent);
        setUndecorated(true);

        setBackground(new Color(19, 5, 38, 200)); 
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        Font cyberFont = new Font("Arial", Font.BOLD, 16);

        volumeButton = createNeonButton(SoundManager.isMuted() ? "VOLUME: OFF" : "VOLUME: ON", cyberFont);
        volumeButton.addActionListener(e -> toggleVolume());
        gbc.gridy = 0;
        panel.add(volumeButton, gbc);

        themeButton = createNeonButton("THEME: DARK", cyberFont);
        themeButton.addActionListener(e -> toggleTheme());
        gbc.gridy = 1;
        panel.add(themeButton, gbc);

        closeButton = createNeonButton("CLOSE", cyberFont);
        closeButton.addActionListener(e -> disposeThis());
        gbc.gridy = 2;
        panel.add(closeButton, gbc);

        panel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        add(panel);
    }

    private JButton createNeonButton(String text, Font font) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setForeground(Color.WHITE);
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        button.setPreferredSize(new Dimension(180, 50));
        
        // Hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setForeground(Color.PINK);
                button.setBorder(BorderFactory.createLineBorder(Color.PINK, 1));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setForeground(Color.WHITE);
                button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
            }
        });
        return button;
    }
    
    private void toggleVolume() {
        SoundManager.setMute(!SoundManager.isMuted());
        volumeButton.setText(SoundManager.isMuted() ? "VOLUME: OFF" : "VOLUME: ON");
    }

    private void toggleTheme() {
        SoundManager.playSound("GameMenu");
        themeButton.setText(themeButton.getText().equals("THEME: DARK") ? "THEME: LIGHT" : "THEME: DARK");
    }


    private void disposeThis() {
        SoundManager.playSound("GameMenu");
        dispose();
    }
}
