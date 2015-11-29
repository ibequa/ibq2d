package testgame;

import com.ibq2d.engine.core.GameListener;
import com.ibq2d.engine.core.SpriteBatch;
import com.ibq2d.engine.core.Texture;

public class someGameLis extends GameListener {
    Texture tex;
    SpriteBatch sb;

    @Override
    public void awake() {
        tex = new Texture("player.png");
        sb = new SpriteBatch();
    }

    @Override
    public void draw() {
        sb.draw(tex, 0, 0);
    }
}
