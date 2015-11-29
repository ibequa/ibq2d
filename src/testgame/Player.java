package testgame;

import com.ibq2d.engine.Application;
import com.ibq2d.engine.core.*;
import com.ibq2d.engine.geometry.*;
import com.ibq2d.engine.physics.*;
import org.lwjgl.input.Keyboard;

public class Player extends GameListener {

    Texture texture;
    Sprite sprite;
    Collider collider;
    SpriteBatch spriteBatch;

    float speed = 8;
    float translation;

    Audio backgroundSound;

    @Override
    public void awake() {

        texture = new Texture("player.png");
        spriteBatch = new SpriteBatch();
        sprite = new Sprite(texture);
        collider = new BoxCollider(new Rect(sprite), false, new ContactListener() {
            @Override
            public void onContactEnter(Collider collider) {
                if (collider.tag == "Ball") {
                    Vector2 ballVelocity = collider.rigidBody.getVelocity();
                    float coef = translation * 0.8f;
                    if (coef == 0) coef = 1;
                    ballVelocity.set(ballVelocity.getX() + coef, -ballVelocity.getY() * Math.abs(coef) * 0.5f);
                }
            }
        });
        collider.tag = "Platform";

        sprite.translateY(-Application.HEIGHT / 2 + sprite.getWidth() / 2 - 40);
        collider.shape.translateY(-Application.HEIGHT / 2 + sprite.getWidth() / 2 - 40);

        backgroundSound = new Audio("background.wav", 0.25f, 1, true);
        backgroundSound.playAsMusic();
    }

    @Override
    public void update() {
        translation = Input.getHorizontalAxis() * speed;
        sprite.translateX(translation);
        collider.shape.translateX(translation);

        sprite.setX(Mathq.clamp(sprite.getPosition().getX(), -Application.WIDTH / 2 + sprite.getWidth() / 2, Application.WIDTH / 2 - sprite.getWidth() / 2));
        collider.shape.setX(Mathq.clamp(sprite.getPosition().getX(), -Application.WIDTH / 2 + sprite.getWidth() / 2, Application.WIDTH / 2 - sprite.getWidth() / 2));

        if (Input.getKeyDown(Keyboard.KEY_R))
            SceneManager.loadAdditive(SceneManager.getSceneIndex("AdditiveScene"));
        if (Input.getKeyDown(Keyboard.KEY_T))
            SceneManager.unloadAdditive(SceneManager.getSceneIndex("AdditiveScene"));
    }

    @Override
    public void draw() {
        sprite.draw(spriteBatch);
    }
}