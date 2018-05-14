import javax.swing.*;

/**
 * @author Burak Kara
 */
public class GameThread extends JPanel implements Runnable{

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
    }

    public void run() {

    }
}
