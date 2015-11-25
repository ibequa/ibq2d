package com.ibq2d.engine.physics;

import com.ibq2d.engine.geometry.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactDetection {

    public static ArrayList<Collider> listeners = new ArrayList<Collider>();
    public static HashMap<Collider, Collider> contactingWith = new HashMap<>();

    protected static void addListener(Collider listener) {
        listeners.add(listener);
    }

    public static void checkCollisions() {
        for(int i = 0; i < listeners.size(); i++) {
            Collider x = listeners.get(i);
            for (int j = 0; j < listeners.size(); j++) {
                if (i == j)
                    continue;
                Collider y = listeners.get(j);
                if (x.enabled && y.enabled) {
                  if (overlap(x, y))
                      manageContactCallbacks(x, y);
                  else if (contactingWith.get(x) == y) {
                      contactingWith.remove(x);
                      if (x.isTrigger || y.isTrigger)
                          x.contactListener.onTriggerExit(y);
                      else x.contactListener.onContactExit(y);
                  }
                }
            }
        }
    }

    private static void manageContactCallbacks(Collider a, Collider b) {
        if (a.isTrigger || b.isTrigger) {
            a.contactListener.onTriggerStay(b);
            if (!(contactingWith.get(a) == b)) {
                contactingWith.put(a, b);
                a.contactListener.onTriggerEnter(b);
            }
        }
        else {
            a.contactListener.onContactStay(b);
            if (!(contactingWith.get(a) == b)) {
                contactingWith.put(a, b);
                a.contactListener.onContactEnter(b);
            }
        }
    }

    private static boolean overlap(Collider a, Collider b) {
        if (a.enabled && b.enabled) {
            if (shapesOverlapHandler(a.shape, b.shape))
                return true;
        }
        return false;
    }

    private static boolean shapesOverlapHandler(Shape a, Shape b) {
        if (b.getClass() == Circle.class)
            return a.intersectsWith((Circle) b);

        else if (b.getClass() == Rect.class)
            return a.intersectsWith((Rect) b);

        else if (b.getClass() == Edge.class)
            return a.intersectsWith((Edge) b);

        else if (b.getClass() == Polygon.class)
            return a.intersectsWith((Polygon) b);
        else return false;
    }
}