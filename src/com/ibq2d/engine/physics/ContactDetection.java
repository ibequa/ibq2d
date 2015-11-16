package com.ibq2d.engine.physics;

import com.ibq2d.engine.geometry.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactDetection {

    private static ArrayList<Collider> listeners = new ArrayList<Collider>();
    private static HashMap<Collider, Collider> contactingWith = new HashMap<>();

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
        if (a.getClass() == Circle.class && b.getClass() == Circle.class)
            return Geometry.shapesOverlap((Circle) a, (Circle) b);

        else if (a.getClass() == Rect.class && b.getClass() == Circle.class)
            return Geometry.shapesOverlap((Rect) a, (Circle) b);

        else if (a.getClass() == Circle.class && b.getClass() == Rect.class)
            return Geometry.shapesOverlap((Rect) b, (Circle) a);

        else if (a.getClass() == Edge.class && b.getClass() == Circle.class)
            return Geometry.shapesOverlap((Edge) a, (Circle) b);

        else if (a.getClass() == Circle.class && b.getClass() == Edge.class)
            return Geometry.shapesOverlap((Edge) b, (Circle) a);

        else if (a.getClass() == Rect.class && b.getClass() == Edge.class)
            return Geometry.shapesOverlap((Rect) a, (Edge) b);
        else if (a.getClass() == Edge.class && b.getClass() == Rect.class)
            return Geometry.shapesOverlap((Rect) b, (Edge) a);


        else return false;
    }
}