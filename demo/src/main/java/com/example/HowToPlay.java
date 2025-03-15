package com.example;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;


public class HowToPlay extends JDialog{

    //hell

    JLabel label, title;
    JPanel panel, topPanel, closePanel, mainPanel;
    JButton close;

    HowToPlay(JFrame parent) {
        super(parent, "How to Play", true);

        setUndecorated(true); //on everyones soul this dialog box looked like ass without this sht
        setLayout(new BorderLayout());
        setBackground(new Color(19,5,38, 190)); 
        setSize(390, 490);

        title = new JLabel("How To Play");
        title.setFont(new Font("Comic Sans", Font.BOLD, 20));
        title.setForeground(Color.WHITE);

        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        topPanel.setBackground(new Color(19,5,38, 36)); 

        title.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        topPanel.add(title, BorderLayout.CENTER);

        String instructions = """
                              <b>Instructions:</b>
                                1. Click the Play Game button and proceed to 
                                level 1 to start the game.
                                2. Click the top right icon button to switch between
                                puzzle piece
                                3. Using the reference picture on the right, solve 
                                the puzzle
                                4. Solve the puzzle with less moves as much as 
                                possible.
                                5. Goodluck and have fun!
                              
                              <b>Navigation:</b>
                                - Click the '<b>!</b>' button in the Game menu's top right
                               corner to view game information.
                                - Click the '<b>Play Game</b>' button to choose levels:
                               <i>[Level 1], [Level 2], [Level 3], [Level 4], [Level 5]</i>. 
                               Only Level 1 can be unlocked first, so you must 
                               complete it to unlock the other levels!
                                - Click the '<b>Settings</b>' to change [-]""";

        label = new JLabel("<html>" + instructions.replaceAll("\n", "<br>") + "</html>");
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setForeground(Color.WHITE);

        // this.add(label, BorderLayout.CENTER);

        panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);
        panel.setBackground(new Color(19,5,38, 0)); 

        Border border = BorderFactory.createLineBorder(Color.gray, 2);
        panel.setBorder(border); 

        close = new JButton("Close");
        close.setPreferredSize(new Dimension(80, 30));
        close.setFocusPainted(false);
        close.addActionListener(e -> this.dispose());

        closePanel = new JPanel();
        closePanel.add(close);
        closePanel.setBackground(new Color(19,5,38, 0)); 

        panel.setBorder(BorderFactory.createEmptyBorder(10, 18, 15, 5));
        closePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(19,5,38, 0)); 
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(panel, BorderLayout.CENTER);
        mainPanel.add(closePanel, BorderLayout.SOUTH);
        add(mainPanel);
        setLocationRelativeTo(parent);
    }

    public void display(){
        this.setVisible(true);
    }

}