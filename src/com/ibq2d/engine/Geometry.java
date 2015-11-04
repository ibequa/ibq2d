package com.ibq2d.engine;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public final class Geometry {
    private Geometry() {}

    // 0 - points collinear; > 0 is left-turn; < 0 is right-turn
    public int ccw(Vector2 p1, Vector2 p2, Vector2 p3) {
        return (int) ((p2.getX() - p1.getX())*(p3.getY() - p1.getY()) - (p2.getY() - p1.getY())*(p3.getX() - p1.getX()));
    }

    public static boolean isPointWithin(float p, float x0, float x1) {
        return (p >= x0 && p <= x1) || (p >= x1 && p <= x0);
    }

    // TODO: IMPLEMENT!!!
    public static boolean isVectorInShape(Vector2 vec, Shape shape) {
        throw new NotImplementedException();
    }

    public static boolean isVectorInRect(Vector2 vec, Rect rect) {
        if (rect.getRotation() != 0)
            return isVectorInShape(vec, rect);
        float rectX = rect.getPosition().getX();
        float rectY = rect.getPosition().getY();
        float subWidth = rect.getWidth()/2;
        float subHeight = rect.getHeight()/2;
        return isPointWithin(vec.getX(), rectX - subWidth, rectX + subWidth) &&
                isPointWithin(vec.getY(), rectY - subHeight, rectY + subHeight);
    }

    public static boolean isLinesIntersect(Vector2 line0p0, Vector2 line0p1, Vector2 line1p0, Vector2 line1p1, boolean continuous) {
        float k1 = (line0p1.getX() - line0p0.getX())/(line0p1.getY() - line0p0.getY());
        float m1 = line0p0.getY() - k1*line0p0.getX();

        float k2 = (line1p1.getX() - line1p0.getX())/(line1p1.getY() - line1p0.getY());
        float m2 = line1p0.getY() - k1*line1p0.getX();

        float supposed_x = (m2-m1)/(k1-k2);

        if (!continuous && !isPointWithin(supposed_x, line0p0.getX(), line0p1.getX()))
            return false;

        float y1 = k1*supposed_x + m1;
        float y2 = k2*supposed_x + m2;

        return (y1 == y2);
    }

    public static boolean isShapeInRect(Shape shape, Rect rect) {
        if (shape.getClass() == Circle.class) {
            return isShapeInRect(getRectFromCircle((Circle) shape), rect);
        }
        else {
            for (Vector2 vec : shape.vertices)
                if (!isVectorInRect(vec, rect))
                    return false;
            return true;
        }
    }

    public static Rect getRectFromCircle(Circle circle) {
        return new Rect(circle.getDiameter(), circle.getDiameter(), circle.getPosition());
    }

    public static boolean lineSegmentOverlap(float x, float y, float m, float n) {
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
        if (y < m || x > n)
            return false;
        else return true;
    }

    public static boolean shapesOverlap(Rect a, Circle b) {
        throw new NotImplementedException();
    }

    public static boolean shapesOverlap(Circle a, Circle b) {
        float distance = Vector2.subtract(a.getPosition(), b.getPosition()).magnitude();

        return (distance <= (a.getRadius() + b.getRadius()));
    }

    public static boolean shapesOverlap(Circle a, Rect b) {
        return shapesOverlap(b, a);
    }

    public static boolean shapesOverlap(Shape a, Shape b) {
      //  if (a.getRotation() == 0 && b.getRotation() == 0)
        //    return shapesPrimitiveOverlap(a, b);

        int i;
        Vector2 planeVec;
        int totalOverlap = 0;
        Vector2 xy[], mn[];
        for (i = 0; i < a.edges.size(); i++) {
            Edge edge = a.edges.get(i);
            planeVec = Vector2.subtract(edge.getVec0(), edge.getVec1());

            xy = findFarthests(planeVec, a.vertices);
            mn = findFarthests(planeVec, b.vertices);

            if (Vector2.overlap(xy[0], xy[1], mn[0], mn[1]))
                totalOverlap++;
        }

        if (totalOverlap != a.edges.size())
            return false;

        for (i = 0; i < b.edges.size(); i++) {
            Edge edge = b.edges.get(i);
            planeVec = Vector2.subtract(edge.getVec0(), edge.getVec1());

            xy = findFarthests(planeVec, b.vertices);
            mn = findFarthests(planeVec, a.vertices);

            if (Vector2.overlap(xy[0], xy[1], mn[0], mn[1]))
                totalOverlap++;
        }
        return (totalOverlap == (a.edges.size() + b.edges.size()));
    }

    // returns projected(!) farthest vectors
    private static Vector2[] findFarthests(Vector2 planeVec, ArrayList<Vector2> vertices) {
        Vector2[] mn = new Vector2[2];  // mn[0] is min; mn[1] is max;
        Vector2[] projections = new Vector2[vertices.size()];

        for (int i = 0; i < projections.length; i++)
            projections[i] = vertices.get(i).project(planeVec);

        mn[0] = mn[1] = projections[0];

        for (int i = 0; i < projections.length; i++) {
            if (mn[0].compareTo(projections[i]) == 1)
                mn[0] = projections[i];
            if (mn[1].compareTo(projections[i]) == -1)
                mn[1] = projections[i];
        }
        return mn;
    }

    // TODO IMPLEMENT!!!
    // when no rotation applied
    private static boolean shapesPrimitiveOverlap(Rect a, Rect b) {
        throw new NotImplementedException();
    }
}