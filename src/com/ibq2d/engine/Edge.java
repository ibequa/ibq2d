package com.ibq2d.engine;

public class Edge {
    private Vector2 vec0, vec1;

    private float k, m;

    public Edge(Vector2 vec0, Vector2 vec1) {
        this.vec0 = vec0;
        this.vec1 = vec1;
        k = 0; m = 0;

        calculateParams();
    }

    public float y(float x) {
        if (k == 0 && m == 0)
            calculateParams();

        return k*x + m;
    }

    private void calculateParams() {
        k = (vec1.getX() - vec0.getX())/(vec1.getY() - vec0.getY());
        m = vec1.getY() - k*vec1.getX();
    }

    @Override
    public String toString() {
        return "[" + vec0.toString() + ", " + vec1.toString() + "]";
    }
}
