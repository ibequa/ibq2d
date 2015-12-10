package testgame;

import com.ibq2d.engine.geometry.*;
import com.ibq2d.engine.ui.Text;

public class BtSoundManager extends Button {

    Text text;

    @Override
    public void awake() {
        text = new Text("", 20);
        if (AudioSource.instance.enabled)
            text.setText("Sound on");
        else text.setText("Sound off");

        text.setPosition(new Vector2(-8, 12));
    }

    @Override
    public void draw() {
        text.draw();
    }

    @Override
    public void onClick() {
        boolean state = !AudioSource.instance.enabled;
        AudioSource.instance.enabled = state;
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