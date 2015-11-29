package com.ibq2d.engine.core;

import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;

public class Audio {

    org.newdawn.slick.openal.Audio audio;
    private float pitch, gain;
    private boolean loop;

    public Audio(String name, boolean loop) {
        String ext = name.substring(name.lastIndexOf(".") + 1).toUpperCase();
        try {
            audio = AudioLoader.getAudio(ext, ResourceLoader.getResourceAsStream("./res/audio/" + name));
            pitch = gain = 1;
            this.loop = loop;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Audio(String name, float pitch, float gain, boolean loop) {
        String ext = name.substring(name.lastIndexOf(".") + 1).toUpperCase();
        try {
            audio = AudioLoader.getAudio(ext, ResourceLoader.getResourceAsStream("./res/audio/" + name));
            this.pitch = pitch;
            this.gain = gain;
            this.loop = loop;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playAsMusic() {
        audio.playAsMusic(pitch, gain, loop);
    }

    public void playAsSoundEffect() {
        audio.playAsSoundEffect(pitch, gain, loop);
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
