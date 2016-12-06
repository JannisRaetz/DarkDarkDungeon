package de.simichki.graphic;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jannis on 06.12.16.
 */
public class PanelTest {
    public static void main(String[] args) {

        JFrame f = new JFrame();
        Panel p = new Panel();

        JScrollPane scrollPane = new JScrollPane(p);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(50, 30, 2000, 2000);

        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(1000, 1000));
        contentPane.add(scrollPane);

        f.setContentPane(contentPane);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
