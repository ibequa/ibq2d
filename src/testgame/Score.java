package testgame;

import com.ibq2d.engine.core.*;

public class Score extends GameListener{

    Text score;

    @Override
    public void awake() {
        score = new Text("score", "Pacifico", 24f);
    }

    @Override
    public void draw() {
        score.draw();
    }
}