package testgame;

import com.ibq2d.engine.core.*;
import com.ibq2d.engine.geometry.*;
import com.ibq2d.engine.ui.Text;

public class BtOnePlayer extends Button {
    Text text;

    @Override
    public void awake() {
        text = new Text("One player", 20);
        text.setPosition(new Vector2(-3, -38));
    }

    @Override
    public void onClick() {
        SceneManager.load("MainScene");
    }

    @Override
    public void draw() {
        text.draw();
    }
}
