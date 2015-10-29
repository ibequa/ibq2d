package com.ibq2d.engine;

public class Core {

    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    public static final String TITLE = "ibq2d";

    public static int targetFrameRate = 60;

    private boolean isRunning;

    public static void main(String[] args) {
        Window.createWindow(WIDTH, HEIGHT, TITLE);

        Core game = new Core();

        game.start();
    }


    Core() {
        isRunning = false;
    }

    public void start() {
        if (isRunning)
            return;

        for (IGameListener gameListener : GameListenersList.gameListeners)
            gameListener.start();

        run();
    }

    private void run() {
        isRunning = true;

        double lastTime = Time.getTime();
        double timeLeft = 0;
        double frameTime = 1.0 / (double) Core.targetFrameRate;

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

                for (IGameListener gameListener : GameListenersList.gameListeners)
                    gameListener.update();

                if (render)
                    render();

                Time.deltaTime = elapsedTime;
            }
        }
    }

    private void render() { Window.render(); }

    private void stop() {
        if (!isRunning)
            return;

        isRunning = false;
        Window.dispose();
    }
}