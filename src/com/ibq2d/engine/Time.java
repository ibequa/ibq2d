package com.ibq2d.engine;

public final class Time {
    private Time() {}

    public static double deltaTime;

    public static final double NANOSECOND = 1000000000;

    public static double getTime() {
        return System.nanoTime() / NANOSECOND;
    }
}
