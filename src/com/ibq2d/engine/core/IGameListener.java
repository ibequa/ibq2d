package com.ibq2d.engine.core;

public interface IGameListener {
    void start();
    void awake();
    void update();
    void draw();
    void destroy();
    boolean isEnabled();
}