import java.awt.*;
import javax.swing.*;

public class ZombieNewspaper extends Zombie {

    public ZombieNewspaper(int x, int y) {
        super(x, y);
        ImageIcon i = new ImageIcon("images/zombienews.gif");
        this.image = i.getImage();
        this.health = 600;
        this.damage = 10;
        this.speed = 2;
    }
}