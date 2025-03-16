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

public class Info extends JDialog{

    JLabel label, title;
    JPanel panel, topPanel, closePanel, mainPanel;
    JButton close;

    Info(JFrame parent) {
        super(parent, "info", true);

        setUndecorated(true); 
        setLayout(new BorderLayout());
        setSize(430, 620);
        setBackground(new Color(19,5,38, 190)); 

        title = new JLabel("Info");
        title.setFont(new Font("Comic Sans", Font.BOLD, 20));
        title.setForeground(Color.WHITE);

        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        topPanel.setBackground(new Color(19,5,38, 36)); 

        title.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        topPanel.add(title, BorderLayout.CENTER);

        String instructions = """
            <b>About:</b>
                This pic-puzzle game was a project created and 
                collaborated on by Group 10 of ICT 11-A of IETI 
                College of Science and Technology Inc. in the 
                year 2025 and was supervised by Mrs. Reynalyn
                Santos.

            <b>Credits:</b>
            Background:
                scenery by <b>@CamiUnknown from X</b>

            Tracks:
                Game On Lets Go by <b>Kalpesh Ajugia</b>
                Game Music Teste(1) by <b>u_z8apfbwc3d </b>
                Space Station by <b>drmseq</b>
            
            <b>Our team:</b>
                - Juan Carlos S. Basco
                - Juliana Mae G. Bordago
                - Vimel T. Malquistro
                - Geoff Lloyd B. Pelejo
                - Karylle M. Verdadero (Leader)

                <b>Contact us:</b>
                picpuzzlecontact@gmail.com

                Thank you for playing!

            """; 

        label = new JLabel("<html>" + instructions.replaceAll("\n", "<br>") + "</html>");
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setForeground(Color.WHITE);

        // this.add(label, BorderLayout.CENTER);

        panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);
        panel.setBackground(new Color(19,5,38, 0)); 

        panel.setBorder(BorderFactory.createEmptyBorder(10, 18, 15, 5));

        close = new JButton("Close");
        close.setPreferredSize(new Dimension(80, 30));
        close.setFocusPainted(false);
        close.setOpaque(false);
        close.setContentAreaFilled(false);   
        close.setForeground(Color.WHITE);
        close.addActionListener(e -> close());

        closePanel = new JPanel();
        closePanel.add(close);
        closePanel.setBackground(new Color(19,5,38, 0)); 


        panel.setBorder(BorderFactory.createEmptyBorder(10, 25, 5, 5));
        closePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

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

    private void close() {
        SoundManager.playSound("GameMenu");
        this.dispose();
    }

}
