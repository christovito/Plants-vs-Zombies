import java.awt.*;
import javax.swing.*;

public class Walnut extends Plant{
    
    public Walnut(int x, int y){
        super(x, y);
        ImageIcon i = new ImageIcon("images/walnut.gif");
        this.image = i.getImage();
        this.health = 10000;
        this.cost = 50;
    }

    public void act(GameBoard gameBoard) {
    }
}