package com.ibq2d.engine;

public class Transform {
    public Vector2 position;
//    public Vector2 localPosition; // position relative to parent(if no parent, then relative to world)
    public Vector2 localScale;
    public Vector2 eulerAngles;   // represent rotation

    public Transform() {
        this.position = Vector2.zero;
        this.eulerAngles = Vector2.zero;
        this.localScale = Vector2.one;
    }

    public Transform(Vector2 position) {
        this.position = position;
        this.eulerAngles = Vector2.zero;
        this.localScale = Vector2.one;
    }
}