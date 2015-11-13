package com.ibq2d.engine.physics;

public abstract class ContactListener implements IContactListener{
    public boolean contactEntered = false;

    @Override
    public void onContactEnter(Collider collider) {

    }

    @Override
    public void onContactExit(Collider collider) {

    }

    @Override
    public void onTriggerEnter(Collider collider) {

    }

    @Override
    public void onTriggerExit(Collider collider) {

    }

    @Override
    public void onTriggerStay(Collider collider) {

    }
}
