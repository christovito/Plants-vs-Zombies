import java.util.ArrayList;
import java.util.List;

public class SnowPeashooter extends Plants implements Shooter{

    private int shootCounter = 0;

    public SnowPeashooter(int row, int col){
        super(row, col);
        this.symbol = "I";
        this.health = 50;
        this.cost = 175;
        this.damage = 20;
    }

    public void shoot(Backyard backyard, Game game){
        if (this.shootCounter % 4 == 0) {
            Bullet bulletSnowPea = new BulletSnowPea(this.getRow(), this.getCol() + 2);
            game.bulletList.add(bulletSnowPea);
        }
        shootCounter++;   
    }    
}