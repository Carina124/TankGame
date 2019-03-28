import java.awt.*;
import java.util.Observable;

public class WallSprite extends GameSprites {
    private int wallLife = 3;

    public WallSprite(int x, int y) {
        super.setImg(MainTankGame.wallIm);
        super.x=x;
        super.y=y;
        this.rectangle = new Rectangle(super.x, super.y, super.img.getWidth(), super.img.getHeight());
        super.setImpactValue(20);
        MainTankGame.SpriteCollision.addSprite(this);
    }

    public static void wallMaker(int x_start, int x_end, int y_start, int y_end, boolean breakTruth){
        for(int i = x_start; i<x_end; i+=30){
            for(int j = y_start; j<y_end; j+=30){
                WallSprite wallSprite1 = new WallSprite(i, j);
                if(breakTruth){
                    wallSprite1.wallLife=100000;
                }
                PanelAndObserver.addToObserver(wallSprite1);
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if(collisionTruth && super.colImpactValue==1){
            wallLife--;
        }
        if(wallLife == 2){
            img = MainTankGame.wallBreakIm;
        }
        if(wallLife==0){
            setX(-100);
            setY(-100);
            this.rectangle.setLocation(-100,-100);
            PanelAndObserver.observer1.deleteObserver(this);
        }
        super.repaint();
        collisionTruth = false;
    }
}
