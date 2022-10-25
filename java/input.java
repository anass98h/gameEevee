package src.main.java;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**https://www.youtube.com/watch?v=BJ7fr9XwS2o for future refrence video explain
 *
 */

public class input implements KeyListener {

    private static boolean[] keys;

    private static int delay;

    public input() {
        keys = new boolean[100]; //TODO - Right lenght?
        delay = 96;
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        keys[arg0.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        keys[arg0.getKeyCode()] = false;
    }

    /**Checks if given key is being pressed on the keyboard*/
    public static boolean isKeyDown(int key) {
        if(keys[key] && delay <= 0) {
            delay = 96;
            return true;
        }
        else {
            delay--;
            return false;
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {}


}
