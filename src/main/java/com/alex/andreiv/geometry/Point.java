package com.alex.andreiv.geometry;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Point{

    final private double x;

    @Override
    protected Object clone() {
        return new Point(this.getX());
    }
}
