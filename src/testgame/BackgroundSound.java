package testgame;

import com.ibq2d.engine.core.*;

public class BackgroundSound extends GameListener {

    Audio backgroundSound;

    @Override
    public void awake() {
        backgroundSound = new Audio("background.wav", true, Audio.PlayMode.PLAY_AS_MUSIC);
        AudioSource.instance.addAudio(backgroundSound);
        AudioSource.instance.play(backgroundSound);
    }
}
