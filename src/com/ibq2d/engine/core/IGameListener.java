package com.ibq2d.engine.core;

interface IGameListener {
    void start();
    void update();
    void draw();
    void destroy();
}