import java.awt.*;
import javax.swing.*;

public class ZombieNormal extends Zombie {

    public ZombieNormal(int x, int y) {
        super(x, y);
        ImageIcon i = new ImageIcon("images/zombie.gif");
        this.image = i.getImage();
        this.health = 600;
        this.damage = 10;
        this.speed = 1;
    }
}