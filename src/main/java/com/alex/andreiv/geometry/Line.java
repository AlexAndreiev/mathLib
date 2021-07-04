package com.alex.andreiv.geometry;

import java.util.List;

public class Line extends AbstractLine<Point, Line> {

    public Line(Point start, Point end) {
        super(start, end);
    }

    @Override
    public void addPoint(Point point) {

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
