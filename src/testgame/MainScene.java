package testgame;

import com.ibq2d.engine.core.*;

public class MainScene extends Scene {

    @Override
    public void initializeScene() {
        gameListeners.add(new Player());
        gameListeners.add(new AIPlayer());
        gameListeners.add(new Score());
        gameListeners.add(new Ball());
        gameListeners.add(new Edges());
    }
}