import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Burak Kara
 */
public class KeyboardListener implements KeyListener{

    public boolean[] keys = new boolean[256];

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
