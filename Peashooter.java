import java.util.ArrayList;
import java.util.List;

public class Peashooter extends Plants implements Shooter {
    
    private int shootCounter = 0;

    public Peashooter(int row, int col) {
        super(row, col);
        this.symbol = "P";
        this.health = 50;
        this.speed = 0;
        this.cost = 100;
        this.damage = 10;
    }

    public void shoot(Backyard backyard, Game game){
        if (this.shootCounter % 4 == 0) {
            Bullet bulletPea = new BulletPea(this.getRow(), this.getCol() + 2);
            game.bulletList.add(bulletPea);
        }
        shootCounter++;
    }
}
