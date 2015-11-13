package testgame;

import com.ibq2d.engine.core.*;
import com.ibq2d.engine.geometry.*;
import com.ibq2d.engine.physics.*;

public class Player extends GameListener {

    Texture tex;
    Sprite spriteA;
    Sprite spriteB;
    Collider colA;
    Collider colB;
    SpriteBatch spriteBatch;

    float speed = 5;

    @Override
    public void start() {
        tex = new Texture("testTexture.png");
        spriteBatch = new SpriteBatch();
        spriteA = new Sprite(tex);
        spriteB = new Sprite(tex);

        colA = new BoxCollider(new Rect(spriteA), true, new ContactListener() {
            @Override
            public void onTriggerStay(Collider collider) {
                System.out.println("contacting");
            }
        });
        colB = new BoxCollider(new Rect(spriteB), true, new ContactListener() {
        });
        spriteA.scaleXY(0.5f);
        colA.shape.scale(0.5f, 0.5f);
        spriteA.translateY(Application.HEIGHT/4 + 90);
        colA.shape.translateY(Application.HEIGHT/4 + 90);
    }

    @Override
    public void update() {
        spriteA.translate(new Vector2(Input.getHorizontalAxis() * speed, Input.getVerticalAxis() * speed));
        colA.shape.translate(new Vector2(Input.getHorizontalAxis() * speed, Input.getVerticalAxis() * speed));
   }

    @Override
    public void draw() {
        spriteA.draw(spriteBatch);
        spriteB.draw(spriteBatch);
    }
}