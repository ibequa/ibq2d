package com.ibq2d.engine.geometry;

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
            return shapesOverlap(rect, (Circle) shape);
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
        return !(y < m || x > n);
    }

    public static boolean shapesOverlap(Rect a, Circle b) {
        if (Math.pow(a.getOuterCircleRadius() + b.getRadius(), 2) < Vector2.subtract(a.getPosition(), b.getPosition()).sqrMagnitude())
            return false;
        Vector2 dir = Vector2.subtract(a.getPosition(), b.getPosition()).normalized();
        Vector2 outerPoint = Vector2.add(b.getPosition(), dir.multiplyBy(b.getRadius()));

        return isVectorInRect(outerPoint, a);
    }

    public static boolean shapesOverlap(Circle a, Circle b) {
        float distance = Vector2.subtract(a.getPosition(), b.getPosition()).magnitude();

        return (distance <= (a.getRadius() + b.getRadius()));
    }

    public static boolean shapesOverlap(Circle a, Rect b) {
        return shapesOverlap(b, a);
    }

    public static boolean shapesOverlap(Shape a, Shape b) {
        if (a.getRotation() == 0 && b.getRotation() == 0)
           return shapesPrimitiveOverlap((Rect) a, (Rect) b);
        else return false;

      /*  for (int i = 0 ; i < a.vertices.size(); i++) {
            Edge edge = a.edges.get(i);
            Vector2 planeVec = Vector2.subtract(edge.getVec1(), edge.getVec0());

            Vector2[] projShapeA = getProjections(planeVec, a.vertices);
            Vector2[] projShapeB = getProjections(planeVec, b.vertices);

            Vector2[] minMaxShapeA = getMinMax(projShapeA);
            Vector2[] minMaxShapeB = getMinMax(projShapeB);

            //if (Vector2.overlap(minMaxShapeA[0], minMaxShapeA[1], minMaxShapeB[0], minMaxShapeB[1]))
            if (!(minMaxShapeA[1].compareTo(minMaxShapeB[0]) < 0 || minMaxShapeA[0].compareTo(minMaxShapeB[1]) > 0))
                continue;
            else return false;
        }
        for (int i = 0 ; i < b.vertices.size(); i++) {
            Edge edge = b.edges.get(i);
            Vector2 planeVec = Vector2.subtract(edge.getVec1(), edge.getVec0());

            Vector2[] projShapeA = getProjections(planeVec, a.vertices);
            Vector2[] projShapeB = getProjections(planeVec, b.vertices);

            Vector2[] minMaxShapeA = getMinMax(projShapeA);
            Vector2[] minMaxShapeB = getMinMax(projShapeB);

            if (!(minMaxShapeA[1].compareTo(minMaxShapeB[0]) < 0 || minMaxShapeA[0].compareTo(minMaxShapeB[1]) > 0))
                continue;
            else return false;
        }

        return true;*/
    }

    private static Vector2[] getMinMax(Vector2[] vectors) {
        Vector2[] minMax = new Vector2[2];
        minMax[0] = minMax[1]= vectors[0];

        for (int i = 0; i < vectors.length; i++) {
            if (minMax[0].compareTo(vectors[i]) > 0)
                minMax[0] = vectors[i];
            if (minMax[1].compareTo(vectors[i]) < 0)
                minMax[1] = vectors[i];
        }
        return minMax;
    }

    private static Vector2[] getProjections(Vector2 planeVec, ArrayList<Vector2> verticies) {
        Vector2[] proj = new Vector2[verticies.size()];
        for (int i = 0; i < proj.length; i++)
            proj[i] = verticies.get(i).vectorProjection(planeVec);
        return proj;
    }

    // when no rotation applied
    private static boolean shapesPrimitiveOverlap(Rect a, Rect b) {
        Vector2 a1 = new Vector2(a.vertices.get(0).getX(), a.vertices.get(0).getY());
        Vector2 a2 = new Vector2(a.vertices.get(2).getX(), a.vertices.get(2).getY());
        Vector2 b1 = new Vector2(b.vertices.get(0).getX(), b.vertices.get(0).getY());
        Vector2 b2 = new Vector2(b.vertices.get(2).getX(), b.vertices.get(2).getY());

        return (a1.getX() < b2.getX() && a2.getX() > b1.getX() && a1.getY() < b2.getY() && a2.getY() > b1.getY());
    }
}