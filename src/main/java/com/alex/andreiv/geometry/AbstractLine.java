package com.alex.andreiv.geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractLine<P extends Point, L extends AbstractLine> {

    private P start, end;
    protected List<P> points;

    public P getStart() { return start; }
    public P getEnd() { return end; }
    public List<P> getPoints() {
        var list = new ArrayList<P>();
        for (var point : points) {
            var clonePoint = (P)point.clone();
            list.add(clonePoint);
        }
        return list;
    }

    public AbstractLine(P startPoint, P endPoint) {
        Objects.requireNonNull(startPoint, "start point is null");
        Objects.requireNonNull(endPoint, "end point is null");
        this.start = startPoint;
        this.end = endPoint;
        points = new ArrayList<P>();
        points.add(startPoint);
        points.add(endPoint);

    }

    abstract public void addPoint(P point);
    abstract public List<L> getSections();
    abstract public double getLength();

}
