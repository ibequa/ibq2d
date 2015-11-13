package com.ibq2d.engine.physics;

import com.ibq2d.engine.geometry.Shape;

public class Collider {
    public boolean isTrigger;
    public boolean enabled = true;

    public Shape shape;
    public ContactListener contactListener;

    public final int id;

    public Collider(Shape shape, ContactListener contactListener) {
        this.shape = shape;
        this.contactListener = contactListener;

        id = getClass().hashCode();

        ContactDetection.addListener(this);
    }
}
