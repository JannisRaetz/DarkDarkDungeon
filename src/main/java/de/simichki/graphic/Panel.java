package de.simichki.graphic;

import javax.swing.*;
import java.awt.*;

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

        drawCircle(g2d, W2, H2, 660, true, true, 0x4488FF, 0);

        drawHexGridAdvanced(g2d, 5, 60);
    }

    private void drawHexGridAdvanced(Graphics g, int n, int r) {
        double ang30 = Math.toRadians(30);
        double xOff = Math.cos(ang30) * r;
        double yOff = Math.sin(ang30) * r;
        int h = n / 2;
        int cols = 0;
        int row = 0;
        int col = 0;

        cols = 3;
        row = 0; col = 0;
        drawHex(g, +0, -h + row, (int) (W2 + xOff * (-cols + (col * 2 + 1))), (int) (H2 - yOff * (n - cols) * 3), r);
        row = 0; col = 1;
        drawHex(g, +1, -h + row, (int) (W2 + xOff * (-cols + (col * 2 + 1))), (int) (H2 - yOff * (n - cols) * 3), r);
        row = 0; col = 2;
        drawHex(g, +2, -h + row, (int) (W2 + xOff * (-cols + (col * 2 + 1))), (int) (H2 - yOff * (n - cols) * 3), r);

        cols = 4;
        row = 1; col = 0;
        drawHex(g, -1, -h + row, (int) (W2 + xOff * (-cols + (col * 2 + 1))), (int) (H2 - yOff * (n - cols) * 3), r);
        row = 1; col = 1;
        drawHex(g, +0, -h + row, (int) (W2 + xOff * (-cols + (col * 2 + 1))), (int) (H2 - yOff * (n - cols) * 3), r);
        row = 1; col = 2;
        drawHex(g, +1, -h + row, (int) (W2 + xOff * (-cols + (col * 2 + 1))), (int) (H2 - yOff * (n - cols) * 3), r);
        row = 1; col = 3;
        drawHex(g, +2, -h + row, (int) (W2 + xOff * (-cols + (col * 2 + 1))), (int) (H2 - yOff * (n - cols) * 3), r);

        cols = 5;
        row = 2; col = 0;
        drawHex(g, -2, -h + row, (int) (W2 + xOff * (-cols + (col * 2 + 1))), (int) (H2 + yOff * (n - cols) * 3), r);
        row = 2; col = 1;
        drawHex(g, -1, -h + row, (int) (W2 + xOff * (-cols + (col * 2 + 1))), (int) (H2 + yOff * (n - cols) * 3), r);
        row = 2; col = 2;
        drawHex(g, +0, -h + row, (int) (W2 + xOff * (-cols + (col * 2 + 1))), (int) (H2 + yOff * (n - cols) * 3), r);
        row = 2; col = 3;
        drawHex(g, +1, -h + row, (int) (W2 + xOff * (-cols + (col * 2 + 1))), (int) (H2 + yOff * (n - cols) * 3), r);
        row = 2; col = 4;
        drawHex(g, +2, -h + row, (int) (W2 + xOff * (-cols + (col * 2 + 1))), (int) (H2 + yOff * (n - cols) * 3), r);

        cols = 4;
        row = 3; col = 0;
        drawHex(g, -2, -h + row, (int) (W2 + xOff * (-cols + (col * 2 + 1))), (int) (H2 + yOff * (n - cols) * 3), r);
        row = 3; col = 1;
        drawHex(g, -1, -h + row, (int) (W2 + xOff * (-cols + (col * 2 + 1))), (int) (H2 + yOff * (n - cols) * 3), r);
        row = 3; col = 2;
        drawHex(g, +0, -h + row, (int) (W2 + xOff * (-cols + (col * 2 + 1))), (int) (H2 + yOff * (n - cols) * 3), r);
        row = 3; col = 3;
        drawHex(g, +1, -h + row, (int) (W2 + xOff * (-cols + (col * 2 + 1))), (int) (H2 + yOff * (n - cols) * 3), r);

        cols = 3;
        row = 4; col = 0;
        drawHex(g, -2, -h + row, (int) (W2 + xOff * (-cols + (col * 2 + 1))), (int) (H2 + yOff * (n - cols) * 3), r);
        row = 4; col = 1;
        drawHex(g, -1, -h + row, (int) (W2 + xOff * (-cols + (col * 2 + 1))), (int) (H2 + yOff * (n - cols) * 3), r);
        row = 4; col = 2;
        drawHex(g, +0, -h + row, (int) (W2 + xOff * (-cols + (col * 2 + 1))), (int) (H2 + yOff * (n - cols) * 3), r);
    }

    private void drawHexGridBasic(Graphics g, int n, int r) {
        double ang30 = Math.toRadians(30);
        double xOff = Math.cos(ang30) * r;
        double yOff = Math.sin(ang30) * r;
        int h = n / 2;

        drawHex(g, +0, -2,  W2 - (int) (xOff * 2), H2 - (int) (yOff * 6), r);
        drawHex(g, +1, -2,  W2 - (int) (xOff * 0), H2 - (int) (yOff * 6), r);
        drawHex(g, +2, -2,  W2 + (int) (xOff * 2), H2 - (int) (yOff * 6), r);

        drawHex(g, -1, -1,  W2 - (int) (xOff * 3), H2 - (int) (yOff * 3), r);
        drawHex(g, +0, -1,  W2 - (int) (xOff * 1), H2 - (int) (yOff * 3), r);
        drawHex(g, +1, -1,  W2 + (int) (xOff * 1), H2 - (int) (yOff * 3), r);
        drawHex(g, +2, -1,  W2 + (int) (xOff * 3), H2 - (int) (yOff * 3), r);

        drawHex(g, -2, +0,  W2 - (int) (xOff * 4), H2 - (int) (yOff * 0), r);
        drawHex(g, -1, +0,  W2 - (int) (xOff * 2), H2 - (int) (yOff * 0), r);
        drawHex(g, +0, +0,  W2 - (int) (xOff * 0), H2 - (int) (yOff * 0), r);
        drawHex(g, +1, +0,  W2 + (int) (xOff * 2), H2 - (int) (yOff * 0), r);
        drawHex(g, +2, +0,  W2 + (int) (xOff * 4), H2 - (int) (yOff * 0), r);

        drawHex(g, -2, +1,  W2 - (int) (xOff * 3), H2 + (int) (yOff * 3), r);
        drawHex(g, -1, +1,  W2 - (int) (xOff * 1), H2 + (int) (yOff * 3), r);
        drawHex(g, +0, +1,  W2 + (int) (xOff * 1), H2 + (int) (yOff * 3), r);
        drawHex(g, +1, +1,  W2 + (int) (xOff * 3), H2 + (int) (yOff * 3), r);

        drawHex(g, -2, +2,  W2 - (int) (xOff * 2), H2 + (int) (yOff * 6), r);
        drawHex(g, -1, +2,  W2 - (int) (xOff * 0), H2 + (int) (yOff * 6), r);
        drawHex(g, +0, +2,  W2 + (int) (xOff * 2), H2 + (int) (yOff * 6), r);
    }

    private void drawHex(Graphics g, int posX, int posY, int x, int y, int r) {
        Hexagon hex = new Hexagon(x, y, r);
        String text = String.format("%s : %s", coord(posX), coord(posY));
        int w = metrics.stringWidth(text);
        int h = metrics.getHeight();

        g.setColor(new Color(0x008844));
        g.fillPolygon(hex);
        g.setColor(new Color(0xFFDD88));
        g.drawPolygon(hex);
        g.setColor(new Color(0xFFFFFF));
        g.drawString(text, x - w/2, y + h/2);
    }

    private String coord(int value) {
        return (value > 0 ? "+" : "") + Integer.toString(value);
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