import java.awt.*;
import java.util.Observable;

public class HealthPowerUp extends GameSprites {

    public HealthPowerUp(int x, int y) {
        super.setImg(MainTankGame.puIm);
        super.x = x;
        super.y = y;
        this.rectangle = new Rectangle(super.x, super.y, super.img.getWidth(), super.img.getHeight());
        super.setImpactValue(2);
        MainTankGame.SpriteCollision.addSprite(this);
    }

    public static void powerUpMaker(int x, int y) {
        HealthPowerUp pu1 = new HealthPowerUp(x, y);
        PanelAndObserver.addToObserver(pu1);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (collisionTruth && super.colImpactValue == 10) {
            setX(-100);
            setY(-100);
            this.rectangle.setLocation(-100, -100);
        }
        super.repaint();
        collisionTruth = false;
    }
}
