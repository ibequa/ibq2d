package com.ibq2d.engine.core;

import java.util.ArrayList;

public abstract class Scene implements IGameListener {

    ArrayList<GameListener> gameListeners = new ArrayList<>();

    public abstract void initializeScene();

    public final void AddToScene(GameListener gameListener) {
        gameListeners.add(gameListener);
    }

    public final void AddToScenePersistent(GameListener gameListener) {
        Core.persistentObjects.add(gameListener);
    }

    public GameListener findGameListener(String gameListener) {
        for (GameListener gmls : gameListeners) {
            String nameUnformatted = gmls.getClass().getName();
            String nameFormatted = nameUnformatted.substring(nameUnformatted.lastIndexOf(".") + 1);
            if (nameFormatted.equals(gameListener))
                return gmls;
        }
        return null;
    }

    public final void onInitializeScene() {
        initializeScene();
    }

    @Override
    public final void awake() {
        for (GameListener gameListener : gameListeners)
            gameListener.awake();
    }

    @Override
    public final void start() {
        for (GameListener gameListener : gameListeners)
            if (gameListener.isEnabled()) {
                gameListener.start();
                gameListener.startCalled = true;
            }
    }

    @Override
    public final void onDisable() {
    }

    @Override
    public final void onEnable() {
        for (GameListener gameListener : gameListeners) {
            if (gameListener.isEnabled())
                gameListener.onEnable();
        }
    }

    @Override
    public final void update() {
        for (GameListener gameListener : gameListeners)
            if (gameListener.isEnabled())
                gameListener.update();
    }

    @Override
    public final void draw() {
        for (GameListener gameListener : gameListeners)
            if (gameListener.isEnabled())
                gameListener.draw();
    }

    public final void onDestroy() {
        for (GameListener gameListener : gameListeners) {
            gameListener.destroy();
            //gameListener = null;
        }

        gameListeners.clear();
    }

    @Override
    public final void destroy() {}

    @Override
    public final void onQuit() {
        for (GameListener gameListener : gameListeners)
            gameListener.onQuit();
    }

    @Override
    public final boolean isEnabled() {
        return false;
    }
}