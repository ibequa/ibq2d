package testgame;

import com.ibq2d.engine.geometry.*;
import com.ibq2d.engine.core.*;
import org.lwjgl.input.Keyboard;

public class Slider extends GameListener {

    Menu menu;
    Sprite sprite;
    SpriteBatch spriteBatch;

    private float moveCoef = 25;
    private int sliderState;

    public Slider(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void awake() {
        spriteBatch = new SpriteBatch();
        sprite = new Sprite(new Texture("slider.png"));

        sprite.scaleXY(0.3f);
        sprite.rotate(-90);
        sprite.setPosition(new Vector2(-60, 40));
    }

    @Override
    public void update() {
        if (Input.getKeyDown(Keyboard.KEY_SPACE))
            menu.startEvent(sliderState);

        if (Input.getKeyDown(Keyboard.KEY_S) && sliderState + 1 < menu.getMenuButtons().size()) {
            sliderState++;
            sprite.setY(sprite.getPosition().getY() - moveCoef);
        }

        if (Input.getKeyDown(Keyboard.KEY_W) && sliderState > 0) {
            sliderState--;
            sprite.setY(sprite.getPosition().getY() + moveCoef);
        }
    }

    @Override
    public void draw() {
        sprite.draw(spriteBatch);
    }
}