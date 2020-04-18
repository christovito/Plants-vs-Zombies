import java.awt.*;
import javax.swing.*;

public class BulletSnowPea extends Bullet {

    public BulletSnowPea(int x, int y) {
        super(x, y);
        ImageIcon i = new ImageIcon("images/bulletsnow.png");
        this.image = i.getImage();
        this.damage = 250;
    }

    public void act(GameBoard gameBoard) {
        this.position.x += this.speed;
    }
}