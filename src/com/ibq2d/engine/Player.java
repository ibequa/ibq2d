package com.ibq2d.engine;

public class Player extends ContactListener {

    @Override
    public void onContactEnter(Collider collider) {
        System.out.println("player contacted with smth");
    }
}
