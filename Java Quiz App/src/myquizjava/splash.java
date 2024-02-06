package myquizjava;

import javax.swing.*;
import java.awt.*;

public class splash extends JFrame {

    public static int ge = 6;

    splash() {
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/leet.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1000, 600);
        add(image);

        setSize(1000, 600);
        setVisible(true);
        setLocation(250, 150);

    }

    public void paint(Graphics g) {

        super.paint(g);

        if (ge > 0) {

            String nr = " Starting In " + ge;

            g.setFont(new Font("serif", Font.BOLD, 20));

            g.drawString(nr, 420, 440);

        } else {
            setVisible(false);
            new login_page();

        }

        ge--;

        try {

            Thread.sleep(1000);
            repaint();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new splash();

    }

}
