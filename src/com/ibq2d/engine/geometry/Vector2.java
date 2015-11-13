package com.ibq2d.engine.geometry;

import com.ibq2d.engine.core.Mathq;

public class Vector2 implements Comparable<Vector2> {
    private float x, y;

    private float magnitude, sqrMagnitude;
    private Vector2 normalized;

    public static Vector2 zero() { return new Vector2(0, 0); }
    public static Vector2 one() { return new Vector2(1, 1); }
    public static Vector2 up() { return new Vector2(0, 1); }
    public static Vector2 down() { return new Vector2(0, -1); }
    public static Vector2 left() { return new Vector2(-1, 0); }
    public static Vector2 right() { return new Vector2(1, 0); }
    public static Vector2 MIN_VECTOR() { return new Vector2(Float.MIN_VALUE, Float.MIN_VALUE); }
    public static Vector2 MAX_VECTOR() { return new Vector2(Float.MAX_VALUE, Float.MAX_VALUE); }

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
        magnitude = sqrMagnitude =  -1;
    }

    public Vector2() {
        magnitude = sqrMagnitude = -1;
    }

    public Vector2(Vector2 vec) {
        this.x = vec.getX();
        this.y = vec.getY();
        this.magnitude = vec.magnitude();
        this.sqrMagnitude = vec.sqrMagnitude();
        this.normalized = vec.normalized();
    }

    private void resetVectorParams() {
        magnitude = -1;
        sqrMagnitude = -1;
        normalized = null;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
        resetVectorParams();
    }

    public void set(Vector2 vec) {
        this.x = vec.x;
        this.y = vec.y;
        resetVectorParams();
    }

    public void setX(float newX) {
        this.x = newX;
        resetVectorParams();
    }
    public void setY(float newY) {
        this.y = newY;
        resetVectorParams();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float magnitude() {
        if (this.magnitude < 0)
            return this.magnitude = (float) Math.sqrt(this.x * this.x + this.y * this.y);
        else return this.magnitude;
    }

    public float sqrMagnitude() {
        if (this.sqrMagnitude < 0)
            return this.sqrMagnitude = (this.x * this.x + this.y * this.y);
        else return this.sqrMagnitude;
    }

    public Vector2 normalized() {
        if (this.normalized == null)
            return this.normalized = this.divideBy(this.magnitude());
        else return this.normalized;
    }

    public void normalize() {
        this.x /= this.magnitude();
        this.y /= this.magnitude();
    }

    public float angle(Vector2 vec) {
        return (float) Math.toDegrees(angleRad(vec));
    }

    public float angleRad(Vector2 vec) {
        return (float) (Math.acos(dot(this, vec) / (this.magnitude() * vec.magnitude())));
    }

    public float angle() {
        return (float) Math.toDegrees(angleRad());
    }

    public float angleRad() {
        return (float) Math.acos(this.getX() / (this.magnitude()));
    }

    public float distanceTo(Vector2 to) {
        double sin = Math.sin(this.angleRad(to));
        return (float) sin * this.magnitude();
    }

    public static float distance(Vector2 from, Vector2 to) {
        double sin = Math.sin(from.angleRad(to));
        return (float) sin * from.magnitude();
    }

    public Vector2 rotate(double degree) {
        degree = Math.toRadians(degree);
        double sin = Math.sin(degree);
        double cos = Math.cos(degree);
        float tx = (float) (getX() * cos - getY() * sin);
        float ty = (float) (getX() * sin + getY() * cos);

        return new Vector2(tx, ty);
    }

    public Vector2 vectorProjection(Vector2 on) {
        float dot1 = dot(on, this);
        float dot2 = dot(on, on);

        return on.multiplyBy(dot1/dot2);
    }

    public float scalarProjection(Vector2 on) {
        return dot(this, on) / on.magnitude();
    }

    public static Vector2 lerp(Vector2 a, Vector2 b, float t) {
        t = Mathq.clamp01(t);
        return Vector2.add(a.multiplyBy(1 - t), b.multiplyBy(t)); // (1-t)*a + b*t
    }

    // all given vectors should lie on the same line
    public static boolean overlap(Vector2 a0, Vector2 a1, Vector2 b0, Vector2 b1) {
        Vector2 tmp;
        if (a0.compareTo(a1) == 1) {
            tmp = a0;
            a0 = a1;
            a1 = tmp;
        }
        if (b0.compareTo(b1) == 1) {
            tmp = b0;
            b0 = b1;
            b1 = tmp;
        }
        if (a0.getX() != b0.getX())
            return Geometry.lineSegmentOverlap(a0.getX(), a1.getX(), b0.getX(), b1.getX());
        else
            return Geometry.lineSegmentOverlap(a0.getY(), a1.getY(), b0.getY(), b1.getY());
    }

    public static Vector2 add(Vector2 a, Vector2 b) { return new Vector2(a.x + b.x, a.y + b.y); }
    public static Vector2 subtract(Vector2 a, Vector2 b) { return new Vector2(a.x - b.x, a.y - b.y); }

    public Vector2 divideBy(float number) { return new Vector2(this.x / number, this.y / number); }
    public Vector2 multiplyBy(float number) { return new Vector2(this.x * number, this.y * number); }

    public static float dot(Vector2 a, Vector2 b) { return a.x * b.x + a.y * b.y; }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    @Override
    public int compareTo(Vector2 o) {
        if (this.getX() == o.getX() && this.getY() == o.getY())
            return 0;
        else if (this.getY() <= o.getY() && this.getX() <= o.getX())
            return -1;
        else return 1;
    }
}