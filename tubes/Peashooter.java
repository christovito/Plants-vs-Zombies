import java.awt.*;
import javax.swing.*;

public class Peashooter extends Plant implements Shooter{

    private long timePlanted;

    public Peashooter(int x, int y){
        super(x, y);
        ImageIcon i = new ImageIcon("images/peashooter.gif");
        this.image = i.getImage();
        this.health = 3000;
        this.cost = 100;
        this.timePlanted = System.currentTimeMillis();
    }

    public void shoot(GameBoard gameBoard){
        long currentTime = System.currentTimeMillis();

        if (gameBoard.isZombieOnLane(this.position.x, this.position.y) && ((currentTime - timePlanted) >= 1000)) {
            timePlanted = currentTime;
            Bullet bulletPea = new BulletPea(this.position.x + 50, this.position.y);
            gameBoard.bulletList.add(bulletPea);
        }  
    }

    public void act(GameBoard gameBoard){
        shoot(gameBoard);
    }
}