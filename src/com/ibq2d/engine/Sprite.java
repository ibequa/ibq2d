package com.ibq2d.engine;

public class Sprite {
    private Texture texture;

    private Vector2 position;
    private Vector2 scale;
    private float rotation;

    public Sprite(Texture texture) {
        this.texture = texture;
        position = Vector2.zero();
        scale = Vector2.one();
    }

    public Sprite(Texture texture, Vector2 position) {
        this.texture = texture;
        this.position = position;
        scale = Vector2.one();
    }

    public Vector2 getScale() {
        return scale;
    }

    public Vector2 getPosition() {
        return position;
    }

    // in degrees
    public float getRotation() {
        return rotation;
    }

    public void setRotation(float degree) {
        rotation = degree;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public void scale(float byX, float byY) {
        scale.set(scale.getX() * byX, scale.getY() * byY);
    }

    public void rotate(float degree) {
        this.rotation = (degree + getRotation()) % 360;
    }

    public void translate(Vector2 byVec) {
        position = Vector2.add(position, byVec);
    }

    public void translateX(float byX) {
        position.set(position.getX() + byX, position.getY());
    }

    public void translateY(float byY) {
        position.set(position.getX(), position.getY() + byY);
    }

    public void draw(Batch batch) {
        batch.begin();
        batch.draw(getTexture(), position.getX() - texture.getWidth()/2, position.getY() - texture.getHeight()/2, scale.getX(), scale.getY(), rotation);
        batch.end();
    }
}
