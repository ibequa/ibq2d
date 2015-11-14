package com.ibq2d.engine.core;

import com.ibq2d.engine.geometry.Rect;
import static org.lwjgl.opengl.GL11.*;

public class GeometryBatch {

    public static void draw(Rect rect) {
        glPushMatrix();
        glLoadIdentity();

        glBegin(GL_QUADS);
        for (int i = 0; i < rect.vertices.size(); i++)
            glVertex2f(rect.vertices.get(i).getX() + Application.originX, rect.vertices.get(i).getY() + Application.originY);
        glEnd();
        glPopMatrix();
    }
}
