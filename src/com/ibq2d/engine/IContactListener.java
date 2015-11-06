package com.ibq2d.engine;

public interface IContactListener {
    void onContactEnter(Collider collider);
    void onContactExit(Collider collider);
    void onTriggerEnter(Collider collider);
    void onTriggerExit(Collider collider);
    void onTriggerStay(Collider collider);
}
