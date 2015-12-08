package testgame;

import com.ibq2d.engine.core.*;
import com.ibq2d.engine.geometry.Vector2;
import com.ibq2d.engine.ui.Text;

import java.util.ArrayList;

public class Menu extends GameListener {

    private ArrayList<Button> buttons = new ArrayList<Button>();

    class BtOnePlayer extends Button {
        Text text;

        @Override
        public void awake() {
            text = new Text("One player", 20);
            text.setPosition(new Vector2(-3, -38));
        }

        @Override
        public void onClick() {
            SceneManager.load("MainScene");
        }

        @Override
        public void draw() {
            text.draw();
        }
    }

    class BtTwoPlayers extends Button {
        Text text;

        @Override
        public void awake() {
            text = new Text("Two players", 20);
            text.setPosition(new Vector2(1, -13));
        }

        @Override
        public void onClick() {
        }

        @Override
        public void draw() {
            text.draw();
        }
    }

    class BtSoundManager extends Button {

        Text text;

        boolean state = true;

        @Override
        public void awake() {
            text = new Text("Sound on", 20);
            text.setPosition(new Vector2(-8, 12));
       }

        @Override
        public void draw() {
            text.draw();
        }

        @Override
        public void onClick() {
            state = !state;
            if (state) {
                text.setText("Sound on");
                BackgroundSound.backgroundSound.playAsMusic();
            }
            else {
                text.setText("Sound off");
                BackgroundSound.backgroundSound.stop();
            }
        }
    }

    public ArrayList<Button> getMenuButtons() {
        return buttons;
    }

    public void startEvent(int sliderState) {
        assert(sliderState < buttons.size());
        buttons.get(sliderState).onClick();
    }

    @Override
    public void awake() {
        buttons.add(new BtOnePlayer());
        buttons.add(new BtTwoPlayers());
        buttons.add(new BtSoundManager());

        for (Button bt : buttons)
            bt.awake();
    }

    @Override
    public void update() {
        for (Button bt : buttons)
            bt.update();
    }

    @Override
    public void draw() {
        for (Button bt : buttons)
            bt.draw();
    }
}