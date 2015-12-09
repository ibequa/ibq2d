package testgame;

import java.util.ArrayList;

public class StartMenu extends Menu {

    @Override
    public void awake() {

        buttons = new ArrayList<>();

        buttons.add(new BtOnePlayer());
        buttons.add(new BtTwoPlayers());
        buttons.add(new BtSoundManager());

        for (Button bt : buttons)
            bt.awake();
    }

    @Override
    public void draw() {
        for (Button bt : buttons)
            bt.draw();
    }
}