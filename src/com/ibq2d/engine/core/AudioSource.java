package com.ibq2d.engine.core;

import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;

public class AudioSource {

    private Audio audio;

    private float pitch, gain;
    private boolean loop;

    public AudioSource(String name, float pitch, float gain, boolean loop) {
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

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public float getGain() {
        return gain;
    }

    public void setGain(float gain) {
        this.gain = gain;
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public void playAsMusic() {
        audio.playAsMusic(pitch, gain, loop);
    }

    public void playAsSoundEffect() {
        audio.playAsSoundEffect(pitch, gain, loop);
    }
}
