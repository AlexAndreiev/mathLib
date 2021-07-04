package com.alex.andreiv.geometry;

import java.util.List;

public class Line2D extends AbstractLine<Point2D, Line2D> {

    public Line2D(Point2D start, Point2D end) {
        super(start, end);
    }

    @Override
    public void addPoint(Point2D point) {

    }

    @Override
    public List<Line2D> getSections() {
        return null;
    }

    @Override
    public double getLength() {
        return 0;
    }
}
