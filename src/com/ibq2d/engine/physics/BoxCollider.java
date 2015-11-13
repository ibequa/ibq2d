package com.ibq2d.engine.physics;

import com.ibq2d.engine.geometry.Rect;
import com.ibq2d.engine.geometry.Vector2;

public class BoxCollider extends Collider {

    public BoxCollider(float width, float height, Vector2 position, boolean isTrigger, ContactListener contactListener) {
        super(new Rect(width, height, position), contactListener);

        this.isTrigger = isTrigger;
    }

    public BoxCollider(Rect rect, boolean isTrigger, ContactListener contactListener) {
        super(rect, contactListener);
        this.isTrigger = isTrigger;
    }
}
