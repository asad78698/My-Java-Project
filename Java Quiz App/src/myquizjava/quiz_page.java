package myquizjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class quiz_page extends JFrame implements ActionListener {

    String questions[][] = new String[5][5];
    String answers[][] = new String[5][2];
    String answergiver[][] = new String[5][5];

    JLabel qno, question, image;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup grouping;
    JButton nextbtn, submit, lifeline;

    public static int timer = 10;
    public static int answer = 0;
    public static int count = 0;
    public static int score = 10;

    String name;

    quiz_page(String name) {

        this.name = name;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/QUIZ TIME!.png"));

        image = new JLabel(i1);
        image.setBounds(0, 5, 1000, 350);

        add(image);

        qno = new JLabel();
        qno.setBounds(100, 460, 50, 30);
        qno.setFont(new Font("serif", Font.BOLD, 20));
        add(qno);

        question = new JLabel();
        question.setBounds(135, 460, 900, 30);
        question.setFont(new Font("serif", Font.PLAIN, 20));
        add(question);

        questions[0][0] = "What Is The Chemical Name Of SALT";
        questions[0][1] = "NACL";
        questions[0][2] = "H2SO4";
        questions[0][3] = "HCL";
        questions[0][4] = "M2SO4";

        questions[1][0] = "What Is The Currency Of USA";
        questions[1][1] = "Dollar";
        questions[1][2] = "Ruppee";
        questions[1][3] = "Dharam";
        questions[1][4] = "Riyal";

        questions[2][0] = "Who Is The Founder Of Pakistan";
        questions[2][1] = "Quaide Azam";
        questions[2][2] = "Imran Khan";
        questions[2][3] = "Nawaz Sharif";
        questions[2][4] = "Ronaldo";

        questions[3][0] = "Which Is Our National Fruit";
        questions[3][1] = "Mango";
        questions[3][2] = "Orange";
        questions[3][3] = "Banana";
        questions[3][4] = "Grapes";

        questions[4][0] = "Who Is The Real GOAT Of Football";
        questions[4][1] = "Messi";
        questions[4][2] = "Ronaldo";
        questions[4][3] = "Neymar";
        questions[4][4] = "Mbappe";

        answers[0][1] = "NACL";
        answers[1][1] = "Dollar";
        answers[2][1] = "Quaide Azam";
        answers[3][1] = "Mango";
        answers[4][1] = "Messi";

        opt1 = new JRadioButton();
        opt1.setBounds(120, 520, 600, 30);
        opt1.setBackground(Color.white);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(120, 560, 600, 30);
        opt2.setBackground(Color.white);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(120, 600, 600, 30);
        opt3.setBackground(Color.white);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(120, 640, 600, 30);
        opt4.setBackground(Color.white);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        grouping = new ButtonGroup();
        grouping.add(opt1);
        grouping.add(opt2);
        grouping.add(opt3);
        grouping.add(opt4);

        nextbtn = new JButton("Next");
        nextbtn.setBounds(720, 550, 200, 40);
        nextbtn.setBackground(Color.BLACK);
        nextbtn.setForeground(Color.WHITE);
        nextbtn.setFont(new Font("serif", Font.PLAIN, 22));
        nextbtn.addActionListener(this);

        add(nextbtn);

        submit = new JButton("Submit");
        submit.setBounds(720, 615, 200, 40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("serif", Font.PLAIN, 22));
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        setSize(1000, 800);
        setLocation(250, 50);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

        start(count);

    }

    public void paint(Graphics g) {

        super.paint(g);

        String time = " Time Left " + timer + " Seconds ";
        g.setColor(Color.BLACK);
        g.setFont(new Font(" serif", Font.BOLD, 25));
        if (timer > 0) {
            g.drawString(time, 680, 530);
        } else {
            String namei = "Times Up!";
            g.drawString(namei, 720, 530);
        }

        --timer;

        try {

            Thread.sleep(1000);
            repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (answer == 1) {
            answer = 0;
            timer = 10;
        } else if (timer < 0) {
            timer = 10;

            count++;
            start(count);
        }

    }

    void start(int count) {

        qno.setText(" " + (count + 1) + ".");
        question.setText(questions[count][0]);
        opt1.setText(" " + questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(" " + questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(" " + questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(" " + questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        grouping.clearSelection();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == nextbtn) {
            repaint();
            if (timer < 0) {
                score -= 10;
            } else {
                score += 10;
            }

            answer = 1;

            if (grouping.getSelection() == null) {

                answergiver[count][0] = " ";

            } else {

                answergiver[count][0] = grouping.getSelection().getActionCommand();
            }

            if (count == 3) {
                nextbtn.setEnabled(false);

                submit.setEnabled(true);
            }

            count++;
            start(count);

        } else if (ae.getSource() == submit) {

            setVisible(false);
            new score(name, score);

        }

    }

    public static void main(String[] args) {

        new quiz_page("user");

    }

}
