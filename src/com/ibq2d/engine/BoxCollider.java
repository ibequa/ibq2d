package com.ibq2d.engine;

public class BoxCollider extends Collider {

    BoxCollider(float width, float height, Vector2 position, boolean isTrigger, ContactListener contactListener) {
        super(new Rect(width, height, position), contactListener);

        this.isTrigger = isTrigger;
    }

    BoxCollider(Rect rect, boolean isTrigger, ContactListener contactListener) {
        super(rect, contactListener);
        this.isTrigger = isTrigger;
    }
}
