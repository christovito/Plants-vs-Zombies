import java.util.ArrayList;
import java.util.List;

public class SnowPeashooter extends Plants implements Shooter{

    public SnowPeashooter(int row, int col){
        super(row, col);
        this.cost = 175;
        this.health = 25;
        this.symbol = "S";
    }

    public void shoot(Backyard backyard){ // sama kasusnya kaya peashooter
         for (int i = 0; i < backyard.backyard.length; i++) {
            for (int j = 0; j < backyard.backyard[0].length; j++) {
                if (backyard.backyard[this.getRow()][this.getCol()+1] == null) {
                    Bullet bulletSnowPea = new BulletSnowPea(this.position.getRow(), this.position.getCol()+1);
                    backyard.addBackyardMaterials(bulletSnowPea, this.getRow(), this.getCol() + 1);
                    bulletSnowPea.bulletMove(backyard);
                } else {
                    backyard.addBackyardMaterials(backyard.backyard[this.getRow()][this.getCol()+ 1], this.getRow(), this.getCol());
                }
            }
        }       
        //bulletList.add(bulletSnowPea);
        
        //while (this.health >= 0 && bulletSnowPea.getCol() <= ) {
       
    }
        
}