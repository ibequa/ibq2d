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

    public static int getCurrentSceneIndex() {
        for (int i = 0; i < Application.scenes.length; i++)
            if (currentScene.equals(Application.scenes[i]))
                return i;
        return -1;
    }

    public static Scene getScene(int index) {
        return (index < Application.scenes.length) ? Application.scenes[index] : null;
    }

    public static Scene getScene(String name) {
        String nameUnformated, nameFormated;
        for (Scene scene : Application.scenes) {
            nameUnformated = scene.getClass().getName();
            nameFormated = nameUnformated.substring(nameUnformated.lastIndexOf(".") + 1);
            if (nameFormated.equals(name))
                return scene;
        }
        return null;
    }

    public static void restart() {
        Core.onRestart = getCurrentSceneIndex();
    }
}
