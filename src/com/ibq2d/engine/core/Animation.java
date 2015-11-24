package com.ibq2d.engine.core;

public class Animation {

    private Texture[] statesTexture;
    private boolean loop;
    private float stateTime;

    private int currentState;
    private float currentTime;

    public Animation(Texture[] statesTexture, float stateTime, boolean loop) {
        this.statesTexture = statesTexture;
        this.stateTime = stateTime;
        this.loop = loop;
    }

    public Texture getKeyFrame(float time) {
        int index = (int) (time / stateTime);
        return (index > statesTexture.length && !loop) ? null : statesTexture[index % statesTexture.length];
    }
}