package testgame;

import com.ibq2d.engine.core.*;

public class MainScene extends Scene {

    @Override
    public void initializeScene() {
        AddToScene(new Player());
        AddToScene(new AIPlayer());
        AddToScene(new Score());
        AddToScene(new Ball());
        AddToScene(new Edges());
    }
}