import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainTankGame extends JPanel {
    public static int loopCount = 0;
    public static Collision SpriteCollision = new Collision();
    public static ArrayList<GameSprites> eA = new ArrayList<>();
    public static BufferedImage tankIm1;
    public static BufferedImage tankIm2;
    public static BufferedImage bulletIm;
    public static BufferedImage explosionIm;
    public static BufferedImage backgroundIm;
    public static BufferedImage wallIm;
    public static BufferedImage wallBreakIm;
    public static BufferedImage puIm;
    public static BufferedImage inIm;
    public static BufferedImage world;
    public static int fireRate = 20;
    public static JFrame jf = new JFrame();
    public static final int screenWidth = 1280;
    public static final int screenHeight = 960;
    public static final int worldWidth = 2500;
    public static final int worldHeight = 2500;

    {
        try //load all of the images here
        {
            inIm = BufferedImageLoader.loadImage("./res/Tank8.png");//dont change
            puIm = BufferedImageLoader.loadImage("./res/pu.png");
            wallIm = BufferedImageLoader.loadImage("./res/tile3.png");
            wallBreakIm = BufferedImageLoader.loadImage("./res/Btile3.png");
            tankIm1 = BufferedImageLoader.loadImage("./res/Tank1.jpg");
            tankIm2 = BufferedImageLoader.loadImage("./res/Tank7.jpg");
            bulletIm = BufferedImageLoader.loadImage("./res/bullet2.png");
            explosionIm = BufferedImageLoader.loadImage("./res/Boomshakalaka1.png");
            backgroundIm = BufferedImageLoader.loadImage("./res/background4.jpg");
        } catch (IOException ex) {

        }
    }

    public static void main(String[] args) {
        MainTankGame mA = new MainTankGame();
        mA.init();
        PanelAndObserver.container1.add(mA);
        jf.add(PanelAndObserver.container1);

        try {
            while (true) {
                //i apologize but i loved this method name so much i didnt want to change it...
                SpriteCollision.checkIfThereHasBeenACollisionWasThereOrNot_AlsoIsThereAnotherBooty_HEYsomePeepsAREjustINTObuttSTUFFyoooo();
                PanelAndObserver.set();
                PanelAndObserver.note();
                Thread.sleep(1000 / 144);
                loopCount = (loopCount + 1) % fireRate;
                System.out.println("Observer Count: " + PanelAndObserver.observer1.countObservers());
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(MainTankGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void init() {
        this.world = new BufferedImage(worldWidth, worldHeight, BufferedImage.TYPE_INT_RGB);
        PanelAndObserver.initPanel();
        Tank bt1 = new Tank(610 + 30 + 30, 770 + 30 + 30, 0, 0, 0, "./res/Tank8.png");
        Tank bt2 = new Tank(1890 - 60 - 30 - 30, 1730 - 60 - 30 - 30, 0, 0, 180, "./res/Tank8.png");
        bt1.setHealthBarLocation(10, 0);
        bt1.setSpawn(bt1.x, bt1.y);
        bt2.setSpawn(bt2.x, bt2.y);
        bt2.setHealthBarLocation(1165, 0);
        bt2.ti1.setImg(tankIm2);
        PanelAndObserver.container1.add(bt1);
        PanelAndObserver.container1.add(bt2);
        PanelAndObserver.observer1.addObserver(bt1);
        PanelAndObserver.observer1.addObserver(bt2);

        /////////////////////////////    Boarder walls    ///////////////////////////////////////////////////////////////
        WallSprite.wallMaker(610, 610 + 30, 770, 1730, true); //left vertical border
        WallSprite.wallMaker(1860, 1860 + 30, 770, 1730, true); //right vertical border
        WallSprite.wallMaker(640, 1860, 770, 770 + 30, true); //top horizontal border
        WallSprite.wallMaker(640, 1860, 1700, 1700 + 30, true); //bottom horizontal border

        //////////////////////////////    POWER UP BOX    ////////////////////////////////////////////////////////
        WallSprite.wallMaker(1115, 1115 + 30, 1150 + 60, 1180 + 180, false); //left vertical PU
        WallSprite.wallMaker(1355, 1355 + 30, 1150 + 60, 1180 + 180, false); //right Vertical PU
        WallSprite.wallMaker(1145, 1145 + 30 * 7, 1150 + 60, 1150 + 90, false); //top horizontal PU
        WallSprite.wallMaker(1145, 1145 + 30 * 7, 1180 + 150, 1180 + 180, false); //bottom horizontal pu

        ////////////////////////////    Other Walls    /////////////////////////////////////////////////////////////
        WallSprite.wallMaker(1355 + 8 * 30, 1355 + 9 * 30, 1210 - 8 * 30, 1210 + 8 * 30, true); //right Vertical PU
        WallSprite.wallMaker(1145 - 12 * 30, 1145 + 4 * 30, 1000, 1000 + 30, false); //bottom horizontal pu

        HealthPowerUp.powerUpMaker(1235, 1270);

        TankControls cda1 = new TankControls(bt1, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_M);
        jf.addKeyListener(cda1);

        TankControls cda2 = new TankControls(bt2, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_Z);
        jf.addKeyListener(cda2);

        jf.setTitle("TANK GAME");
        jf.setSize(screenWidth, screenHeight);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public void paint(Graphics g) {
        GameSprites sb1;

        Tank bt1 = (Tank) SpriteCollision.collisions.get(0);
        Tank bt2 = (Tank) SpriteCollision.collisions.get(31);

        Graphics2D g2 = this.world.createGraphics();
        g2.drawImage(MainTankGame.backgroundIm, 0, 0, worldWidth, worldHeight, null);

        for (int i = 0; i < SpriteCollision.collisions.size(); i++) {
            sb1 = SpriteCollision.collisions.get(i);
            sb1.paintComponent(g2);
        }
        for (int i = 0; i < MainTankGame.eA.size(); i++) {
            sb1 = MainTankGame.eA.get(i);
            sb1.paintComponent(g2);
        }
        Graphics2D g22 = (Graphics2D) g;

        int bt1_x = bt1.getTankCenterX();
        int bt1_y = bt1.getTankCenterY();
        int bt2_x = bt2.getTankCenterX();
        int bt2_y = bt2.getTankCenterY();

        BufferedImage lh = world.getSubimage(bt1_x - 293, bt1_y - 458, screenWidth / 2, screenHeight);
        BufferedImage rh = world.getSubimage(bt2_x - 293, bt2_y - 458, screenWidth / 2, screenHeight);
        BufferedImage mm = world.getSubimage(610, 770, screenWidth, screenHeight);

        g22.drawImage(lh, 0, 0, null);
        g22.drawImage(rh, (screenWidth / 2 + 2), 0, null);

        g22.scale(.2, .2);
        g22.drawImage(mm, 512 * 5, (768 * 5) - 300, null);

        g.dispose();
    }
}