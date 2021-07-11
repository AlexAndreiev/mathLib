package com.alex.andreiev.geometry;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;
import java.util.Collection;

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

    public void addPoint(P point) {
        Objects.requireNonNull(point, "argument is null");
        if (points.contains(point))
            throw new IllegalArgumentException("Line already contains this point");
        points.add(point);
    }

    public void addPoints(Collection<P> points) {
        for (var point : points)
            addPoint(point);
    }

    public void removePoint(P point) {
        Objects.requireNonNull(point, "argument is null");
        if (points.size() == 2)
            throw new RuntimeException("point can't be deleted. Line has only 2 points.");
        points.remove(point);
    }

    public void removePoints(Collection<P> points) {
        for (var point : points)
            removePoint(point);
    }

    public P getMinPoint() { return points.first(); }

    public P getMaxPoint() { return points.last(); }

    public List<L> getSections() {
        var sections = new ArrayList<L>();
        var iterator = points.iterator();
        var startPoint = iterator.next();
        var pointClass = startPoint.getClass();
        try {
            var constructor = this.getClass().getConstructor(new Class[] {pointClass, pointClass});
            while (iterator.hasNext()) {
                var endPoint = iterator.next();
                var selection = (L) constructor.newInstance(startPoint, endPoint);
                sections.add(selection);
                startPoint = endPoint;
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException
                | NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException("AbstractLine.getSections(): " + e.getMessage(), e.getCause());
        }
        return sections;
    }

    abstract public double getLength();

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        var line = (AbstractLine)obj;
//        under the hood AbstractSet checks if the length is the same
//        and call TreeSet.containsAll->Map.contains method
        return line.points.equals(points);
    }
}
