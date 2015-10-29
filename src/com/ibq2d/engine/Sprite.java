package com.ibq2d.engine;

public class Sprite {
    public Texture texture;

    public Sprite(Texture texture) {
        this.texture = texture;
    }

    public void scale(float byX, float byY) {
        // gl scale
    }

    public void rotate(float degree) {
        // gl rotate
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
