package com.alex.andreiev.geometry;

public class Line extends AbstractLine<Point, Line> {

    public Line(Point point1, Point point2) {
        super(point1, point2);
        if (point1.getX() == point2.getX())
            throw new IllegalArgumentException("start pont cannot be equal an end point");
    }

    @Override
    public double getLength() {
        return  getMaxPoint().getX() - getMinPoint().getX();
    }
}
