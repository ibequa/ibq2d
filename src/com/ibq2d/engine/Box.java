package com.ibq2d.engine;

public class Box extends Shape {
    public float width;
    public float height;

    public Box(float w, float h, Vector2 position) {
        super(position);
        width = w;
        height = h;
    }
}
