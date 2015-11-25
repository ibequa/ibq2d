package com.ibq2d.engine.core;

import com.ibq2d.engine.Application;
import com.ibq2d.engine.geometry.Vector2;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.util.HashSet;

public final class Input {
    private Input() {}

    private static HashSet<Integer> pressedKeys = new HashSet<>();
    private static HashSet<Integer> releasedKeys = new HashSet<>();

    private static HashSet<Integer> pressedMouseBt = new HashSet<>();
    private static HashSet<Integer> releasedMouseBt = new HashSet<>();

    private static void updateKeyBuffer(int keyCode) {
        if (Keyboard.next()) {
            if (Keyboard.getEventKeyState())
                pressedKeys.add(Keyboard.getEventKey());
            else
                releasedKeys.add(Keyboard.getEventKey());
        }
    }

    private static void updateMouseBuffer(int mouseButton) {
        if (Mouse.next()) {
            if (Mouse.getEventButtonState())
                pressedMouseBt.add(Mouse.getEventButton());
            else
                releasedMouseBt.add(Mouse.getEventButton());

        }
    }

    protected static void updateBuffer() { pressedKeys.clear(); releasedKeys.clear(); releasedMouseBt.clear(); pressedMouseBt.clear(); }

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

    public static boolean getMouseButton(int mouseButton) {
        return (Mouse.isButtonDown(mouseButton));
    }

    public static boolean getMouseButtonDown(int mouseButton) {
        updateMouseBuffer(mouseButton);
        return pressedMouseBt.contains(mouseButton);
    }

    public static boolean getMouseButtonUp(int mouseButton) {
        updateMouseBuffer(mouseButton);
        return releasedMouseBt.contains(mouseButton);
    }

    public static Vector2 getMousePosition() {
        float x = Mouse.getX() - Application.HALF_WIDTH;
        float y = Mouse.getY() - Application.HALF_HEIGHT;

        return new Vector2(x,y);
    }

    public static float getMousePositionX() {
        return Mouse.getX() - Application.HALF_WIDTH;
    }

    public static float getMousePositionY() {
        return Mouse.getY() - Application.HALF_HEIGHT;
    }
}