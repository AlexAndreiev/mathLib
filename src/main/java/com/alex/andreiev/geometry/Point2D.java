package com.alex.andreiev.geometry;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Point2D extends Point {

    private double y;

    public Point2D(double x, double y, String name) {
        super(x, name);
        this.y = y;
    }

    public Point2D(Point2D point) {
        this(point.getX(), point.getY(), point.getName());
    }
}
