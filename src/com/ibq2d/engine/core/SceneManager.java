package com.ibq2d.engine.core;

import com.ibq2d.engine.Application;

public final class SceneManager {
    private SceneManager() {}

    private static Scene currentScene;
    private static int currentSceneIndex;

    protected static void setCurrentScene(Scene currentScene) {
        SceneManager.currentScene = currentScene;
    }

    public static Scene getCurrentScene() {
        return currentScene;
    }

    public static int getCurrentSceneIndex() {
        return currentSceneIndex;
    }

    protected static void setCurrentSceneIndex(int _currentSceneIndex) {
        currentSceneIndex = _currentSceneIndex;
    }

    public static int loadedScene() { return currentSceneIndex; }

    public static int getSceneIndex(String name) {
        String nameUnformated, nameFormated;
        for (int i = 0; i < Application.scenes.length; i++) {
            nameUnformated = Application.scenes[i].getClass().getName();
            nameFormated = nameUnformated.substring(nameUnformated.lastIndexOf(".") + 1);
            if (nameFormated.equals(name))
                return i;
        }
        return -1;
    }

    public static void load(int sceneIndex) {
        if (sceneIndex == SceneManager.getCurrentSceneIndex()) {
            SceneManager.restart();
            return;
        }
        SceneManager.setCurrentSceneIndex(sceneIndex);
        SceneManager.setCurrentScene(Application.scenes[sceneIndex]);
    }

    public static void load(String scene) {
        load(getSceneIndex(scene));
    }

    public static void loadAdditive(int sceneIndex) {
        Scene scene = Application.scenes[sceneIndex];
        Core.additives.add(scene);
        scene.onInitializeScene();
        scene.awake();
        scene.onEnable();
        scene.start();
    }

    public static void unloadAdditive(int sceneIndex) {
        Scene scene = Application.scenes[sceneIndex];
        assert(Core.additives.remove(scene));
        scene.destroy();
    }

    public static void loadPause(int sceneIndex) {

    }

    // restarts loaded scene
    protected static void restart() {
        Core.onRestart = true;
    }
}