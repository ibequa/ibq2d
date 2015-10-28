package com.ibq2d.engine;

public final class GameListenersList {
    private GameListenersList() {
    }

    public static IGameListener gameListeners[] = new IGameListener[] { new Player() };
}
