package de.simichki.graphic;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jannis on 06.12.16.
 */
public class PanelTest {
    public static void main(String[] args) throws InterruptedException {

        JFrame f = new JFrame();
        Panel p = new Panel();

        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(1200, 1200));

        f.setContentPane(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
