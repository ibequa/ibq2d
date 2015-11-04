package com.ibq2d.engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window {

    public static void createWindow(int width, int height, String title) {
        Display.setTitle(title);

        try {
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.create();
            Display.setVSyncEnabled(true);
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }

    public static void render() {
        for (IGameListener gml : GameListenersList.gameListeners)
            gml.draw();

        Display.update();
    }

    public static void dispose() {
        Display.destroy();
    }

    public static boolean isCloseRequested() {
        return Display.isCloseRequested();
    }
}