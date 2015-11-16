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

    public static Vector2 velocity;

    @Override
    public void start() {
        texture = new Texture("ball.png");
        spriteBatch = new SpriteBatch();
        sprite = new Sprite(texture);

        collider = new CircleCollider(new Circle(sprite), false, new ContactListener() {});
        collider.tag = "Ball";
        rigidBody = new RigidBody(new Vector2(1, 0.3f).multiplyBy(9), collider);

        velocity = rigidBody.getVelocity();
    }

    @Override
    public void update() {
        rigidBody.update();
        velocity = rigidBody.getVelocity();
    }

    @Override
    public void draw() {
        sprite.draw(spriteBatch);
    }
}