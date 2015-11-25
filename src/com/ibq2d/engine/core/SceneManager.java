package com.ibq2d.engine.core;

import com.ibq2d.engine.Application;

public final class SceneManager {
    private SceneManager() {}

    private static Scene currentScene;
    private static int currentSceneIndex;

    protected static void setCurrentScene(Scene currentScene) {
        SceneManager.currentScene = currentScene;
    }

    protected static Scene getCurrentScene() {
        return currentScene;
    }

    protected static int getCurrentSceneIndex() {
        return currentSceneIndex;
    }

    protected static void setCurrentSceneIndex(int _currentSceneIndex) {
        currentSceneIndex = _currentSceneIndex;
    }

    public static int loadedScene() { return currentSceneIndex; }

    public static int getSceneIndex(String name) {
        String nameUnformated, nameFormated;
        for (int i = 0; i < Application.scenes.length; i++) {
            nameUnformated = Application.scenes.getClass().getName();
            nameFormated = nameUnformated.substring(nameUnformated.lastIndexOf(".") + 1);
            if (nameFormated.equals(name))
                return i;
        }

        System.err.println("Invalid scene name");
        System.exit(1);
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

  /*  protected static Scene getScene(int index) {
        if (index < Application.scenes.length)
            return Application.scenes[index];
        else {
            System.err.println("Invalid scene index");
            System.exit(1);
            return null;
        }
    }
    */

   /* public static Scene getScene(String name) {
        String nameUnformated, nameFormated;
        for (Scene scene : Application.scenes) {
            nameUnformated = scene.getClass().getName();
            nameFormated = nameUnformated.substring(nameUnformated.lastIndexOf(".") + 1);
            if (nameFormated.equals(name))
                return scene;
        }

        System.err.println("Invalid scene index");
        System.exit(1);
        return null;
    }*/

    // restarts loaded scene
    protected static void restart() {
        Core.onRestart = true;
    }
}
