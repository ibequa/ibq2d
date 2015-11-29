package com.ibq2d.engine.core;

import com.ibq2d.engine.Application;
import com.ibq2d.engine.physics.ContactDetection;
import org.lwjgl.openal.AL;

import java.util.HashSet;

class Core {

    private boolean isRunning;
    private static Scene runningScene;
    protected static HashSet<Scene> additives;

    protected static boolean onRestart = false;

    public static void main(String[] args) {
        Window.createWindow(Application.WIDTH, Application.HEIGHT, Application.APP_NAME);

        Core game = new Core();
        additives = new HashSet<>();

        game.awake();
    }


    Core() {
        isRunning = false;
    }

    protected void awake() {
        if (isRunning)
            return;

        RenderUtil.init();

        SceneManager.setCurrentScene(Application.scenes[0]);
        SceneManager.setCurrentSceneIndex(0);

        runningScene = SceneManager.getCurrentScene();

        runningScene.onInitializeScene();
        runningScene.awake();
        runningScene.onEnable();
        runningScene.start();

        run();
    }

    private void run() {
        isRunning = true;

        double lastTime = Time.getTime();
        double timeLeft = 0;
        double frameTime = 1.0 / (double) Application.targetFrameRate;

        boolean render;

        while (isRunning) {
            render = false;

            double currentTime = Time.getTime();
            double elapsedTime = currentTime - lastTime;
            lastTime = currentTime;

            timeLeft += elapsedTime;

            while (timeLeft > frameTime) {
                render = true;
                timeLeft -= frameTime;

                if (Window.isCloseRequested()) {
                    stop();
                    return;
                }

                Input.updateBuffer();
                ContactDetection.checkCollisions();

                runningScene.update();
                for (Scene additive : additives)
                    additive.update();

                if (onRestart) {
                    runningScene.onDestroy();

                    for (Scene additive : additives)
                        additive.destroy();

                    ContactDetection.listeners.clear();
                    ContactDetection.contactingWith.clear();
                    additives.clear();

                    runningScene.onInitializeScene();
                    runningScene.awake();
                    runningScene.onEnable();
                    runningScene.start();

                    System.gc();
                    onRestart = false;
                }

                if (runningScene != SceneManager.getCurrentScene()) {
                    if (runningScene != null)
                        runningScene.onDestroy();

                    for (Scene additive : additives)
                        additive.onDestroy();

                    ContactDetection.listeners.clear();
                    ContactDetection.contactingWith.clear();
                    additives.clear();

                    runningScene = SceneManager.getCurrentScene();
                    runningScene.onInitializeScene();
                    runningScene.awake();
                    runningScene.onEnable();
                    runningScene.start();

                    System.gc();
                }

                Time.deltaTime = elapsedTime;
            }

            if (render) {
                RenderUtil.clearScreen();
                render();
            }
        }
    }

    private void render() { Window.render();}

    private void stop() {
        if (!isRunning)
            return;

        isRunning = false;

        runningScene.onDestroy();

        for (Scene additive : additives)
            additive.onDestroy();

        for (Scene additive : additives)
            additive.onQuit();

        runningScene.onQuit();
        AL.destroy();

        System.gc();
        Window.dispose();
    }
}