package de.simichki.graphic;

import com.sun.javafx.geom.Vec2d;

import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by jannis on 13.12.16.
 */
public class Triangle extends Polygon{

    private final Graphics2D graphics;

    public static final int SIDES = 3;
    private Point[] points = new Point[SIDES];

    public Triangle(final Graphics2D graphics, final Point ... points) {
        if(points.length != 3) {
            throw new IllegalArgumentException("A triangle must consist of 3 points, but " + points.length + " were given: " + points);
        }
        npoints = SIDES;
        xpoints = new int[npoints];
        ypoints = new int[npoints];
        for (int i = 0; i < npoints; i++) {
            xpoints[i] = (int) points[i].getX();
            ypoints[i] = (int) points[i].getY();
        }
        this.graphics = graphics;
    }
}
