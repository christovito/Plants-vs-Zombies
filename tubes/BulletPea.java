import java.awt.*;
import javax.swing.*;

public class BulletPea extends Bullet{

    public BulletPea(int x, int y){
        super(x, y);
        ImageIcon i = new ImageIcon("images/bulletpea.png");
        this.image = i.getImage();
        this.damage = 150;
    }

    public void act(GameBoard gameBoard){
        this.position.x += this.speed;
    }
}