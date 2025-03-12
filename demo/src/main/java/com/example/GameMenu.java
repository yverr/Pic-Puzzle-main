package com.example;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameMenu extends JFrame implements ActionListener{

    JButton btn, btn2, btn3, info;
    JPanel centerPanel, topPanel;
    JLabel label;
    ImageIcon background;
    JPanel backgroundPanel;

    GameMenu() {

        ImageIcon img = new ImageIcon("demo\\src\\resources\\images\\logo1.png");
        setIconImage(img.getImage());

        setTitle("PicPuzzle");

        // === Custom Background Panel ===
        backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                background = new ImageIcon("demo\\src\\resources\\images\\background.png"); // Ensure path is correct
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());

        // === Transparent Main Panel for UI ===
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setOpaque(false);

        // Info Button (Top Right Corner)
        info = new JButton("!");
        info.setFont(new Font("Comic Sans", Font.BOLD, 15));
        info.setPreferredSize(new Dimension(40, 40));
        info.setToolTipText("About");
        info.setFocusPainted(false);
        info.setContentAreaFilled(false); 
        info.setBorderPainted(true);     
        info.setOpaque(false);         
        info.setForeground(Color.WHITE); 

        // Top Panel (Contains Info Button)
        topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);
        topPanel.add(info, BorderLayout.EAST);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Game Title
        label = new JLabel("", SwingConstants.CENTER);
        label.setFont(new Font("Comic Sans", Font.BOLD, 50));
        label.setForeground(Color.BLACK); // Ensures visibility

        btn = createButton(" Play Game ");
        btn2 = createButton("How to Play");
        btn3 = createButton("   Settings   ");

        btn.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        info.addActionListener(this);

        // === Center Panel ===
        centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn2.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn3.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(Box.createVerticalGlue()); 
        centerPanel.add(label);
        centerPanel.add(Box.createVerticalStrut(150)); 
        centerPanel.add(btn);
        centerPanel.add(Box.createVerticalStrut(70)); 
        centerPanel.add(btn2);
        centerPanel.add(Box.createVerticalStrut(70)); 
        centerPanel.add(btn3);
        centerPanel.add(Box.createVerticalGlue());

        // Add components properly
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Add main panel on top of the background panel
        backgroundPanel.add(mainPanel, BorderLayout.CENTER);
        setContentPane(backgroundPanel);

        // var image = new JLabel(new ImageIcon("demo\\src\\resources\\images\\gifpic.gif"));
        // image.setBounds(0, 0, 1925, 1080);
        // add(image);

        setSize(1925,1080);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(190, 30));
        button.setFont(new Font("Comic Sans", Font.BOLD, 20));
        button.setFocusable(false);
    
        button.setContentAreaFilled(false); 
        button.setBorderPainted(false);     
        button.setOpaque(false);         
        button.setForeground(Color.WHITE); 
    
       
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setForeground(Color.PINK); 
            }
    
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setForeground(Color.WHITE);  
                button.setBorder(null);            
            }
        });
    
        return button;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn){
            Levels g = new Levels(this, null); 
            g.display(true);
            this.setVisible(false);
        } else if (e.getSource()==btn2){
            HowToPlay h = new HowToPlay(this);
            h.display();
        } else if (e.getSource()==btn3){
            Settings s = new Settings(this, this);
            s.display();
        } else if (e.getSource()==info){
            Info i = new Info(this);
            i.display();
        }
    }

   
}
