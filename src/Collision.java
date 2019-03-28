import java.awt.*;

import java.util.ArrayList;

public class Collision {
    public ArrayList<GameSprites> collisions;

    public Collision() {
        this.collisions = new ArrayList<>();
    }

    public void addSprite(GameSprites sprite1) {
        collisions.add(sprite1);
    }

    public void checkIfThereHasBeenACollisionWasThereOrNot_AlsoIsThereAnotherBooty_HEYsomePeepsAREjustINTObuttSTUFFyoooo() {
        Rectangle rec1;
        Rectangle rec2;
        int impactValue1;
        int impactValue2;
        GameSprites sp1, sp2;

        for (int i = 0; i < collisions.size(); i++) {
            sp1 = collisions.get(i);
            rec1 = sp1.getRectangle();

            for (int j = i + 1; j < collisions.size(); j++) {
                sp2 = collisions.get(j);
                rec2 = sp2.getRectangle();
                if (rec1.intersects(rec2) && rec1.x > -50 && rec2.x > -50) {

                    impactValue1 = collisions.get(i).getImpactValue();
                    impactValue2 = collisions.get(j).getImpactValue();

                    collisions.get(i).setColImpactValue(impactValue2);
                    collisions.get(j).setColImpactValue(impactValue1);

                    collisions.get(j).isItInYet();
                    collisions.get(i).isItInYet();
                }
            }
        }
    }
}
