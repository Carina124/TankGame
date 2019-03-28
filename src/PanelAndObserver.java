import java.util.Observer;
import javax.swing.*;

public class PanelAndObserver {

    public static final GameObserver observer1 = new GameObserver();

    public static JPanel container1 = new JPanel();

    public static void initPanel() {
        container1.setLayout(new OverlayLayout(container1));
    }

    public static void addToObserver(Observer sprite1) {
        observer1.addObserver(sprite1);
    }

    public static void note() {
        observer1.notifyObservers();
    }

    public static void set() {
        observer1.setChanged();
    }
}
