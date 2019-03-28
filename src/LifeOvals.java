import java.awt.*;

public class LifeOvals extends GameSprites {

    private int ovalX;
    private int ovalY;
    private int ovalSize = 25;
    private int ovalFill = ovalSize;
    private Color ovalColor = new Color(0, 0, 255);

    public LifeOvals() {
        super(-100, -100, 0, 0, 0, "./res/pic.jpg");
        PanelAndObserver.container1.add(this);
    }

    public int getOvalX() {
        return ovalX;
    }

    public void setOvalX(int ovalX) {
        this.ovalX = ovalX;
    }

    public int getOvalY() {
        return ovalY;
    }

    public void setOvalY(int ovalY) {
        this.ovalY = ovalY;
    }

    public void setOvalFill(int ovalFill) {
        this.ovalFill = ovalFill;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(ovalColor);
        g.drawOval(getOvalX(), getOvalY(), ovalSize, ovalSize);
        g.fillOval(getOvalX(), getOvalY(), ovalFill, ovalSize);
    }

}
