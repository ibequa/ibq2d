package com.ibq2d.engine.geometry;

import com.ibq2d.engine.core.Sprite;
import com.ibq2d.engine.core.Time;

import java.util.ArrayList;

public class Circle extends Shape {
    private float radius;
    private float diameter;

    public Circle(float radius, Vector2 position) {
        vertices = new ArrayList<>();
        this.setPosition(position);

        this.radius = radius;
        diameter = radius * 2.0f;

        vertices.add(position);
    }

    public Circle(float radius) {
        vertices = new ArrayList<>();
        this.setPosition(Vector2.zero());

        this.radius = radius;
        diameter = radius * 2.0f;

        vertices.add(getPosition());
    }

    public Circle(Sprite sprite) {
        vertices = new ArrayList<>();
        this.setPosition(sprite.getPosition());

        this.radius = sprite.getWidth()/2;
        this.diameter = radius * 2.0f;

        vertices.add(sprite.getPosition());
    }

    @Override
    public boolean vectorInside(Vector2 vector) {
        float sqrDistance = Vector2.subtract(vector, this.getPosition()).sqrMagnitude();
        if (sqrDistance < this.getRadius())
            return true;
        else return (sqrDistance > Math.pow(this.getRadius(), 2)) ? false : true;
    }

    @Override
    public boolean intersectsWith(Circle circle) {
        float distance = Vector2.subtract(this.getPosition(), circle.getPosition()).magnitude();

        return (distance <= (this.getRadius() + circle.getRadius()));
    }

    @Override
    public boolean intersectsWith(Rect rect) {
        return rect.intersectsWith(this);
    }

    @Override
    public boolean intersectsWith(Polygon polygon) {
        for (Edge edge : polygon.edges)
            if (edge.intersectsWith(this))
                return true;
        return false;
    }

    @Override
    public boolean intersectsWith(Edge edge) {
        return edge.intersectsWith(this);
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
        this.diameter = 2*radius;
    }

    public float getDiameter() {
        return diameter;
    }

    public void setDiameter(float diameter) {
        this.diameter = diameter;
        this.radius = diameter/2;
    }

    @Override
    public void scale(float byX, float byY) {
        if (byX != byX)
            return;
        setRadius(getRadius() * byX);
    }

    @Override
    public void rotate(double degree) {
        return;
    }
}