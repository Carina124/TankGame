import java.awt.*;
import java.util.Observable;

public class Bullet extends GameSprites {
    //just a simple explosion trying to have a good time
    Explosion sparkySparkyBoomBoomMan = new Explosion();
    public Rectangle bulletRectanlge;
    private int explosionStart;
    private int explosionEnd;
    private int explosionDuration = 10;
    private boolean showExplosionTruth = false;

    public Bullet() {
        super.setImg(MainTankGame.bulletIm);
        this.bulletRectanlge = new Rectangle(super.x, super.y, super.img.getWidth(), super.img.getHeight());
        super.x = -100;
        super.y = -100;
        super.setImpactValue(1);
        MainTankGame.SpriteCollision.addSprite(this);
        loadExplosion();
        PanelAndObserver.addToObserver(sparkySparkyBoomBoomMan);
    }

    public Rectangle getRectangle() {
        return this.bulletRectanlge;
    }

    @Override
    public void update(Observable o, Object arg) {
        super.x += super.vx;
        super.y += super.vy;

        this.bulletRectanlge.setLocation(super.x, super.y);
        System.out.println(super.collisionTruth);
        sparkySparkyBoomBoomShow();
    }

    @Override
    public void isItInYet() {
        this.collisionTruth = true;
        this.showExplosionTruth = true;
        setExplosion();
        this.explosionStart = MainTankGame.loopCount;
        this.explosionEnd = this.explosionStart + this.explosionDuration;
        this.x = -100;
        this.y = -100;
        this.vx = 0;
        this.vy = 0;
    }

    private void sparkySparkyBoomBoomShow() {
        if (this.showExplosionTruth) {
            this.explosionStart++;
        }
        if (this.explosionStart == this.explosionEnd) {
            this.showExplosionTruth = false;
            sparkySparkyBoomBoomMan.x = -100;
            sparkySparkyBoomBoomMan.y = -100;
        }
    }

    private void loadExplosion() {
        sparkySparkyBoomBoomMan.setX(-100);
        sparkySparkyBoomBoomMan.setY(-100);
        sparkySparkyBoomBoomMan.setImg(MainTankGame.explosionIm);
        MainTankGame.eA.add(sparkySparkyBoomBoomMan);
    }

    private void setExplosion() {
        sparkySparkyBoomBoomMan.x = this.x;
        sparkySparkyBoomBoomMan.y = this.y;
    }

}
