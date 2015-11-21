package com.ibq2d.engine.core;

import static org.lwjgl.opengl.GL11.*;

public class SpriteBatch {

    public static void draw(Texture texture, float x, float y) {
        x += Application.originX;
        y += Application.originY;

        glPushMatrix();
        glLoadIdentity();

        texture.bind();

        glTranslatef(x, y, 0);

        glBegin(GL_QUADS);
        glTexCoord2f(0, 1); glVertex2f(-texture.getHalfWidth(), -texture.getHalfHeight());
        glTexCoord2f(0, 0); glVertex2f(-texture.getHalfWidth(), texture.getHalfHeight());
        glTexCoord2f(1, 0); glVertex2f(texture.getHalfWidth(), texture.getHalfHeight());
        glTexCoord2f(1, 1); glVertex2f(texture.getHalfWidth(), -texture.getHalfHeight());
        glEnd();
        glPopMatrix();
    }

    public static void draw(Texture texture, float x, float y, float scaleX, float scaleY, float rotation) {
        x += Application.originX;
        y += Application.originY;

        glPushMatrix();
        glLoadIdentity();

        texture.bind();

        glTranslatef(x, y, 0);
        glRotatef(rotation, 0, 0, 1);
        glScalef(scaleX, scaleY, 0);

        glBegin(GL_QUADS);
        glTexCoord2f(0, 1); glVertex2f(-texture.getHalfWidth(), -texture.getHalfHeight());
        glTexCoord2f(0, 0); glVertex2f(-texture.getHalfWidth(), texture.getHalfHeight());
        glTexCoord2f(1, 0); glVertex2f(texture.getHalfWidth(), texture.getHalfHeight());
        glTexCoord2f(1, 1); glVertex2f(texture.getHalfWidth(), -texture.getHalfHeight());
        glEnd();
        glPopMatrix();
    }
}