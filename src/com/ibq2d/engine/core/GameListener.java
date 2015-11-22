package com.ibq2d.engine.core;

public abstract class GameListener implements IGameListener {

    public boolean enabled = true;

    @Override
    public void awake() {

    }

    @Override
    public void start() {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}