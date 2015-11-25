package com.ibq2d.engine.core;

public final class Mathq {
    private Mathq() {}

    public static float clamp01(float x) {
        return (x > 1) ? 1 : (x < 0) ? 0 : x;
    }

    public static float clamp(float x, float min, float max) {
        return (x > max) ? max : (x < min) ? min : x;
    }

    public static int sign(float x, float y) {
        if (x == 0 && y == 0)
            return 0;
        else if (x > 0 && y < 0 || x < 0 && y > 0) return -1;
        else return 1;
    }
}
