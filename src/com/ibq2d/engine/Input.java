package com.ibq2d.engine;

import org.lwjgl.input.Keyboard;

import java.util.HashSet;

public final class Input {
    private Input() {}

    private static HashSet<Integer> pressedKeys = new HashSet<Integer>();
    private static HashSet<Integer> releasedKeys = new HashSet<Integer>();

    public static boolean getKey(int keyCode) {
        return Keyboard.isKeyDown(keyCode);
    }

    private static void updateKeyBuffer(int keyCode) {
        if (Keyboard.next()) {
            if (Keyboard.getEventKeyState())
                pressedKeys.add(Keyboard.getEventKey());
            else
                releasedKeys.add(Keyboard.getEventKey());
        }
    }

    public static void updateBuffer() { pressedKeys.clear(); releasedKeys.clear(); }

    public static boolean getKeyDown(int keyCode) {
        updateKeyBuffer(keyCode);
        return pressedKeys.contains(keyCode);
    }

    public static boolean getKeyUp(int keyCode) {
        updateKeyBuffer(keyCode);
        return releasedKeys.contains(keyCode);
    }
}