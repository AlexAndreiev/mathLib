package com.alex.andreiev.geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;

public abstract class AbstractLine<P extends Point, L extends AbstractLine<P, L>> {

    protected TreeSet<P> points;

    public Set<P> getPoints() {
        var set = new TreeSet<P>();
        for (var point : points) {
            var clonePoint = (P) point.clone();
            set.add(clonePoint);
        }
        return set;
    }

    public AbstractLine(P point1, P point2) {
        Objects.requireNonNull(point1, "start point is null");
        Objects.requireNonNull(point2, "end point is null");
        points = new TreeSet<>();
        points.add(point1);
        points.add(point2);
    }

    abstract public void addPoint(P point);
    public P getMinPoint() { return points.first(); }
    public P getMaxPoint() { return points.last(); }
    public List<L> getSections() {
//        var sections = new ArrayList<P>();
//        sections.clone();
        //        for (points)
        return null;
    }
    abstract public double getLength();

}
