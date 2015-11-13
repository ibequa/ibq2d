package com.ibq2d.engine.physics;

import com.ibq2d.engine.geometry.Circle;
import com.ibq2d.engine.geometry.Geometry;
import com.ibq2d.engine.geometry.Rect;
import com.ibq2d.engine.geometry.Shape;

import java.util.ArrayList;

public class ContactDetection {

    private static ArrayList<Collider> listeners = new ArrayList<Collider>();

    protected static void addListener(Collider listener) {
        listeners.add(listener);
    }

    public static void checkCollisions() {
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

    private static void manageContactCallbacks(Collider a, Collider b) {
        // if a or b is trigger operate on onTrigger...
        // non of them triggers operate on onContact...
        if (a.isTrigger || b.isTrigger) {
                a.contactListener.onTriggerStay(b);
                b.contactListener.onTriggerStay(a);
            }
        else {
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
            return Geometry.shapesOverlap((Circle) a, (Rect) b);
        else return Geometry.shapesOverlap(a, b);
    }
}