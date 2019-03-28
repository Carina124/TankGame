import java.util.Observable;

public class TankImgClass extends GameSprites {

    public TankImgClass() {
        super.setImg(MainTankGame.tankIm1);
        super.setImpactValue(1);
        MainTankGame.eA.add(this);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
