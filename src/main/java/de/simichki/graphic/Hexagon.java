package de.simichki.graphic;

import javax.swing.event.MouseInputListener;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.event.MouseEvent;

public class Hexagon extends Polygon {

    private static final long serialVersionUID = 1L;

    public static final int SIDES = 6;

    private Point[] points = new Point[SIDES];
    private Point center = new Point(0, 0);
    private int radius;
    private int rotation = 90;
    private final Graphics2D graphics;

    public Hexagon(final Graphics2D graphics, Point center, int radius) {
        npoints = SIDES;
        xpoints = new int[SIDES];
        ypoints = new int[SIDES];

        this.center = center;
        this.radius = radius;
        this.graphics = graphics;

        updatePoints();
    }

    public Hexagon(final Graphics2D graphics, int x, int y, int radius) {
        this(graphics, new Point(x, y), radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;

        updatePoints();
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;

        updatePoints();
    }

    public void setCenter(Point center) {
        this.center = center;

        updatePoints();
    }

    public void setCenter(int x, int y) {
        setCenter(new Point(x, y));
    }

    private double findAngle(double fraction) {
        return fraction * Math.PI * 2 + Math.toRadians((rotation + 180) % 360);
    }

    public void setColor(Color col) {
        graphics.setColor(new Color(0x008844));
        graphics.drawPolygon(this);
    }

    private Point findPoint(double angle) {
        int x = (int) (center.x + Math.cos(angle) * radius);
        int y = (int) (center.y + Math.sin(angle) * radius);

        return new Point(x, y);
    }

    protected void updatePoints() {
        for (int p = 0; p < SIDES; p++) {
            double angle = findAngle((double) p / SIDES);
            Point point = findPoint(angle);
            xpoints[p] = point.x;
            ypoints[p] = point.y;
            points[p] = point;
            System.out.printf("%d. (%d, %d)\n", p, point.x, point.y);
        }
    }

    public void drawPolygon(int x, int y, int lineThickness, int colorValue, boolean filled) {
        // Store before changing.
        Stroke tmpS = graphics.getStroke();
        Color tmpC = graphics.getColor();

        graphics.setColor(new Color(colorValue));
        graphics.setStroke(new BasicStroke(lineThickness, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));

        if (filled)
            graphics.fillPolygon(xpoints, ypoints, npoints);
        else
            graphics.drawPolygon(xpoints, ypoints, npoints);

        // Set values to previous when done.
        graphics.setColor(tmpC);
        graphics.setStroke(tmpS);
    }
}
