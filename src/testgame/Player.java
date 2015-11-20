package testgame;

import com.ibq2d.engine.core.*;
import com.ibq2d.engine.geometry.*;
import com.ibq2d.engine.physics.*;

public class Player extends GameListener {

    Texture texture;
    Sprite sprite;
    Collider collider;
    SpriteBatch spriteBatch;

    float speed = 8;
    float translation;

    @Override
    public void start() {

        texture = new Texture("player.png");
        spriteBatch = new SpriteBatch();
        sprite = new Sprite(texture);
        collider = new BoxCollider(new Rect(sprite), false, new ContactListener() {
            @Override
            public void onContactEnter(Collider collider) {
                Vector2 ballVelocity = collider.rigidBody.getVelocity();
                float coef = translation * 0.8f;
                if (coef == 0) coef = 1;
                ballVelocity.set(ballVelocity.getX()+coef, -ballVelocity.getY()*Math.abs(coef)*0.5f);
            }
        });
        collider.tag = "Platform";

        sprite.translateY(-Application.HEIGHT / 2 + sprite.getWidth() / 2 - 40);
        collider.shape.translateY(-Application.HEIGHT / 2 + sprite.getWidth() / 2 - 40);
    }

    @Override
    public void update() {
        translation = Input.getHorizontalAxis() * speed;
        sprite.translateX(translation);
        collider.shape.translateX(translation);

        sprite.setX(Mathq.clamp(sprite.getPosition().getX(), -Application.WIDTH / 2 + sprite.getWidth() / 2, Application.WIDTH / 2 - sprite.getWidth() / 2));
        collider.shape.setX(Mathq.clamp(sprite.getPosition().getX(), -Application.WIDTH / 2 + sprite.getWidth() / 2, Application.WIDTH / 2 - sprite.getWidth() / 2));
    }

    @Override
    public void draw() {
        sprite.draw(spriteBatch);
    }
}