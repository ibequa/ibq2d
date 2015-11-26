package com.ibq2d.engine.geometry;

public final class Geometry {
    private Geometry() {}

    // 0 - points collinear; 1 is right-turn; -1 is left-turn
    public static int ccw(Vector2 p1, Vector2 p2, Vector2 p3) {
        int val = (int) ((p2.getY() - p1.getY()) * (p3.getX() - p2.getX()) -
                (p3.getY() - p2.getY()) * (p2.getX() - p1.getX()));

        if (val == 0) return 0;

        return (val > 0) ? 1 : -1;
    }

    public static boolean pointWithin(float p, float x0, float x1) {
        return (p >= x0 && p <= x1) || (p >= x1 && p <= x0);
    }

    public static boolean linesIntersect(Vector2 p1, Vector2 q1, Vector2 p2, Vector2 q2) {
        int o1 = ccw(p1,q1,p2);
        int o2 = ccw(p1,q1,q2);
        int o3 = ccw(p2,q2,p1);
        int o4 = ccw(p2,q2,q1);

        if (o1 != o2 && o3 != o4) {
            return true;
        }

        if (o1 == 0 && pointWithin(p2.getX(), p1.getX(), q1.getX()))
            return true;
        if (o2 == 0 && pointWithin(q2.getX(), p1.getX(), q1.getX()))
            return true;
        if (o3 == 0 && pointWithin(p1.getX(), p2.getX(), q2.getX()))
            return true;
        if (o4 == 0 && pointWithin(q1.getX(), p2.getX(), q2.getX()))
            return true;
        
        return false;
    }

    public static boolean linesOverlap(float x, float y, float m, float n) {
        float tmp;
        if (x > y) {
            tmp = x;
            x = y;
            y = tmp;
        }
        if (m > n) {
            tmp = m;
            m = n;
            n = tmp;
        }
        return !(y < m || x > n);
    }
}