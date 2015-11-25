package com.ibq2d.engine.geometry;

import com.ibq2d.engine.core.Mathq;

public final class Geometry {
    private Geometry() {}

    // 0 - points collinear; > 0 is right-turn; < 0 is left-turn
    public static int ccw(Vector2 p1, Vector2 p2, Vector2 p3) {
        return (int) (((p2.getY() - p1.getY()) * (p3.getX() - p2.getX())) - ((p3.getY() - p2.getY()) * (p2.getX() - p1.getX())));
    }

    public static boolean pointWithin(float p, float x0, float x1) {
        return (p >= x0 && p <= x1) || (p >= x1 && p <= x0);
    }

    public static boolean linesIntersect(Vector2 p1, Vector2 q1, Vector2 p2, Vector2 q2) {
        int a = Mathq.sign(ccw(p1,q1,p2), ccw(p1,q1,p2));
        int b = Mathq.sign(ccw(p2,q2,q1), ccw(p2,q2,q1));

        return a < 0 || b < 0;
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