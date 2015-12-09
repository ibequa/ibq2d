package testgame;

import com.ibq2d.engine.core.*;

public class StartScreen extends Scene {

    @Override
    public void initializeScene() {
        StartMenu startMenu = new StartMenu();

        AddToScene(new Slider(startMenu));
        AddToScene(startMenu);
        AddToScenePersistent(AudioSource.instance = new AudioSource());
        AddToScenePersistent(new BackgroundSound());
    }
}