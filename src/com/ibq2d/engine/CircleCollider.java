package com.ibq2d.engine;

public class CircleCollider extends Collider {

    CircleCollider(float radius, Vector2 position, boolean isTrigger, ContactListener contactListener) {
        super(new Circle(radius, position), contactListener);

        this.isTrigger = isTrigger;
    }
}
