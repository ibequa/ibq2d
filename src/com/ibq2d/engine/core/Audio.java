package com.ibq2d.engine.core;

import com.ibq2d.engine.Application;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;

public class Audio {

    org.newdawn.slick.openal.Audio audio;
    private float pitch, gain;
    private boolean loop;

    public enum PlayMode {
        PLAY_AS_MUSIC,
        PLAY_AS_SOUNDEFFECT
    }

    private PlayMode playMode;

    public Audio(String name, boolean loop, PlayMode playMode) {
        String ext = name.substring(name.lastIndexOf(".") + 1).toUpperCase();
        try {
            audio = AudioLoader.getAudio(ext, ResourceLoader.getResourceAsStream(Application.PATH_TO_AUDIOS + name));
            pitch = gain = 1;
            this.loop = loop;
            this.playMode = playMode;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Audio(String name, float pitch, float gain, boolean loop, PlayMode playMode) {
        String ext = name.substring(name.lastIndexOf(".") + 1).toUpperCase();
        try {
            audio = AudioLoader.getAudio(ext, ResourceLoader.getResourceAsStream(Application.PATH_TO_AUDIOS + name));
            this.pitch = pitch;
            this.gain = gain;
            this.loop = loop;
            this.playMode = playMode;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        switch(playMode) {
            case PLAY_AS_MUSIC:
                audio.playAsMusic(pitch, gain, loop);
                break;
            case PLAY_AS_SOUNDEFFECT:
                audio.playAsSoundEffect(pitch, gain, loop);
                break;
            default:
                System.exit(-1);
        }
    }

    public void stop() { audio.stop(); }

    public boolean isPlaying() { return audio.isPlaying(); }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public void setGain(float gain) {
        this.gain = gain;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
