package com.ibq2d.engine;

public class Vector2 {
    public float x, y;

    private float magnitude, sqrMagnitude;
    private Vector2 normalized;

    public static final Vector2 one = new Vector2(1, 1);
    public static final Vector2 zero = new Vector2(0, 0);
    public static final Vector2 left = new Vector2(-1, 0);
    public static final Vector2 right = new Vector2(1, 0);

    Vector2(float x, float y) {
        this.x = x;
        this.y = y;
        magnitude = sqrMagnitude =  -1;
    }

    Vector2() {
        magnitude = sqrMagnitude = -1;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float magnitude() {
        if (this.magnitude == -1)
            return this.magnitude = (float) Math.sqrt(this.x * this.x + this.y * this.y);
        else return this.magnitude;
    }

    public float sqrMagnitude() {
        if (this.sqrMagnitude == -1)
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

    public static Vector2 lerp(Vector2 a, Vector2 b, float t) {
        t = Mathq.clamp01(t);
        return Vector2.add(a.multiplyBy(1 - t), b.multiplyBy(t)); // (1-t)*a + b*t
    }

    public static Vector2 add(Vector2 a, Vector2 b) { return new Vector2(a.x + b.x, a.y + b.y); }
    public static Vector2 subtract(Vector2 a, Vector2 b) { return new Vector2(a.x - b.x, a.y - b.y); }

    public Vector2 divideBy(float number) { return new Vector2(this.x / number, this.y / number); }
    public Vector2 multiplyBy(float number) { return new Vector2(this.x * number, this.y * number); }

    public static double dot(Vector2 a, Vector2 b) { return a.x * b.x + a.y * b.y; }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}