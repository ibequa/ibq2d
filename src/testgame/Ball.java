package testgame;

import com.ibq2d.engine.core.*;
import com.ibq2d.engine.geometry.*;
import com.ibq2d.engine.physics.*;

public class Ball extends GameListener {

    Texture texture;
    Sprite sprite;
    Collider collider;
    RigidBody rigidBody;
    SpriteBatch spriteBatch;

    @Override
    public void start() {
        texture = new Texture("ball.png");
        spriteBatch = new SpriteBatch();
        sprite = new Sprite(texture);

        collider = new CircleCollider(new Circle(sprite), true, new ContactListener() {});
        collider.tag = "Ball";
        rigidBody = new RigidBody(new Vector2(1, -0.4f).multiplyBy(9), collider);
    }

    @Override
    public void update() {
        rigidBody.update();
    }

    @Override
    public void draw() {
        sprite.draw(spriteBatch);
    }
}