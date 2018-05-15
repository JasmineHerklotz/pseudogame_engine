import javax.swing.*;

/**
 * @author Burak Kara
 */
public class Shot extends Sprite {
    public Shot(int x, int y) {
        super(x, y);
        this.setIi(new ImageIcon(this.getClass().getResource("shot.png")));
    }



}
