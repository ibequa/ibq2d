package com.ibq2d.engine;

import static org.lwjgl.opengl.GL11.*;


public final class RenderUtil {
    private RenderUtil() {}

    public static void init() {
        glClearColor(1, 0, 0, 0);
        glClearDepth(1);

        // enable face culling, clockwise;
        glEnable(GL_CULL_FACE);
        glCullFace(GL_BACK);
        glFrontFace(GL_CW);

        // set depth buffer
        glEnable(GL_DEPTH_TEST);
        glDepthMask(true);
        glDepthFunc(GL_LEQUAL);
    }

    public static void clearScreen() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }
}
