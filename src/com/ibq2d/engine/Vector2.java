package com.ibq2d.engine;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Vector2 {
    private float x, y;

    private float magnitude, sqrMagnitude;
    private Vector2 normalized;

    public static final Vector2 one   = new Vector2(1, 1);
    public static final Vector2 zero  = new Vector2(0, 0);
    public static final Vector2 left  = new Vector2(-1, 0);
    public static final Vector2 right = new Vector2(1, 0);

    Vector2(float x, float y) {
        this.x = x;
        this.y = y;
        magnitude = sqrMagnitude =  -1;
    }

    Vector2() {
        magnitude = sqrMagnitude = -1;
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
        throw new NotImplementedException();
    }

    public float angleRad() {
        throw new NotImplementedException();
    }

    public static Vector2 lerp(Vector2 a, Vector2 b, float t) {
        t = Mathq.clamp01(t);
        return Vector2.add(a.multiplyBy(1 - t), b.multiplyBy(t)); // (1-t)*a + b*t
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
}