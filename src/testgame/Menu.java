package testgame;

import com.ibq2d.engine.core.GameListener;

import java.util.ArrayList;

public abstract class Menu extends GameListener {

    ArrayList<Button> buttons;

    public final ArrayList<Button> getMenuButtons() {
        return buttons;
    }

    public final void startEvent(int sliderState) {
        assert(sliderState < buttons.size());
        buttons.get(sliderState).onClick();
    }

    @Override
    public void destroy() {
        buttons.clear();
    }
}
