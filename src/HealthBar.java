import java.awt.*;

public class HealthBar extends GameSprites {

    private int healthX;
    private int healthY;
    private int healthFill = 100;
    private double healthPercent = healthFill / 100.0;
    private int healthPer255 = (int) healthPercent * 255;
    private Color healthBarColor = new Color(255 - healthPer255, healthPer255, 0);

    public HealthBar() {
        super(-100, -100, 0, 0, 0, "./res/pic.jpg");
        PanelAndObserver.container1.add(this);
    }

    public int getHealthX() {
        return healthX;
    }

    public void setHealthX(int healthX) {
        this.healthX = healthX;
    }

    public int getHealthY() {
        return healthY;
    }

    public void setHealthY(int healthY) {
        this.healthY = healthY;
    }

    public int getHealthFill() {
        return healthFill;
    }

    public void setHealthFill(int healthFill) {
        this.healthFill = healthFill;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(healthBarColor);
        g.drawRect(getHealthX(), getHealthY(), 100, 30);
        g.fillRect(getHealthX(), getHealthY(), healthFill, 30);
    }
}
