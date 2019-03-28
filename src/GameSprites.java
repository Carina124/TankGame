import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class GameSprites extends JComponent implements Observer {
    protected int r = 3;
    protected int x;
    protected int y;
    protected int vx;
    protected int vy;
    protected int angle;
    protected BufferedImage img ;
    protected Rectangle rectangle;
    protected boolean collisionTruth = false;
    protected int impactValue;
    protected int colImpactValue;
    protected int pre_x;
    protected int pre_y;
    protected int pre_vx;
    protected int pre_vy;
    protected int pre_angle;

    public GameSprites()
    {
        this.x = 0;
        this.y = 0;
        this.vx = 0;
        this.vy = 0;
        this.angle = 0;
        this.img = null;
    }

    public GameSprites(int x, int y, int vx, int vy, int angle, String filePath)
    {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.angle = angle;
        setImg(filePath);
        this.rectangle = new Rectangle(this.x, this.y, this.img.getWidth(), this.img.getHeight());
    }


    public int getImpactValue(){
        return impactValue;
    }

    public void setImpactValue(int iv){
        this.impactValue = iv;
    }

    public void setColImpactValue(int civ){
        this.colImpactValue = civ;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void setImg(String filePath) {
        try
        {
            this.img = BufferedImageLoader.loadImage(filePath);
        }
        catch (IOException e)
        {
            this.img = null;

        }
    }

    public void setImg(BufferedImage image1)
    {
        this.img = image1;
    }


    @Override
    public void update(Observable o, Object arg)
    {

    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        AffineTransform rotation = AffineTransform.getTranslateInstance(x, y);
        rotation.rotate(Math.toRadians(angle), img.getWidth() / 2, img.getHeight() / 2);
        Graphics2D graphic2D = (Graphics2D) g;
        graphic2D.drawImage(img, rotation, null);
        System.out.println(collisionTruth);

    }

    @Override
    public String toString()
    {
        if (collisionTruth)
        {
            return "true";
        }
        else
        {
            return "false";
        }

    }

    public void isItInYet()
    {
        this.collisionTruth = true;

    }

    public Rectangle getRectangle()
    {
        return this.rectangle;
    }

}
