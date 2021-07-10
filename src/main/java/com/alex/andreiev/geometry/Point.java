package com.alex.andreiev.geometry;

import lombok.*;

@Getter
@RequiredArgsConstructor
public class Point implements Cloneable, Comparable<Point>{

    final private double x;

    public Point(Point point) {
        this.x = point.getX();
    }

    @Override
    protected Object clone() {
        Point clone = null;
        try {
            clone = (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public boolean equals(Object obj) {
        // Object check only reference
        if (super.equals(obj)) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        return this.x == ((Point)obj).x;
    }

    @Override
//    public int compareTo(@org.jetbrains.annotations.NotNull Point point) {
    public int compareTo(@NonNull Point point) {
        return (int)(this.getX() - point.getX());
    }
}
