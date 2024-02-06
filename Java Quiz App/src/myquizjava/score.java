package myquizjava;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class score extends JFrame {

    score(String name, int score) {
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/QUIZ TIME!.png"));

        JLabel image = new JLabel(i1);
        image.setBounds(0, 5, 1000, 350);

        add(image);

        JLabel lscore = new JLabel("Your Score is " + score);
        lscore.setBounds(300, 400, 250, 40);
        add(lscore);

        JButton submit = new JButton("PLAY AGAIN");
        submit.setBounds(300, 500, 200, 40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("serif", Font.PLAIN, 22));
        add(submit);

        setSize(1000, 800);
        setLocation(250, 50);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

    }

    public static void main(String[] args) {

        new score("user", 0);
    }

}
