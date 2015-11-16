package com.ibq2d.engine.geometry;

import java.util.ArrayList;

public abstract class Shape {
    private Vector2 position;
    private float rotation;

    public ArrayList<Edge> edges;

    public ArrayList<Vector2> vertices;

    public Shape(Vector2 position) {
        this.position = position;
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public Shape() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
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

    public void setX(float x) {
        translateX(x - getPosition().getX());
        this.position.setX(x);
    }

    public void setY(float y) {
        translateY(y - getPosition().getY());
        this.position.setY(y);
    }

    public void scale(float byX, float byY) {
        Vector2 oldPos = getPosition();
        translate(new Vector2(-oldPos.getX(), -oldPos.getY()));
        for(int i = 0; i < vertices.size(); i++) {
            Vector2 vertex = vertices.get(i);
            vertex.set(vertex.getX() * byX, vertex.getY() * byY);
        }
        translate(oldPos);
    }
    public void scaleX(float byX) {
        for (int i = 0; i < vertices.size(); i++) {
            Vector2 vertex = vertices.get(i);
            vertex.setX(vertex.getX() * byX);
        }
    }
    public void scaleY(float byY) {
        for (int i = 0; i < vertices.size(); i++) {
            Vector2 vertex = vertices.get(i);
            vertex.setY(vertex.getY() * byY);
        }
    }

    public void translate(Vector2 byVec) {
        for (int i = 0; i < vertices.size(); i++)
            vertices.get(i).set(Vector2.add(vertices.get(i), byVec));
        position = Vector2.add(position, byVec);
    }

    public void translateX(float byX) {
        for (int i = 0; i < vertices.size(); i++)
            vertices.get(i).set(vertices.get(i).getX() + byX, vertices.get(i).getY());
        position = new Vector2(position.getX() + byX, position.getY());
    }

    public void translateY(float byY) {
        for (int i = 0; i < vertices.size(); i++)
            vertices.get(i).set(vertices.get(i).getX(), vertices.get(i).getY() + byY);
        position = new Vector2(position.getX(), position.getY() + byY);
    }

    public void rotate(double degree) {
        Vector2 oldPos = getPosition();
        translate(new Vector2(-oldPos.getX(), -oldPos.getY()));
        this.rotation = ((float) degree + getRotation()) % 360;

        degree = Math.toRadians(degree);
        for (int i = 0; i < vertices.size(); i++) {
            vertices.get(i).set(new Vector2((float) (vertices.get(i).getX() * Math.cos(degree) - vertices.get(i).getY() * Math.sin(degree)),
                    (float) (vertices.get(i).getX() * Math.sin(degree) + vertices.get(i).getY() * Math.cos(degree))));
        }
        translate(oldPos);
    }
}