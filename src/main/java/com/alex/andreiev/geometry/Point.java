package com.alex.andreiev.geometry;

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

    @Override
    public boolean equals(Object obj) {
        // Object check only reference
        if (super.equals(obj)) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        return this.x == ((Point)obj).x;
    }
}
