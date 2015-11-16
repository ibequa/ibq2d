package com.ibq2d.engine.geometry;

public class Edge extends Shape {
    private Vector2 vec0, vec1;

    private Vector2 normal;

    private float k, m, angleRad;

    public Edge(Vector2 vec0, Vector2 vec1) {
        this.vec0 = vec0;
        this.vec1 = vec1;
        k = 0; m = 0;

        calculateParams();

        vertices.add(vec0);
        vertices.add(vec1);
    }

    public float y(float x) {
        if (k == 0 && m == 0)
            calculateParams();

        return k*x + m;
    }

    public Vector2 getVec0() {
        return vec0;
    }

    public Vector2 getVec1() {
        return vec1;
    }

    public boolean overlap(Circle circle) {
        return distanceFrom(circle.getPosition()) <= circle.getRadius();
    }

    public float distanceFrom(Vector2 p) {
        Vector2 b = getVec0();
        Vector2 pb = Vector2.subtract(p, b);
        Edge edge = new Edge(p, b);

        float angle = Math.abs(edge.angleRad - angleRad);
        if (angle > Math.PI/2)
            angle = (float) Math.PI - angle;

        return pb.magnitude() * (float) Math.sin(angle);
    }

    private void calculateParams() {
        float dy = vec1.getY() - vec0.getY();
        float dx = vec1.getX() - vec0.getX();
        k = dy / dx;
        angleRad = (dx == 0) ? (float) Math.PI/2 : (float) Math.atan(k);
        m = vec1.getY() - k*vec1.getX();

        Vector2 m = Vector2.subtract(getVec0(), getVec1());
        normal = new Vector2(m.getY(), -m.getX());
    }

    @Override
    public String toString() {
        return "[" + vec0.toString() + ", " + vec1.toString() + "]";
    }
}
