package testgame;

import com.ibq2d.engine.core.*;

import java.util.ArrayList;

public class MainScene extends Scene {

    @Override
    public void initializeScene() {
        name = "MainScene";

        gameListeners = new ArrayList<IGameListener>();

        gameListeners.add(new Player());
        gameListeners.add(new AIPlayer());
        gameListeners.add(new Score());
        gameListeners.add(new Ball());
        gameListeners.add(new Edges());
    }
}
