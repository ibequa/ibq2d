package com.ibq2d.engine.geometry;

import com.ibq2d.engine.Application;
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
        super();
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

    @Override
    public boolean vectorInside(Vector2 vector) {
        if (getRotation() != 0) {
            Edge extreme = new Edge(new Vector2(Application.WIDTH, vector.getY()), vector);
            int count = 0;
            for (Edge rectEdge : this.edges) {
                if (extreme.intersectsWith(rectEdge)) count++;
            }
            return (count&1) == 1;
        }
        float rectX = getPosition().getX();
        float rectY = getPosition().getY();
        float subWidth = getWidth()/2;
        float subHeight = getHeight()/2;

        return Geometry.pointWithin(vector.getX(), rectX - subWidth, rectX + subWidth) &&
                Geometry.pointWithin(vector.getY(), rectY - subHeight, rectY + subHeight);
    }

    @Override
    public boolean intersectsWith(Circle circle) {
        if (Math.pow(this.getOuterCircleRadius() + circle.getRadius(), 2) < Vector2.subtract(this.getPosition(), circle.getPosition()).sqrMagnitude())
            return false;
        Vector2 dir = Vector2.subtract(this.getPosition(), circle.getPosition()).normalized();
        Vector2 outerPoint = Vector2.add(circle.getPosition(), dir.multiplyBy(circle.getRadius()));
        return this.vectorInside(outerPoint);
    }

    @Override
    public boolean intersectsWith(Rect rect) {
        if (rect.getRotation() == 0 && this.getRotation() == 0) {
            Vector2 a1 = new Vector2(this.vertices.get(0).getX(), this.vertices.get(0).getY());
            Vector2 a2 = new Vector2(this.vertices.get(2).getX(), this.vertices.get(2).getY());
            Vector2 b1 = new Vector2(rect.vertices.get(0).getX(), rect.vertices.get(0).getY());
            Vector2 b2 = new Vector2(rect.vertices.get(2).getX(), rect.vertices.get(2).getY());

            return (a1.getX() < b2.getX() && a2.getX() > b1.getX() && a1.getY() < b2.getY() && a2.getY() > b1.getY());
        }
        // TODO: IMPLEMENT SAT!
        else return false;
    }

    @Override
    public boolean intersectsWith(Polygon polygon) {
        // TODO: IMPLEMENT SAT
        return false;
    }

    @Override
    public boolean intersectsWith(Edge edge) {
        return edge.intersectsWith(this);
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