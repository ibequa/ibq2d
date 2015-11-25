package testgame;

import com.ibq2d.engine.Application;
import com.ibq2d.engine.core.GameListener;
import com.ibq2d.engine.core.Input;
import com.ibq2d.engine.core.SceneManager;
import com.ibq2d.engine.core.Text;
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
