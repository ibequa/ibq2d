package com.ibq2d.engine;

import org.newdawn.slick.opengl.TextureLoader;
import static org.lwjgl.opengl.GL11.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Texture {
    private float width, height;
    private boolean generateMipMaps;
    private int id;
    private boolean hasAlpha;

    public Texture(String fileName) {
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        try {
            org.newdawn.slick.opengl.Texture texture = TextureLoader.getTexture(ext, new FileInputStream(new File("./res/textures/" + fileName)));

            this.id = texture.getTextureID();
            this.width = texture.getImageWidth();
            this.height = texture.getImageHeight();
            this.hasAlpha = texture.hasAlpha();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void bind() {
        glBindTexture(GL_TEXTURE_2D, this.id);

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public int getId() {
        return id;
    }

    public boolean isHasAlpha() {
        return hasAlpha;
    }
}