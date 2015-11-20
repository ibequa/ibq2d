package testgame;

import com.ibq2d.engine.core.*;

public class Score extends GameListener{

    Text score;

    @Override
    public void start() {
        score = new Text("score!", "Pacifico", 24f);
    }

    @Override
    public void update() {
    }

    @Override
    public void draw() {
        score.draw();
    }
}