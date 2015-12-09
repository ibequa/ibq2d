package testgame;

import com.ibq2d.engine.geometry.*;
import com.ibq2d.engine.ui.Text;

public class BtSoundManager extends Button {

    Text text;

    boolean state = true;

    @Override
    public void awake() {
        text = new Text("Sound on", 20);
        text.setPosition(new Vector2(-8, 12));
    }

    @Override
    public void draw() {
        text.draw();
    }

    @Override
    public void onClick() {
        state = !state;
        if (state) {
            text.setText("Sound on");
            AudioSource.instance.resume();
        }
        else {
            text.setText("Sound off");
            AudioSource.instance.stop();
        }
    }
}