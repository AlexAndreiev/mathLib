package com.alex.andreiev.geometry;

import lombok.Getter;

@Getter
public class Point2D extends Point {

    final private double y;

    public Point2D(double x, double y) {
        super(x);
        this.y = y;
    }
}
