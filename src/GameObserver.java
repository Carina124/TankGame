import java.util.Observable;

public class GameObserver extends Observable {

    public GameObserver() {
    }

    protected synchronized void setChanged() {
        super.setChanged();
    }
}