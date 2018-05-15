/**
 * @author Burak Kara
 */
public class Player extends Sprite {

    private int playerSpeed = 20;

    public Player(int x, int y) {
        super(x, y);
    }



    @Override
    public void setX(int x) {
        if(x < 0){
            x = 0;
        }
        if(x + this.getImage_width() > Commons.width){
            x = Commons.width - this.getImage_width();
        }
        super.setX(x);
    }

    @Override
    public void setY(int y) {
        if(y < 0){
            y = 0;
        }

        if(y + this.getImage_height() > Commons.height){
            y = Commons.height - this.getImage_height();
        }

        super.setY(y);
    }

    public int getPlayerSpeed() {
        return playerSpeed;
    }

    public void setPlayerSpeed(int playerSpeed) {
        this.playerSpeed = playerSpeed;
    }
}
