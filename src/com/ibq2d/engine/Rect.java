package com.ibq2d.engine;

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

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    void calculateCoordinates() {
        float xMin = getPosition().getX() - width/2.0f;
        float xMax = xMin + width;
        float yMin = getPosition().getY() - height/2.0f;
        float yMax = yMin + height;
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