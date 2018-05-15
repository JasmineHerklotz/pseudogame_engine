/**
 * @author Burak Kara
 */
public class Player extends Sprite {

    private int playerSpeed = 2;

    public Player(int x, int y) {
        super(x, y);
    }


    public int getPlayerSpeed() {
        return playerSpeed;
    }

    public void setPlayerSpeed(int playerSpeed) {
        this.playerSpeed = playerSpeed;
    }
}
