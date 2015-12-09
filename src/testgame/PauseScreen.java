package testgame;

import com.ibq2d.engine.core.Scene;

public class PauseScreen extends Scene {

    @Override
    public void initializeScene() {
        PauseMenu pauseMenu = new PauseMenu();

        AddToScene(new Slider(pauseMenu));
        AddToScene(pauseMenu);
    }
}
