package com.alex.andreiev.geometry;

import java.util.List;

public class Line2D extends AbstractLine<Point2D, Line2D> {

    public Line2D(Point2D startPoint, Point2D endPoint) {

        super(startPoint, endPoint);
        if (startPoint.getX() == endPoint.getX() && startPoint.getY() == endPoint.getY())
            throw new IllegalArgumentException("start pont cannot be equal an end point");
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
