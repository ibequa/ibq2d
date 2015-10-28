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
}
