package com.alex.andreiev.geometry;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Point {

    final private double x;

    @Override
    protected Object clone() {
        Object p = null;
        try {
            p = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
