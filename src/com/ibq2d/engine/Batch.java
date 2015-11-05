package com.ibq2d.engine;

public interface Batch {
    void draw(Texture texture, float x, float y); // x, y - bottom left coord. of drawn rect
    void draw(Texture texture, float x, float y, float scaleX, float scaleY, float rotation);
}
