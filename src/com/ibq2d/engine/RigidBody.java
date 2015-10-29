package com.ibq2d.engine;

public class RigidBody {
    private Sprite sprite;
    private Collider collider;

    public RigidBody(Sprite sprite, Collider collider) {
        this.sprite = sprite;
        this.collider = collider;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Collider getCollider() {
        return collider;
    }

    public void setCollider(Collider collider) {
        this.collider = collider;
    }

    public void translate(Vector2 byVec) {
        sprite.translate(byVec);
        collider.shape.translate(byVec);
    }

    public void translateX(float byX) {
        sprite.translateX(byX);
        collider.shape.translateX(byX);
    }

    public void translateY(float byY) {
        sprite.translateY(byY);
        collider.shape.translateY(byY);
    }

    public void rotate(float degree) {
        sprite.rotate(degree);
        collider.shape.rotate(degree);
    }

    public void scale(float byX, float byY) {
        sprite.scale(byX, byY);
        collider.shape.scale(byX, byY);
    }
}
