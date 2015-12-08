package testgame;

import com.ibq2d.engine.core.*;

public class StartScreen extends Scene {

    @Override
    public void initializeScene() {
        AddToScene(new Slider());
        AddToScene(new Menu());
        AddToScenePersistent(new BackgroundSound());
    }
}