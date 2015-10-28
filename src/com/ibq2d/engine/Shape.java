package com.ibq2d.engine;

import java.util.ArrayList;

public abstract class Shape {
    public Vector2 position;

    public ArrayList<Edge> edges;

    public ArrayList<Vector2> vertices;

    public Shape(Vector2 position) {
        this.position = position;
        vertices = new ArrayList<Vector2>();
        edges = new ArrayList<Edge>();
    }

    public void scale(float byX, float byY) {
        // get to origin -> scale -> get back

    }

    public void translate(Vector2 byVec) {
        for (int i = 0; i < vertices.size(); i++)
            vertices.set(i, Vector2.add(vertices.get(i), byVec));
        position = Vector2.add(position, byVec);
    }

    public void translateX(float byX) {
        for (int i = 0; i < vertices.size(); i++)
            vertices.set(i, new Vector2(vertices.get(i).getX() + byX, vertices.get(i).getY()));
        position = new Vector2(position.getX() + byX, position.getY());
    }

    public void translateY(float byY) {
        for (int i = 0; i < vertices.size(); i++)
            vertices.set(i, new Vector2(vertices.get(i).getX(), vertices.get(i).getY() + byY));
        position = new Vector2(position.getX(), position.getY() + byY);
    }

    public void rotate(float degree) {
        for (int i = 0; i < vertices.size(); i++) {
            vertices.set(i, new Vector2((float) (vertices.get(i).getX() * Math.cos(degree) - vertices.get(i).getY() * Math.sin(degree)),
                    (float) (vertices.get(i).getX() * Math.sin(degree) + vertices.get(i).getY() * Math.cos(degree))));
        }
        position = new Vector2((float) (position.getX() * Math.cos(degree) - position.getY() * Math.sin(degree)),
                (float) (position.getX() * Math.sin(degree) + position.getY() * Math.cos(degree)));
    }
}
