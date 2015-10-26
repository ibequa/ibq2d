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
        while (Keyboard.next()) {
            if (Keyboard.getEventKey() == keyCode) {
                if (Keyboard.getEventKeyState())
                    pressedKeys.add(keyCode);
                else
                    releasedKeys.add(keyCode);
            }
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