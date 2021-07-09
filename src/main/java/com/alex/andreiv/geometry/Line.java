package com.alex.andreiv.geometry;

import java.util.List;
import java.util.Objects;

public class Line extends AbstractLine<Point, Line> {

    public Line(Point startPoint, Point endPoint) {

        super(startPoint, endPoint);
        if (startPoint.getX() == endPoint.getX())
            throw new IllegalArgumentException("start pont cannot be equal an end point");
    }

    @Override
    public void addPoint(Point point) {
        Objects.requireNonNull(point, "argument is null");
        points.add(point);
    }

    @Override
    public List<Line> getSections() {
        return null;
    }

    @Override
    public double getLength() {
        return 0;
    }
}
