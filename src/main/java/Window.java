import javax.swing.*;
import java.awt.*;

/**
 * @author Burak Kara
 */
public class Window extends JComponent {

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Commons.width, Commons.height);
    }
}
