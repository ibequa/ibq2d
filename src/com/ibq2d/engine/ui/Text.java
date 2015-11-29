package com.ibq2d.engine.ui;

import com.ibq2d.engine.geometry.Vector2;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;
import org.newdawn.slick.Color;

import java.awt.Font;
import java.io.InputStream;

public class Text {

    private String text;
    public TrueTypeFont font;
    private Color color;

    private Vector2 position;

    public Text(String text, int size) {
        this.text = text;

        Font awtFont = new Font("Times New Roman", Font.BOLD, size);
        font = new TrueTypeFont(awtFont, true);

        position = Vector2.zero();
        color = Color.white;
    }

    public Text(String text, int style, int size) {
        this.text = text;
        Font awtFont = new Font("Times New Roman", style, size);
        font = new TrueTypeFont(awtFont, true);

        position = Vector2.zero();
        color = Color.white;
    }

    public Text(String text, String fontFile, float size) {
        this.text = text;

        try {
            InputStream inputStream = ResourceLoader.getResourceAsStream("./res/fonts/" + fontFile);

            Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            awtFont = awtFont.deriveFont(size);

            font = new TrueTypeFont(awtFont, true);

        } catch (Exception e) {
            e.printStackTrace();
        }

        position = Vector2.zero();
        color = Color.white;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getWidth() {
        return font.getWidth(text);
    }
    public float getHeight() {
        return font.getHeight(text);
    }

    public void draw(Vector2 position) {
        font.drawString(position.getX() - font.getWidth(text)/2, position.getY() - getHeight()/2, text, Color.white);
    }

    public void draw(Vector2 position, Color color) {
        font.drawString(position.getX() - font.getWidth(text)/2, position.getY(), text, color);
    }

    public void draw() {
        font.drawString(position.getX() - font.getWidth(text)/2, position.getY() - getHeight()/2, text, color);
    }
}
