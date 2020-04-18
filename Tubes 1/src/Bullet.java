import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Bullet extends BackyardMaterials {

    public Bullet(int row, int col){
        super(row, col);
        this.symbol = "-";
        this.health = 0;
        this.speed = 1;
        this.cost = 0;
    }

    public void bulletMove(Backyard backyard, Game game){
        backyard.removeBackyardMaterials(backyard, this.getRow(), this.getCol());
        this.position.col += this.speed;
    }
}



