package testgame;

import com.ibq2d.engine.core.*;
import org.lwjgl.input.Keyboard;

public class StartScreen extends Scene {

    Text text;

    @Override
    public void initializeScene() {
        gameListeners.add(this);
    }

    @Override
    public void awake() {
        text = new Text("Press ESC to start", "Pacifico", 20f);
    }

    @Override
    public void update() {
        if (Input.getKeyDown(Keyboard.KEY_ESCAPE))
            Application.load(1);
    }

    @Override
    public void start() {
    }

    @Override
    public void draw() {
        text.draw();
    }

    @Override
    public void destroy() {
        gameListeners.clear();
    }
}
