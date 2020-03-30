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
        this.symbol = "-";   
        int row = backyard.backyard.length;
        int col = backyard.backyard[0].length;
       
        for(Bullet bullet : game.bulletList){
            if (bullet == this){
                for (int i = 0; i < row; i++){
                    for (int j = 0; j < col; j++){
                        if (backyard.backyard[i][j+1] != null){
                            this.symbol = backyard.backyard[i][j+1].symbol;
                        }
                    }
                }
            }
        }         
        backyard.removeBackyardMaterials(backyard, this.getRow(), this.getCol());
        this.position.col += this.speed;

    }
}



