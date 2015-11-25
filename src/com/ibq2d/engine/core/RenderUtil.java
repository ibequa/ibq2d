package com.ibq2d.engine.core;

import com.ibq2d.engine.Application;

import static org.lwjgl.opengl.GL11.*;

final class RenderUtil {
    private RenderUtil() {}

    protected static void init() {
        // projection init
        glViewport(0, 0, Application.WIDTH, Application.HEIGHT);
        glMatrixMode(GL_MODELVIEW);

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(-Application.originX, Application.originX, Application.originY, -Application.originY, 1, -1);
        glMatrixMode(GL_MODELVIEW);

        // set buffers defaults
        glClearColor(0, 0, 0, 0);
        glClearDepth(1);

        glEnable(GL_TEXTURE_2D);

        // disable lighting
        glDisable(GL_LIGHTING);

        // enable face culling, clockwise;
        glEnable(GL_CULL_FACE);
        glCullFace(GL_BACK);
        glFrontFace(GL_CCW);

        // disable depth buffer
        glDisable(GL_DEPTH_TEST);

        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
    }

    protected static void clearScreen() {
        glClear(GL_COLOR_BUFFER_BIT);
    }
}
