package testgame;

import com.ibq2d.engine.core.*;
import org.newdawn.slick.opengl.TextureImpl;

import static org.lwjgl.opengl.GL11.*;

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