package com.ibq2d.engine;

import org.lwjgl.input.Keyboard;

import java.util.HashSet;

public final class Input {
    private Input() {}

    private static HashSet<Integer> pressedKeys = new HashSet<Integer>();
    private static HashSet<Integer> releasedKeys = new HashSet<Integer>();

    private static void updateKeyBuffer(int keyCode) {
        if (Keyboard.next()) {
            if (Keyboard.getEventKeyState())
                pressedKeys.add(Keyboard.getEventKey());
            else
                releasedKeys.add(Keyboard.getEventKey());
        }
    }

    protected static void updateBuffer() { pressedKeys.clear(); releasedKeys.clear(); }

    public static boolean getKey(int keyCode) {
        return Keyboard.isKeyDown(keyCode);
    }

    public static boolean getKeyDown(int keyCode) {
        updateKeyBuffer(keyCode);
        return pressedKeys.contains(keyCode);
    }

    public static boolean getKeyUp(int keyCode) {
        updateKeyBuffer(keyCode);
        return releasedKeys.contains(keyCode);
    }

    public static int getHorizontalAxis() {
        return getKey(Application.horizontalAxis[0]) ? -1 : (getKey(Application.horizontalAxis[1]) ? 1 : 0);
    }

    public static int getVerticalAxis() {
        return getKey(Application.verticalAxis[0]) ? -1 : (getKey(Application.verticalAxis[1]) ? 1 : 0);
    }
}