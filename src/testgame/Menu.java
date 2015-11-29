package testgame;

import com.ibq2d.engine.core.*;
import com.ibq2d.engine.ui.Text;
import org.lwjgl.input.Keyboard;

public class Menu extends GameListener {

    Text text;

    @Override
    public void awake() {
        text = new Text("Press ESC to start", "Pacifico.ttf", 20f);
    }

    @Override
    public void update() {
        if (Input.getKeyDown(Keyboard.KEY_ESCAPE))
            SceneManager.load(1);
    }

    @Override
    public void draw() {
        text.draw();
    }
}
