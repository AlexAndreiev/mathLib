package com.alex.andreiev.geometry;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Point implements Comparable {

    @NonNull
    private double x;

    @NonNull
    private String name;

    @Override
    protected Object clone() {
        Point point = null;
        try {
            point = (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            point = new Point(x, name);
        }
        return point;
    }

    @Override
    public int compareTo(Object o) {
        var obj = ((Point)o);
        var res = (x - obj.x);
        if (res < 0) return -1;
        if (res > 0) return 1;

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        var point = (Point)obj;
        return x == point.x;
    }
}
