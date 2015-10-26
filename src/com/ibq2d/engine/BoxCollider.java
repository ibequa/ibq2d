package com.ibq2d.engine;

public class BoxCollider extends Collider {

    public float width;
    public float height;

    BoxCollider(float width, float height, Vector2 position, boolean isTrigger, ContactListener contactListener) {
        super(new Box(width, height, position), contactListener);

        this.width = width;
        this.height = height;
        this.isTrigger = isTrigger;
    }
}
