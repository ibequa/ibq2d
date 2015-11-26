package com.ibq2d.engine.geometry;

import com.ibq2d.engine.Application;

import java.util.Arrays;

public class Polygon extends Shape {

    public Polygon (Vector2[] vertices, Vector2 position) {
        super(position);
        this.vertices.addAll(Arrays.asList(vertices));
    }

    public Polygon (Vector2[] vertices) {
        super();
        this.vertices.addAll(Arrays.asList(vertices));
    }

    @Override
    public boolean vectorInside(Vector2 vector) {
        Edge pointEdge = new Edge(vector, new Vector2(Application.WIDTH, vector.getY()));

        int count = 0;
        for (Edge polyEdge : this.edges) {
            if (polyEdge.intersectsWith(pointEdge))
                count++;
        }
        return (count&1) == 1;
    }

    @Override
    public boolean intersectsWith(Circle circle) {
        return circle.intersectsWith(this);
    }

    @Override
    public boolean intersectsWith(Rect rect) {
        // TODO: IMPLEMENT SAT
        return false;
    }

    @Override
    public boolean intersectsWith(Polygon polygon) {
        // TODO: IMPLEMENT SAT
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