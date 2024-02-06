package myquizjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class login_page extends JFrame implements ActionListener {

    JButton btn1, btn2;
    JTextField namefield, idfield;
 

    login_page() {

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/image_login.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(10, 50, 500, 400);
        add(image);

        JLabel heading = new JLabel(" Quiz Dose ");
        heading.setBounds(650, 50, 300, 100);
        heading.setFont(new Font("serif", Font.BOLD, 40));
        heading.setForeground(Color.BLACK);
        add(heading);

        JLabel heading1 = new JLabel(" Enter Name  ");
        heading1.setBounds(550, 200, 200, 30);
        heading1.setFont(new Font("serif", Font.BOLD, 18));
        heading1.setForeground(Color.BLACK);
        add(heading1);

        namefield = new JTextField();
        namefield.setBounds(660, 200, 230, 30);
        add(namefield);

        JLabel heading2 = new JLabel(" Enter  ID  ");
        heading2.setBounds(550, 250, 200, 30);
        heading2.setFont(new Font("serif", Font.BOLD, 18));
        heading2.setForeground(Color.BLACK);
        add(heading2);

        idfield = new JTextField();
        idfield.setBounds(660, 250, 230, 30);
        add(idfield);

        btn1 = new JButton(" Rules ");
        btn1.setBounds(800, 360, 90, 30);
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        btn1.addActionListener(this);
        add(btn1);

        btn2 = new JButton(" Exit ");
        btn2.setBounds(660, 360, 90, 30);
        btn2.setBackground(Color.BLACK);
        btn2.setForeground(Color.WHITE);
        btn2.addActionListener(this);
        add(btn2);

        setSize(1000, 600);
        setVisible(true);
        setLocation(250, 150);
        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae) {

        String name = namefield.getText();
        String nameid = idfield.getText();

        if (ae.getSource() == btn1) {

            setVisible(false);
            new rules_page(name, nameid);

        } else {

            setVisible(false);

        }
    }

    public static void main(String[] args) {

        new login_page();

    }

}
