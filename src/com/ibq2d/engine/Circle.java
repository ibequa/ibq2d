package com.ibq2d.engine;

public class Circle extends Shape {
    public float radius;

    public Circle(float radius, Vector2 position) {
        super(position);
        this.radius = radius;
    }
}