import javax.swing.*;

/**
 * @author Burak Kara
 */
public class Shot extends Sprite {

    private Direction directionX;
    private Direction directionY;
    private int shotSpeed = 20;

    public Shot(int x, int y, Direction directionX, Direction directionY) {
        super(x, y);
        this.directionX = directionX;
        this.directionY = directionY;
        this.setIi(new ImageIcon(this.getClass().getResource("shot.png")));
    }

    public void move() {
        if(directionX == Direction.LEFT){
            setX(getX() - shotSpeed);
        }else if(directionX == Direction.RIGHT){
            setX(getX() + shotSpeed);
        }

        if(directionY == Direction.UP){
            setY(getY() - shotSpeed);
        }else if(directionY == Direction.DOWN){
            setY(getY() + shotSpeed);
        }

    }

    public Direction getDirectionX() {
        return directionX;
    }

    public void setDirectionX(Direction directionX) {
        this.directionX = directionX;
    }

    public Direction getDirectionY() {
        return directionY;
    }

    public void setDirectionY(Direction directionY) {
        this.directionY = directionY;
    }

    public int getShotSpeed() {
        return shotSpeed;
    }

    public void setShotSpeed(int shotSpeed) {
        this.shotSpeed = shotSpeed;
    }
}
