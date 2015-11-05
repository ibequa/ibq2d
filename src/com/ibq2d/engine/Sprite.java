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

    public Sprite(Texture texture, Vector2 position, Vector2 scale, float rotation) {
        setPosition(position);
        scale(scale.getX(), scale.getY());
        setRotation(rotation);
    }

    public Vector2 getScale() {
        return scale;
    }

    public Vector2 getPosition() {
        return position;
    }

    public float getWidth() { return getTexture().getWidth(); }
    public float getHeight() { return getTexture().getHeight(); }

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

    public void setX(float x) { this.position.setX(x); }
    public void setY(float y) { this.position.setY(y); }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public void scale(float byX, float byY) {
        scale.set(scale.getX() * byX, scale.getY() * byY);
    }
    public void scaleXY(float by) { scale.set(scale.getX() * by, scale.getY() * by); }

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
        batch.draw(getTexture(), position.getX(), position.getY(), scale.getX(), scale.getY(), rotation);
    }
}
