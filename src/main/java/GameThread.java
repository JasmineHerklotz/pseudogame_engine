import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Burak Kara
 */
public class GameThread extends JPanel{

    private int counter = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GameThread();
            }
        });
    }

    public GameThread(){
        JFrame window = new JFrame();
        window.setSize(Commons.height, Commons.width);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setFocusable(true);
        window.setLocationRelativeTo(null);
        window.setTitle(Commons.title);
        window.setVisible(true);

        initialize();
        window.add(this);
        startGame();



    }

    private void initialize() {

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

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

    }
}
