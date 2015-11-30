package com.ibq2d.engine.physics;

import com.ibq2d.engine.geometry.*;

public class RigidBody {
    private int mass;
    private Vector2 velocity;
    private float friction, restitution;
    private Collider collider;

    public RigidBody(int mass, Vector2 velocity, Collider collider) {
        this.mass = mass;
        this.velocity = velocity;
        this.collider = collider;
        collider.rigidBody = this;
    }

    public RigidBody(Collider collider) {
        this.collider = collider;
        this.mass = 1;
        this.velocity = Vector2.zero();
        collider.rigidBody = this;
    }

    public RigidBody(Vector2 velocity, Collider collider) {
        this.mass = 1;
        this.velocity = velocity;
        this.collider = collider;
        collider.rigidBody = this;
    }

    public void update() {
        collider.shape.translate(velocity);
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }
}
