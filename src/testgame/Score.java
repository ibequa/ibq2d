package testgame;

import com.ibq2d.engine.core.*;
import com.ibq2d.engine.ui.Text;

public class Score extends GameListener{

    Text scoreText;
    public static int score;

    @Override
    public void awake() {
        scoreText = new Text("score: " + score, "Pacifico.ttf", 24f);
    }

    @Override
    public void draw() {
        scoreText.draw();
    }
}