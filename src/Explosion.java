import java.awt.*;
import java.io.IOException;
import java.util.Observable;

public class Explosion extends GameSprites {

    public Explosion() {
        super();
        super.x = -100;
        super.y = -100;
    }

    public void setImg(String filePath) {
        try {
            this.img = BufferedImageLoader.loadImage(filePath);
        } catch (IOException e) {
            this.img = null;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }

    @Override
    public String toString() {
        if (collisionTruth) {
            return "true";
        } else {
            return "false";
        }
    }

    public Rectangle getRectangle() {
        return this.rectangle;
    }
}
