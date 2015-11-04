package com.ibq2d.engine;

import java.util.ArrayList;
import java.util.List;

public class Quadtree {
    private final int MAX_OBJECTS = 1;
    private final int MAX_LEVEL = 7;

    private int level;
    private List<Shape> objects;
    private Rect bounds;
    private Quadtree[] nodes;

    public Quadtree(int level, Rect bounds) {
        this.level = level;
        this.bounds = bounds;
        this.nodes = new Quadtree[4];
        this.objects = new ArrayList<Shape>();
    }

    public void clearTree() {
        objects.clear();
        for (int i = 0; i < nodes.length; i++) {
            nodes[i].clearTree();
            nodes[i] = null;
        }
    }

    private void split() {
        float subWidth = (bounds.getWidth() / 2);
        float subHeight = (bounds.getHeight() / 2);
        float halfSubHeight = subHeight / 2;
        float halfSubWidth = subWidth / 2;
        float x = bounds.getPosition().getX();
        float y = bounds.getPosition().getY();
        nodes[0] = new Quadtree(level + 1, new Rect(subWidth, subHeight, new Vector2(x - halfSubWidth, y - halfSubHeight)));
        nodes[1] = new Quadtree(level + 1, new Rect(subWidth, subHeight, new Vector2(x + halfSubWidth, y - halfSubHeight)));
        nodes[2] = new Quadtree(level + 1, new Rect(subWidth, subHeight, new Vector2(x - halfSubWidth, y + halfSubHeight)));
        nodes[3] = new Quadtree(level + 1, new Rect(subWidth, subHeight, new Vector2(x + halfSubWidth, y + halfSubHeight)));
    }

    public void insert(Shape shape) {
        if (nodes[0] != null) {
            if (Geometry.isShapeInRect(shape, nodes[0].bounds))
                nodes[0].insert(shape);
            if (Geometry.isShapeInRect(shape, nodes[1].bounds))
                nodes[1].insert(shape);
            if (Geometry.isShapeInRect(shape, nodes[2].bounds))
                nodes[2].insert(shape);
            if (Geometry.isShapeInRect(shape, nodes[3].bounds))
                nodes[3].insert(shape);
            return;
        }
        objects.add(shape);
        if (objects.size() > MAX_OBJECTS && level < MAX_LEVEL) {
            if (nodes[0] == null)
                split();

            for (Shape obj : objects)
                insert(obj);
            objects.clear();
        }
    }

    public void collisionList(Shape shape) {
        if (nodes[0] != null) {
            if (Geometry.isShapeInRect(shape, nodes[0].bounds))
                nodes[0].collisionList(shape);
            if (Geometry.isShapeInRect(shape, nodes[1].bounds))
                nodes[1].collisionList(shape);
            if (Geometry.isShapeInRect(shape, nodes[2].bounds))
                nodes[2].collisionList(shape);
            if (Geometry.isShapeInRect(shape, nodes[3].bounds))
                nodes[3].collisionList(shape);
        }
    }
}
