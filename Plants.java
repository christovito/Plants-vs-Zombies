import java.util.ArrayList;
import java.util.List;

public abstract class Plants extends BackyardMaterials {
    //protected int cost;
    //protected int health;
    //protected ArrayList<Bullet> bulletList;

    public Plants(int row, int col){
        //this.position = new Point(row, col);
        super(row, col);
        //bulletList = new ArrayList<Bullet>();
    }

    public int getCost(){
        return this.cost;
    }

    public int getHealth(){
        return this.health;
    }

    public String getSymbol(){
        return this.symbol;
    }

    public boolean isDead(){
        return this.health == 0;
    }

    public void shoot(Backyard backyard){
    }

    
}