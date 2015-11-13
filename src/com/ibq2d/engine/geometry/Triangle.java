package com.ibq2d.engine.geometry;

public class Triangle extends Shape {

    public Triangle(Vector2 position, Vector2 p0, Vector2 p1, Vector2 p2) {
        super(position);
        vertices.add(p0);
        vertices.add(p1);
        vertices.add(p2);

        edges.add(new Edge(vertices.get(0), vertices.get(1)));
        edges.add(new Edge(vertices.get(1), vertices.get(2)));
        edges.add(new Edge(vertices.get(2), vertices.get(0)));
    }

    public Triangle(Vector2 p0, Vector2 p1, Vector2 p2) {
        vertices.add(p0);
        vertices.add(p1);
        vertices.add(p2);

        edges.add(new Edge(vertices.get(0), vertices.get(1)));
        edges.add(new Edge(vertices.get(1), vertices.get(2)));
        edges.add(new Edge(vertices.get(2), vertices.get(0)));
    }
}
