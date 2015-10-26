package com.ibq2d.engine;

import java.util.ArrayList;

public class ContactDetection {

    private static ArrayList<Collider> listeners = new ArrayList<Collider>();

    public static void addListener(Collider listener) {
        listeners.add(listener);
    }

    public void checkCollisions() {
        for(int i = 0; i < listeners.size(); i++) {
            Collider x = listeners.get(i);
            for (int j = 0; j < listeners.size(); j++) {
                if (i == j)
                    continue;
                if (overlap(x, listeners.get(j)))
                        manageContactCallbacks(x, listeners.get(j));
            }
        }
    }

    private void manageContactCallbacks(Collider a, Collider b) {
        // if a or b is trigger operate on onTrigger...
        // non of them triggers operate on onContact...
        if (a.isTrigger || b.isTrigger) {
            if (overlap(a, b)) {
                a.contactListener.onTriggerStay(b);
                b.contactListener.onTriggerStay(a);
                if (!a.contactListener.contactEntered) {
                    return;
                }
            }
        }
    }

    private boolean overlap(Collider a, Collider b) {
        if (a.enabled && b.enabled) {
            if (shapesOverlap(a.shape, b.shape))
                return true;
        }
        return false;
    }

    private boolean shapesOverlap(Shape a, Shape b) {
        return false;
    }

    private boolean primitiveOverlap(Circle a, Circle b) {
        return false;
    }
    private boolean primitiveOverlap(Box a, Box b) {
        return false;
    }
    private boolean primitiveOverlap(Box a, Circle b) {
        return false;
    }

}