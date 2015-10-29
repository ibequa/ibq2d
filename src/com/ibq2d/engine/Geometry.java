package com.ibq2d.engine;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public final class Geometry {
    private Geometry() {}

    // 0 - points collinear; > 0 is left-turn; < 0 is right-turn
    public int ccw(Vector2 p1, Vector2 p2, Vector2 p3) {
        return (int) ((p2.getX() - p1.getX())*(p3.getY() - p1.getY()) - (p2.getY() - p1.getY())*(p3.getX() - p1.getX()));
    }

    public static boolean isPointWithin(float p, float x0, float x1) {
        return (p >= x0 && p <= x1) || (p >= x1 && p <= x0);
    }

    public static boolean isVectorInRect(Vector2 vec, Rect rect) {
        throw new NotImplementedException();
    }

    public static boolean isVectorInCircle(Vector2 vec, Circle circle) {
        return (Vector2.subtract(vec, circle.getPosition()).magnitude() <= circle.getDiameter());
    }

    // TODO: IMPLEMENT!!!
    public static boolean isVectorInTriangle(Vector2 vec, Triangle trig) {
        throw new NotImplementedException();
    }

    public static boolean isLinesIntersect(Vector2 line0p0, Vector2 line0p1, Vector2 line1p0, Vector2 line1p1, boolean contiguous) {
        float k1 = (line0p1.getX() - line0p0.getX())/(line0p1.getY() - line0p0.getY());
        float m1 = line0p0.getY() - k1*line0p0.getX();

        float k2 = (line1p1.getX() - line1p0.getX())/(line1p1.getY() - line1p0.getY());
        float m2 = line1p0.getY() - k1*line1p0.getX();

        float supposed_x = (m2-m1)/(k1-k2);

        if (!contiguous && !isPointWithin(supposed_x, line0p0.getX(), line0p1.getX()))
            return false;

        float y1 = k1*supposed_x + m1;
        float y2 = k2*supposed_x + m2;

        return (y1 == y2);
    }

    public static boolean shapesOverlap(Rect a, Circle b) {
        throw new NotImplementedException();
    }

    public static boolean shapesOverlap(Circle a, Circle b) {
        float distance = Vector2.subtract(a.getPosition(), b.getPosition()).magnitude();

        return (distance <= (a.getRadius() + b.getRadius()));
    }
}