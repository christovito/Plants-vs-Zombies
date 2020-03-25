import java.util.ArrayList;
import java.util.List;

public class Peashooter extends Plants implements Shooter {
    
    static int count = 1;
    public Peashooter(int row, int col) {
        super(row, col);
        this.cost = 100;
        this.health = 20;
        this.symbol = "P";
    }

    // INI JUGA BELUM BERHASIL :(
    // 1. dia kalo pada matrix di posisi depannya null baru bisa bikin peluru baru, kalo ngga null belum tau caranya
    // 2. setiap nembak, dia bakal menciptakan objek bullet baru
    // 3. terus ditampilkan di matrix backyard
    public void shoot(Backyard backyard){ // ini buat nembak peluru
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
        //bulletList.add(bulletPea);
        //count++;
    }
