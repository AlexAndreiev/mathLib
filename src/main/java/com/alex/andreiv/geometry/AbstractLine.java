package com.alex.andreiv.geometry;

import java.util.List;

public abstract class AbstractLine<P extends Point, L extends AbstractLine> {

    private P start, end;
    private List<P> points;

    public P getStart() { return start; }
    public P getEnd() { return end; }

    public AbstractLine(P start, P end) {
        this.start = start;
        this.end = end;
    }

    abstract public void addPoint(P point);
    abstract public List<L> getSections();
    abstract public double getLength();

}
