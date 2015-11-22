package com.ibq2d.engine.core;

import com.ibq2d.engine.physics.ContactDetection;

public class Core {

    private boolean isRunning;
    private static Scene runningScene;

    protected static int onRestart = -1;

    public static void main(String[] args) {
        Window.createWindow(Application.WIDTH, Application.HEIGHT, Application.APP_NAME);

        Core game = new Core();

        game.awake();
    }


    Core() {
        isRunning = false;
    }

    protected void awake() {
        if (isRunning)
            return;

        RenderUtil.init();

        SceneManager.setCurrentScene(SceneManager.getScene(0));
        runningScene = SceneManager.getCurrentScene();

        runningScene.onInitializeScene();
        runningScene.awake();
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

                if (onRestart > -1) {
                    runningScene.destroy();

                    ContactDetection.listeners.clear();
                    ContactDetection.contactingWith.clear();

                    runningScene.onInitializeScene();
                    runningScene.awake();
                    runningScene.start();

                    System.gc();
                    onRestart = -1;
                }

                if (runningScene != SceneManager.getCurrentScene()) {
                    if (runningScene != null)
                        runningScene.destroy();

                    ContactDetection.listeners.clear();
                    ContactDetection.contactingWith.clear();

                    runningScene = SceneManager.getCurrentScene();
                    runningScene.onInitializeScene();
                    runningScene.awake();
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
        Window.dispose();
    }
}