import java.awt.*;
import javax.swing.*;

public class SnowPeashooter extends Plant implements Shooter {

    private long timePlanted;

    public SnowPeashooter(int x, int y) {
        super(x, y);
        ImageIcon i = new ImageIcon("images/snowpea.gif");
        this.image = i.getImage();
        this.health = 3000;
        this.cost = 175;
        this.timePlanted = System.currentTimeMillis();
    }

    public void shoot(GameBoard gameBoard){
        long currentTime = System.currentTimeMillis();

        if (gameBoard.isZombieOnLane(this.position.x, this.position.y) && ((currentTime - timePlanted) >= Shooter.SHOOT_DELAY)){
            timePlanted = currentTime;
            Bullet bulletSnowPea = new BulletSnowPea(this.position.x + 50, this.position.y);
            gameBoard.bulletList.add(bulletSnowPea);
        }
    }

    public void act(GameBoard gameBoard){
        shoot(gameBoard);
    }
}