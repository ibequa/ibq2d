package com.ibq2d.engine.core;

public final class Time {
    private Time() {}

    protected static double deltaTime;

    public static float timeScale = 1;

    protected static final double NANOSECOND = 1_000_000_000;

    public static double getTime() {
        return System.nanoTime() / NANOSECOND;
    }

    public static double getDeltaTime() { return deltaTime; }
}