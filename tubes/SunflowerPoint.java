import java.awt.*;
import javax.swing.*;

public class SunflowerPoint implements BackyardMaterials {

    private Point position;
    private Image image;
    private long timeAppear;
    private long sunDuration = 7000;
    private boolean moving;
    private int sunValue = 25;

    public SunflowerPoint(int x, int y, boolean moving){
        this.position = new Point(x, y);
        ImageIcon i = new ImageIcon("images/sun.png");
        this.image = i.getImage();
        this.timeAppear = System.currentTimeMillis();
        this.moving = moving;
    }

    public int getX(){
        return this.position.x;
    }

    public int getY(){
        return this.position.y;
    }

    public Image getImage() {
        return this.image;
    }

    public long getTimeAppear(){
        return this.timeAppear;
    }

    public long getSunDuration(){
        return this.sunDuration;
    }

    public void act(GameBoard gameBoard){
        if (this.moving == false){
        } else if (this.moving == true){
            this.position.y += 3;
            if (System.currentTimeMillis() - this.timeAppear >= 3000){
                this.moving = false;
            }
        }
    }
}