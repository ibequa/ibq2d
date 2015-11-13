package com.ibq2d.engine.core;

import com.ibq2d.engine.core.Application;

import static org.lwjgl.opengl.GL11.*;

public final class RenderUtil {
    private RenderUtil() {}

    protected static void init() {
        // projection init
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, Application.WIDTH, 0, Application.HEIGHT, -1, 1);
        glMatrixMode(GL_MODELVIEW);

        // set buffers defaults
        glClearColor(0, 0, 0, 0);

        // enable face culling, clockwise;
        glEnable(GL_CULL_FACE);
        glCullFace(GL_BACK);
        glFrontFace(GL_CW);

        // disable depth buffer
        glDisable(GL_DEPTH_TEST);

        // enable textures
        glEnable(GL_TEXTURE_2D);
    }

    protected static void clearScreen() {
        glClear(GL_COLOR_BUFFER_BIT);
    }
}
