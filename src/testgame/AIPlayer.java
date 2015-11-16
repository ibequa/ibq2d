package testgame;

import com.ibq2d.engine.core.*;
import com.ibq2d.engine.geometry.*;
import com.ibq2d.engine.physics.*;

public class AIPlayer extends GameListener{
    Texture texture;
    Sprite sprite;
    Collider collider;
    SpriteBatch spriteBatch;

    float speed = 8;
    float translation;

    @Override
    public void start() {

        texture = new Texture("aiplayer.png");
        spriteBatch = new SpriteBatch();
        sprite = new Sprite(texture);
        collider = new BoxCollider(new Rect(sprite), false, new ContactListener() {
            @Override
            public void onContactEnter(Collider collider) {
                if (collider.tag == "Ball") {
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
            float x = Ball.velocity.getX() / Ball.velocity.getY();
            sprite.setX(x);
            collider.shape.setX(x);
        }
    }

    @Override
    public void draw() {
        sprite.draw(spriteBatch);
    }
}