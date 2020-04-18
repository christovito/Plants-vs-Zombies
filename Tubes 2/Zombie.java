import java.awt.*;
import javax.swing.*;

public abstract class Zombie implements BackyardMaterials {

    protected Point position;
    protected Image image;
    protected int health;
    protected int damage;
    protected int speed;
    protected boolean moving = true;

    public Zombie(int x, int y){
        this.position = new Point(x, y);
    }

    public int getX() {
        return this.position.x;
    }

    public int getY() {
        return this.position.y;
    }

    public Image getImage() {
        return this.image;
    }

    public int getHealth() {
        return this.health;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getSpeed(){
        return this.speed;
    }

    public void act(GameBoard gameBoard){
        if (this.moving == true){
            this.position.x -= this.speed;
        }
    }
}