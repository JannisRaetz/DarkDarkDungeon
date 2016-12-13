package de.simichki.graphic;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jannis on 06.12.16.
 */
public class Panel extends JPanel{
    private static final long serialVersionUID = 1L;
    private final int WIDTH = 1200;
    private final int HEIGHT = 800;

    private final int W2 = WIDTH / 2;
    private final int H2 = HEIGHT / 2;

    private Font font = new Font("Arial", Font.BOLD, 24);
    FontMetrics metrics;

    public Panel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
        g2d.setFont(font);
        metrics = g.getFontMetrics();

        drawHexGridAdvanced(g2d, 20, 1000, 1000);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();
            }
        });
    }

    private void drawHexGridAdvanced(Graphics2D g, int scale, int height, int width) {
        //offset to ensure edges fit
        boolean even = true;
        for(int x = scale/2; x < width; x += scale) {
            for(int y = scale/2; y < height; y += scale) {
                if(even) {
                    drawTriangle(g, new Point(x,y), new Point((x - scale/2), (int) Math.sqrt((3/4)*scale)), new Point((x + scale/2), (int) Math.sqrt((3/4)*scale)));
                    even = false;
                } else {
                    drawTriangle(g, new Point(x,y), new Point((x - scale/2), (int) Math.sqrt((3/4)*scale)), new Point((x + scale/2), (int) Math.sqrt((3/4)*scale)));
                    even = true;
                }
            }
        }
    }

    private void drawTriangle(Graphics2D g, Point a, Point b, Point c) {
        Triangle triangle = new Triangle(g, a, b, c);
        g.setColor(new Color(0x008844));
        g.fillPolygon(triangle);
        g.setColor(new Color(0xFFDD88));
        g.drawPolygon(triangle);
        g.setColor(new Color(0xFFFFFF));
    }

    public void drawCircle(Graphics2D g, int x, int y, int diameter,
                           boolean centered, boolean filled, int colorValue, int lineThickness) {
        drawOval(g, x, y, diameter, diameter, centered, filled, colorValue, lineThickness);
    }

    public void drawOval(Graphics2D g, int x, int y, int width, int height,
                         boolean centered, boolean filled, int colorValue, int lineThickness) {
        // Store before changing.
        Stroke tmpS = g.getStroke();
        Color tmpC = g.getColor();

        g.setColor(new Color(colorValue));
        g.setStroke(new BasicStroke(lineThickness, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND));

        int x2 = centered ? x - (width / 2) : x;
        int y2 = centered ? y - (height / 2) : y;

        if (filled)
            g.fillOval(x2, y2, width, height);
        else
            g.drawOval(x2, y2, width, height);

        // Set values to previous when done.
        g.setColor(tmpC);
        g.setStroke(tmpS);
    }
}