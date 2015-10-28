package com.ibq2d.engine;

public class Player extends GameListener {

    public void test() {
        Collider col = new BoxCollider(10, 10, Vector2.zero, false, new ContactListener() {
            @Override
            public void onContactEnter(Collider collider) {
                System.out.println("contacted");
            }
        });
    }

    @Override
    public void start() {
    }
}