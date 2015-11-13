package com.ibq2d.engine.physics;

import com.ibq2d.engine.geometry.Circle;
import com.ibq2d.engine.geometry.Vector2;

public class CircleCollider extends Collider {

    public CircleCollider(float radius, Vector2 position, boolean isTrigger, ContactListener contactListener) {
        super(new Circle(radius, position), contactListener);

        this.isTrigger = isTrigger;
    }

    public CircleCollider(Circle circle, boolean isTrigger, ContactListener contactListener) {
        super(circle, contactListener);
        this.isTrigger = isTrigger;
    }
}
