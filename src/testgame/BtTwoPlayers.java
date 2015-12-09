package testgame;

import com.ibq2d.engine.geometry.Vector2;
import com.ibq2d.engine.ui.Text;

public class BtTwoPlayers extends Button {
    Text text;

    @Override
    public void awake() {
        text = new Text("Two players", 20);
        text.setPosition(new Vector2(1, -13));
    }

    @Override
    public void onClick() {
    }

    @Override
    public void draw() {
        text.draw();
    }
}
