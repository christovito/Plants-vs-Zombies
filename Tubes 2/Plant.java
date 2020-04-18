import java.awt.*;
import javax.swing.*;

public abstract class Plant implements BackyardMaterials {
    protected Point position;
    protected Image image;
    protected int health;
    protected int cost;

    public Plant(int x, int y){
        this.position = new Point(x, y);
    }

    public int getX(){
        return this.position.x;
    } 

    public int getY(){
        return this.position.y;
    }

    public Image getImage(){
        return this.image;
    }

    public int getHealth(){
        return this.health;
    }

    public int getCost(){
        return this.cost;
    }

    public abstract void act(GameBoard gameBoard);
    
}