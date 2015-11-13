package com.ibq2d.engine.geometry;

import java.util.ArrayList;

public abstract class Shape {
    private Vector2 position;
    private float rotation;

    public ArrayList<Edge> edges;

    public ArrayList<Vector2> vertices;

    public Shape(Vector2 position) {
        this.position = position;
        vertices = new ArrayList<Vector2>();
        edges = new ArrayList<Edge>();
    }

    public Shape() {
        vertices = new ArrayList<Vector2>();
        edges = new ArrayList<Edge>();
        this.position = new Vector2(0, 0);
    }

    public Vector2 getPosition() {
        return position;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float degree) {
        rotate(-getRotation());
        rotate(degree);
    }

    public void setPosition(Vector2 newPosition) {
        translate(Vector2.subtract(newPosition, getPosition()));
        this.position = newPosition;
    }

    public void scale(float byX, float byY) {
        for(int i = 0; i < vertices.size(); i++) {
            Vector2 vertex = vertices.get(i);
            vertex.set((vertex.getX() - position.getX()) * byX + position.getX(), ((vertex.getY() - position.getY()) * byY + position.getY()));
        }
    }
    public void scaleX(float byX) {
        for (int i = 0; i < vertices.size(); i++) {
            Vector2 vertex = vertices.get(i);
            vertex.setX((vertex.getX() - position.getX()) * byX + position.getX());
        }
    }
    public void scaleY(float byY) {
        for (int i = 0; i < vertices.size(); i++) {
            Vector2 vertex = vertices.get(i);
            vertex.setY((vertex.getY() - position.getY()) * byY + position.getY());
        }
    }

    public void translate(Vector2 byVec) {
        for (int i = 0; i < vertices.size(); i++)
            vertices.get(i).set(Vector2.add(vertices.get(i), byVec));
        position = Vector2.add(position, byVec);
    }

    public void translateX(float byX) {
        for (int i = 0; i < vertices.size(); i++)
            vertices.get(i).set(new Vector2(vertices.get(i).getX() + byX, vertices.get(i).getY()));
        position = new Vector2(position.getX() + byX, position.getY());
    }

    public void translateY(float byY) {
        for (int i = 0; i < vertices.size(); i++)
            vertices.get(i).set(new Vector2(vertices.get(i).getX(), vertices.get(i).getY() + byY));
        position = new Vector2(position.getX(), position.getY() + byY);
    }

    public void rotate(double degree) {
        this.rotation = ((float) degree + getRotation()) % 360;

        degree = Math.toRadians(degree);
        for (int i = 0; i < vertices.size(); i++) {
            vertices.get(i).set(new Vector2((float) (vertices.get(i).getX() * Math.cos(degree) - vertices.get(i).getY() * Math.sin(degree)),
                    (float) (vertices.get(i).getX() * Math.sin(degree) + vertices.get(i).getY() * Math.cos(degree))));
        }
    }
}