package com.ibq2d.engine;

public final class Mathq {
    private Mathq() {}

    public static float clamp01(float x) {
        return (x > 1) ? 1 : (x < 0) ? 0 : x;
    }

    public static float clamp(float x, float min, float max) {
        return (x > max) ? max : (x < min) ? min : x;
    }
}
