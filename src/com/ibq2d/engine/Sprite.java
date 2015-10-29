package com.ibq2d.engine;

public class Sprite {
    private Texture texture;

    private Vector2 position;
    private float rotation;

    public Sprite(Texture texture) {
        this.texture = texture;
        position = Vector2.zero;
    }

    public Vector2 getPosition() {
        return position;
    }

    // in degrees
    public float getRotation() {
        return rotation;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
        // gl change pos
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public void scale(float byX, float byY) {
        // gl scale
    }

    public void rotate(float degree) {
        // gl rotate
        this.rotation = (degree + getRotation()) % 360;
    }

    public void translate(Vector2 byVec) {
        // gl translate
    }

    public void translateX(float byX) {
        // gl translate with y = const
    }

    public void translateY(float byY) {
        // gl translate with x = const
    }

}
