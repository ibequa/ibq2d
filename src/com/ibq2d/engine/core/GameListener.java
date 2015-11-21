package com.ibq2d.engine.core;

import com.ibq2d.engine.core.IGameListener;

public abstract class GameListener implements IGameListener {

    boolean enabled;

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
    public final void destroy() {

    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}