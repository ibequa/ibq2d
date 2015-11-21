package com.ibq2d.engine.core;

public final class SceneManager {
    private SceneManager() {}

    private static Scene currentScene;

    public static void setCurrentScene(Scene currentScene) {
        SceneManager.currentScene = currentScene;
    }

    public static Scene getCurrentScene() {
        return currentScene;
    }

    public static Scene getScene(int index) {
        return (index < Application.scenes.length) ? Application.scenes[index] : null;
    }

    public static Scene getScene(String name) {
        for (Scene scene : Application.scenes)
            if (scene.name == name)
                return scene;
        return null;
    }
}
