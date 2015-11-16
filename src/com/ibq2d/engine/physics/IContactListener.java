package com.ibq2d.engine.physics;

public interface IContactListener {
    void onContactEnter(Collider collider);
    void onContactExit(Collider collider);
    void onTriggerEnter(Collider collider);
    void onTriggerExit(Collider collider);
    void onTriggerStay(Collider collider);
    void onContactStay(Collider collider);
}
