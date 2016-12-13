package de.simichki.graphic;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jannis on 06.12.16.
 */
public class Panel extends JPanel implements MouseInputListener{
    private Map<Point, Hexagon> map = new HashMap<Point, Hexagon>();
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

        drawHexGridAdvanced(g2d, 20, 20, 20);
    }

    public void colorHex() {
        for(Point p : map.keySet()) {
            map.get(p).setColor(new Color(0x000000));
        }
    }

    private void drawHexGridAdvanced(Graphics2D g, int hexSize, int height, int width) {
        //offset to ensure edges fit
        double ang30 = Math.toRadians(30);
        double xOff = Math.cos(ang30) * hexSize;
        double yOff = Math.sin(ang30) * hexSize;

        int cols = 0;
        for(int x = 0; x < height; x++) {
            for(int y = 0; y < width; y++) {
                if(y % 2 == 1) {
                    drawHex(g, (int) (10 + xOff * (-cols + (x * 2 + 1)-1)), (int) (10 + yOff * (y - cols) * 3), hexSize);
                } else {
                    drawHex(g, (int) (10 + xOff * (-cols + (x * 2 + 1))), (int) (10 + yOff * (y - cols) * 3), hexSize);
                }
            }
        }
        System.out.println(map.entrySet());
    }

    private void drawHex(Graphics2D g, int x, int y, int r) {
        Point point = new Point(x,y);
        Hexagon hex = new Hexagon(g, point, r);
        map.put(point, hex);
        g.setColor(new Color(0x008844));
        g.fillPolygon(hex);
        g.setColor(new Color(0xFFDD88));
        g.drawPolygon(hex);
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

    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        Hexagon hex = getClosestHexagon(p);
        if(hex != null) {
            hex.setColor(new Color(0x000000));
        }
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

    }

    private Hexagon getClosestHexagon(Point point) {
        if(map.containsKey(point)) {
            return map.get(point);
        } else {
            return null;
        }
    }
}