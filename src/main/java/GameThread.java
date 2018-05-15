import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
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
        window.setSize(Commons.width, Commons.height);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setFocusable(true);
        window.setLocationRelativeTo(null);
        window.setTitle(Commons.title);
        window.setVisible(true);

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
    }

    private void checkInputs() {

        if(keyboardListener.keys[KeyEvent.VK_W])
            player.setY(player.getY() - player.getPlayerSpeed());

        if(keyboardListener.keys[KeyEvent.VK_S])
            player.setY(player.getY() + player.getPlayerSpeed());

        if(keyboardListener.keys[KeyEvent.VK_D])
            player.setX(player.getX() + player.getPlayerSpeed());

        if(keyboardListener.keys[KeyEvent.VK_A])
            player.setX(player.getX() - player.getPlayerSpeed());

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(player.getIi().getImage(),player.getX(), player.getY(),null);
    }
}
