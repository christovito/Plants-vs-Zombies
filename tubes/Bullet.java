import java.awt.*;
import javax.swing.*;

public abstract class Bullet implements BackyardMaterials {
    protected Point position;
    protected Image image;
    protected int damage;
    protected int speed;

    public Bullet(int x, int y){
        this.position = new Point(x, y);
        this.speed = 5;
    }

    public int getX() {
        return this.position.x;
    }

    public int getY() {
        return this.position.y;
    }

    public Image getImage(){
        return this.image;
    }

    public int getDamage(){
        return this.damage;
    }

    public int getSpeed(){
        return this.speed;
    }

    public abstract void act(GameBoard gameBoard);
}