import java.awt.*;
import javax.swing.*;

public class Sunflower extends Plant {

    private long timePlanted;
    private long SUN_DELAY = 10000;

    public Sunflower(int x, int y){
        super(x, y);
        ImageIcon i = new ImageIcon("images/sunflower.gif");
        this.image = i.getImage();
        this.health = 3000;
        this.cost = 50;
        this.timePlanted = System.currentTimeMillis();
    }

    public void produceSun(GameBoard gameBoard) {
        long currentTime = System.currentTimeMillis();

        if ((currentTime - timePlanted) >= this.SUN_DELAY) {
            timePlanted = currentTime;
            SunflowerPoint sun = new SunflowerPoint(this.position.x + 25, this.position.y, false);
            gameBoard.sunList.add(sun);
        }
    }

    public void act(GameBoard gameBoard) {
        produceSun(gameBoard);
    }
}