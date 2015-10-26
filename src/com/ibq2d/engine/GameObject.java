package com.ibq2d.engine;

public class GameObject {
    public final Transform transform;
    public Texture texture;
    public Collider collider;

    public GameObject() {
        transform = new Transform();
    }

    public GameObject(Transform transform) {
        this.transform = transform;
    }
}