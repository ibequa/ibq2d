package com.ibq2d.engine.geometry;

import com.ibq2d.engine.core.Sprite;

public class Rect extends Shape {
    private float width;
    private float height;

    public Rect(float w, float h, Vector2 position) {
        super(position);
        width = w;
        height = h;

        calculateCoordinates();
    }

    public Rect(float width, float height) {
        this.width = width;
        this.height = height;

        calculateCoordinates();
    }

    public Rect(Sprite sprite) {
        super(sprite.getPosition());
        this.width = sprite.getWidth();
        this.height = sprite.getHeight();

        calculateCoordinates();

        rotate(sprite.getRotation());
        scale(sprite.getScale().getX(), sprite.getScale().getY());
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getOuterCircleRadius() {
        return (Vector2.subtract(getPosition(), vertices.get(0))).magnitude();
    }

    private void calculateCoordinates() {
        float xMin = getPosition().getX() - width/2.0f;
        float xMax = xMin + width;
        float yMin = getPosition().getY() - height/2.0f;
        float yMax = yMin + height;

        // clockwise
        vertices.add(new Vector2(xMin, yMin));
        vertices.add(new Vector2(xMin, yMax));
        vertices.add(new Vector2(xMax, yMax));
        vertices.add(new Vector2(xMax, yMin));

        for(int i = 0; i < 3; i++) {
            edges.add(new Edge(vertices.get(i), vertices.get(i+1)));
        }
        edges.add(new Edge(vertices.get(3), vertices.get(0)));
    }
}