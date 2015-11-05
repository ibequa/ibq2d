package com.ibq2d.engine;

public class Player extends GameListener {

    Texture tex;
    Sprite sprite;
    SpriteBatch spriteBatch;

    @Override
    public void start() {
        tex = new Texture("testTexture.png");
        spriteBatch = new SpriteBatch();
        sprite = new Sprite(tex);
   }

    @Override
    public void update() {
    }

    @Override
    public void draw() {
        sprite.draw(spriteBatch);
    }
}