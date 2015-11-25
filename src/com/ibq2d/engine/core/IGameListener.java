package com.ibq2d.engine.core;

interface IGameListener {
    void start();
    void awake();
    void update();
    void draw();
    void destroy();
    boolean isEnabled();
    void onEnable();
    void onDisable();
    void onQuit();
}