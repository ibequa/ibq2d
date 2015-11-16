package com.ibq2d.engine.physics;

import com.ibq2d.engine.geometry.Edge;
import com.ibq2d.engine.geometry.Vector2;

public class EdgeCollider extends Collider {

    public EdgeCollider(Edge edge, boolean isTrigger, ContactListener contactListener) {
        super(edge, contactListener);
        this.isTrigger = isTrigger;
    }

    public EdgeCollider(Vector2 vec0, Vector2 vec1, boolean isTrigger, ContactListener contactListener) {
        super(new Edge(vec0, vec1), contactListener);
        this.isTrigger = isTrigger;
    }
}
