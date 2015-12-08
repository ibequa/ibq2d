package testgame;

import com.ibq2d.engine.core.*;

public class BackgroundSound extends GameListener {

    public static com.ibq2d.engine.core.Audio backgroundSound;

    @Override
    public void awake() {
        backgroundSound = new Audio("background.wav", true);
        backgroundSound.playAsMusic();
    }
}