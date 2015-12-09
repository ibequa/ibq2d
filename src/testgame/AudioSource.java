package testgame;

import com.ibq2d.engine.core.Audio;
import com.ibq2d.engine.core.GameListener;

import java.util.ArrayList;

public class AudioSource extends GameListener {

    public boolean enabled = true;
    public ArrayList<Audio> audios = new ArrayList<>();

    public static AudioSource instance = null;


    public void addAudio(Audio audio) {
        audios.add(audio);
    }

    public void stop() {
        enabled = false;
        for (Audio audio : audios)
            audio.stop();
    }

    public void resume() {
        enabled = true;
        for (Audio audio : audios)
            audio.play();
    }

    public void play(Audio audio) {
        if (enabled)
            audio.play();
    }
}
