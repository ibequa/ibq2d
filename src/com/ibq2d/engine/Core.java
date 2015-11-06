package com.ibq2d.engine;

public class Core {

    private boolean isRunning;

    public static void main(String[] args) {
        Window.createWindow(Application.WIDTH, Application.HEIGHT, Application.APP_NAME);

        Core game = new Core();

        game.start();
    }


    Core() {
        isRunning = false;
    }

    protected void start() {
        if (isRunning)
            return;

        RenderUtil.init();

        for (IGameListener gameListener : GameListenersList.gameListeners)
            gameListener.start();

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

                for (IGameListener gameListener : GameListenersList.gameListeners)
                    gameListener.update();

                if (render) {
                    RenderUtil.clearScreen();
                    render();
                }

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