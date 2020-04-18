import java.awt.*;
import javax.swing.*;

public class ZombieConehead extends Zombie {

    public ZombieConehead(int x, int y) {
        super(x, y);
        ImageIcon i = new ImageIcon("images/zombiecone.gif");
        this.image = i.getImage();
        this.health = 750;
        this.damage = 20;
        this.speed = 1;
    }
}