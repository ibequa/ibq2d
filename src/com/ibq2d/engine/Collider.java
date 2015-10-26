package com.ibq2d.engine;

public abstract class Collider {
    public boolean isTrigger;
    public boolean enabled = true;

    public Shape shape;
    public ContactListener contactListener;

    public final int id;

    Collider(Shape shape, ContactListener contactListener) {
        this.shape = shape;
        this.contactListener = contactListener;

        id = getClass().hashCode();

        ContactDetection.addListener(this);
    }
}