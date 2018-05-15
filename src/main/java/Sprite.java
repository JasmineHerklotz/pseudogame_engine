import javax.swing.*;

/**
 * @author Burak Kara
 */
public abstract class Sprite {

    private int x, y;
    private int image_height, image_width;
    private ImageIcon ii;

    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getImage_height() {
        return image_height;
    }

    public void setImage_height(int image_height) {
        this.image_height = image_height;
    }

    public int getImage_width() {
        return image_width;
    }

    public void setImage_width(int image_width) {
        this.image_width = image_width;
    }

    public ImageIcon getIi() {
        return ii;
    }

    public void setIi(ImageIcon ii) {
        this.ii = ii;
        setImage_width(ii.getIconWidth());
        setImage_height(ii.getIconHeight());
    }
}
