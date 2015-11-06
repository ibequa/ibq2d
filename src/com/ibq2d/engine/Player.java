package com.ibq2d.engine;

public class Player extends GameListener {

    Texture tex;
    Sprite sprite;
    SpriteBatch spriteBatch;

    float speed = 5;

    @Override
    public void start() {
        tex = new Texture("testTexture.png");
        spriteBatch = new SpriteBatch();
        sprite = new Sprite(tex);
        sprite.scaleXY(0.5f);
    }

    @Override
    public void update() {
        sprite.translate(new Vector2(Input.getHorizontalAxis() * speed, Input.getVerticalAxis() * speed));
   }

    @Override
    public void draw() {
        sprite.draw(spriteBatch);
    }
}