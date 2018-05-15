import java.util.ArrayList;

/**
 * @author Burak Kara
 */
public class Player extends Sprite {

    private int playerSpeed = 2;
    private ArrayList<Shot> shots = new ArrayList<>();

    public Player(int x, int y) {
        super(x, y);
    }

    public void shoot(){
        System.out.println(getX());
        shots.add(new Shot(getX(),getY()));
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

    public ArrayList<Shot> getShots() {
        return shots;
    }

    public void setShots(ArrayList<Shot> shots) {
        this.shots = shots;
    }
}
