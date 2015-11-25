package com.ibq2d.engine.geometry;

import java.util.Arrays;

public class Polygon extends Shape {

    public Polygon (Vector2[] vertices, Vector2 position) {
        super(position);
        this.vertices.addAll(Arrays.asList(vertices));
    }

    @Override
    public boolean vectorInside(Vector2 vector) {
        // TODO: IMPLEMENT
        return false;
    }

    @Override
    public boolean intersectsWith(Circle circle) {
        return circle.intersectsWith(this);
    }

    @Override
    public boolean intersectsWith(Rect rect) {
        // TODO: IMPLEMENT (SAT)
        return false;
    }

    @Override
    public boolean intersectsWith(Polygon polygon) {
        // TODO: IMPLEMENT (SAT)
        return false;
    }

    @Override
    public boolean intersectsWith(Edge _edge) {
        for (Edge edge : this.edges)
            if (edge.intersectsWith(_edge))
                return true;
        return false;
    }
}
