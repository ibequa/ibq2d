package com.ibq2d.engine;

import static org.lwjgl.opengl.GL11.*;

public class Player extends GameListener {

    Texture tex;

    @Override
    public void start() {
        tex = new Texture("testTexture.png");
    }

    @Override
    public void update() {
    }

    @Override
    public void draw() {
        tex.bind();

        glPushMatrix();
        glLoadIdentity();
        glBegin(GL_QUADS);

        glEnd();
        glPopMatrix();
    }
}