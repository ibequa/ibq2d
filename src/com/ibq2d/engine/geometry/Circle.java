package com.ibq2d.engine.geometry;

import com.ibq2d.engine.core.Sprite;
import com.ibq2d.engine.core.Time;

public class Circle extends Shape {
    private float radius;
    private float diameter;

    public Circle(float radius, Vector2 position) {
        super(position);
        this.radius = radius;

        diameter = radius * 2.0f;
        vertices.add(position);
    }

    public Circle(float radius) {
        this.radius = radius;

        diameter = radius * 2.0f;
        vertices.add(getPosition());
    }

    public Circle(Sprite sprite) {
        super(sprite.getPosition());
        this.radius = sprite.getWidth()/2;
        this.diameter = radius * 2.0f;

        vertices.add(sprite.getPosition());
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