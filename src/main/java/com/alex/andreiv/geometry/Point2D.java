package com.alex.andreiv.geometry;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class Point2D extends Point {

    final private double y;

    public Point2D(double x, double y) {
        super(x);
        this.y = y;
    }
}
