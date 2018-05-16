import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Burak Kara
 */
public class GameThread extends JPanel{

    private final KeyboardListener keyboardListener;
    private Player player;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GameThread();
            }
        });
    }

    public GameThread(){
        JFrame window = new JFrame();
        window.getContentPane().add(new Window());
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setFocusable(true);
        window.setLocationRelativeTo(null);
        window.setTitle(Commons.title);
        window.setVisible(true);
        window.pack();
        window.setLocationRelativeTo(null);

        keyboardListener = new KeyboardListener();

        initialize();
        window.add(this);
        window.addKeyListener(keyboardListener);

        startGame();
    }

    private void initialize() {
        player = new Player(0,0);
        player.setIi(new ImageIcon(this.getClass().getResource("wizard1Right.png")));
    }

    private void startGame() {
        ScheduledExecutorService executor = Executors
                .newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(new Runnable() {
            public void run() {
                update();
                repaint();
            }
        }, 0, 1000 / Commons.FPS, TimeUnit.MILLISECONDS);
    }

    private void update() {
        checkInputs();
        moveShots();
    }

    private void moveShots() {
        for (Iterator<Shot> iterator = player.getShots().iterator(); iterator.hasNext();){
            Shot shot = iterator.next();
            shot.move();
            if(shot.getX() >= Commons.width)
                iterator.remove();
        }
    }

    private void checkInputs() {

        player.setDirectionX(null);
        player.setDirectionY(null);

        if(keyboardListener.keys[KeyEvent.VK_W]){
            player.setY(player.getY() - player.getPlayerSpeed());
            player.setDirectionY(Direction.UP);
        }

        if(keyboardListener.keys[KeyEvent.VK_S]){
            player.setY(player.getY() + player.getPlayerSpeed());
            player.setDirectionY(Direction.DOWN);
        }

        if(keyboardListener.keys[KeyEvent.VK_D]){
            player.setX(player.getX() + player.getPlayerSpeed());
            player.setDirectionX(Direction.RIGHT);
        }

        if(keyboardListener.keys[KeyEvent.VK_A]){
            player.setX(player.getX() - player.getPlayerSpeed());
            player.setDirectionX(Direction.LEFT);
        }

        if(keyboardListener.keys[KeyEvent.VK_SPACE])
            player.shoot();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(player.getIi().getImage(),player.getX(), player.getY(),null);

        //draw shots
        for (Shot shot : player.getShots()){
            g2d.drawImage(shot.getIi().getImage(), shot.getX(), shot.getY(), null);
        }

    }
}
