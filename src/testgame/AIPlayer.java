package testgame;

import com.ibq2d.engine.Application;
import com.ibq2d.engine.core.*;
import com.ibq2d.engine.geometry.*;
import com.ibq2d.engine.physics.*;

public class AIPlayer extends GameListener {
    Texture texture;
    Sprite sprite;
    Collider collider;
    SpriteBatch spriteBatch;

    float speed = 8;
    float translation;

    @Override
    public void awake() {

        texture = new Texture("aiplayer.png");
        spriteBatch = new SpriteBatch();
        sprite = new Sprite(texture);
        collider = new BoxCollider(new Rect(sprite), false, new ContactListener() {
            @Override
            public void onContactEnter(Collider collider) {
                if (collider.tag.equals("Ball")) {
                    Vector2 ballVelocity = collider.rigidBody.getVelocity();
                    ballVelocity.set(ballVelocity.getX() * translation * 0.2f, -ballVelocity.getY());
                }
            }
        });
        collider.tag = "Platform";

        sprite.translateY(Application.HEIGHT / 2 - sprite.getWidth() / 2 + 40);
        collider.shape.translateY(Application.HEIGHT / 2 - sprite.getWidth() / 2 + 40);
    }

    @Override
    public void update() {
        if (Ball.velocity.getY() > 0) {
            Vector2 p0 = Ball.position;
            Vector2 p1 = Vector2.add(Ball.position, Vector2.one());

            float k = (p0.getY() - p1.getY())/(p0.getX() - p1.getX());
            float m = p1.getY() - k * p1.getX();
            float x = (sprite.getPosition().getY() - m) / k;

            sprite.setX(Math.min(x, Application.WIDTH/2));
            collider.shape.setX(Math.min(x, Application.WIDTH/2));
        }
    }

    @Override
    public void draw() {
        sprite.draw(spriteBatch);
    }
}