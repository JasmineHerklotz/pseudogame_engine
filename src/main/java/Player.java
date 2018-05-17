import java.util.ArrayList;

/**
 * @author Burak Kara
 */
public class Player extends Sprite {

    private int playerSpeed = 2;
    private ArrayList<Shot> shots = new ArrayList<>();

    private Direction directionX;
    private Direction directionY;

    private long counterPauseShoot;
    private long pauseShoot = 1000;

    public Player(int x, int y) {
        super(x, y);
        counterPauseShoot = Long.MAX_VALUE;
    }

    public int getPauseValue(){

        double pause = counterPauseShoot + pauseShoot;

        double difference =  pause - System.currentTimeMillis();

        double percentage = getImage_width() / difference;

        int output;


        if (percentage < 0){
            output = 0;
        }else if(percentage >= 1){
            output = getImage_width();
        }else {
            output = (int) (percentage * getImage_width());
            if (output < 0.1){
                output *= 10;
            }
        }

        return output;
    }

    public void shoot(){

        if (counterPauseShoot + pauseShoot <= System.currentTimeMillis()){
            counterPauseShoot = System.currentTimeMillis();
            shots.add(new Shot(getX(),getY(),directionX, directionY));
        }

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
}
