package com.ibq2d.engine.core;

import java.util.ArrayList;

public abstract class Scene implements IGameListener {

    public ArrayList<IGameListener> gameListeners;

    public abstract void initializeScene();

    @Override
    public void awake() {
        for (IGameListener gameListener : gameListeners)
            gameListener.awake();
    }

    @Override
    public void start() {
        for (IGameListener gameListener : gameListeners)
            if (gameListener.isEnabled())
                gameListener.start();
    }

    @Override
    public void update() {
        for (IGameListener gameListener : gameListeners)
            gameListener.update();
    }

    @Override
    public void draw() {
        for (IGameListener gameListener : gameListeners)
            gameListener.draw();
    }

    @Override
    public void destroy() {
        for (IGameListener gameListener : gameListeners)
            gameListener.destroy();
    }

    @Override
    public final boolean isEnabled() {
        return false;
    }
}
