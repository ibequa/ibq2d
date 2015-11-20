package com.ibq2d.engine.core;

import org.newdawn.slick.opengl.TextureLoader;
import static org.lwjgl.opengl.GL11.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Texture {

    private org.newdawn.slick.opengl.Texture texture;
    private float halfWidth;
    private float halfHeight;

    public Texture(String fileName) {
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        try {
            texture = TextureLoader.getTexture(ext, new FileInputStream(new File("./res/textures/" + fileName)));

            halfHeight = texture.getImageHeight() / 2;
            halfWidth = texture.getImageWidth() / 2;

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void bind() {
        texture.bind();
    }

    public void release() {
        texture.release();
    }

    public float getWidth() {
        return texture.getImageWidth();
    }

    public float getHeight() {
        return texture.getImageHeight();
    }

    public float getHalfWidth() {
        return halfWidth;
    }

    public float getHalfHeight() {
        return halfHeight;
    }

    public int getId() {
        return texture.getTextureID();
    }
}