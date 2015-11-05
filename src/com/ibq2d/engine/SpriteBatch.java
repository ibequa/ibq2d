package com.ibq2d.engine;

import static org.lwjgl.opengl.GL11.*;

public class SpriteBatch implements Batch {
    @Override
    public void begin() {
        glPushMatrix();
        glLoadIdentity();
        glBegin(GL_QUADS);
    }

    @Override
    public void end() {
        glEnd();
        glPopMatrix();
    }

    @Override
    public void draw(Texture texture, float x, float y) {

    }

    @Override
    public void draw(Texture texture, float x, float y, float scaleX, float scaleY, float rotation) {
    }
}
