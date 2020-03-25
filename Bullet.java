import java.util.ArrayList;
import java.util.List;

public abstract class Bullet extends BackyardMaterials { // dia child class dari Backyard Materials

    public Bullet(int row, int col){
        super(row, col);
        this.symbol = "-"; // simbolnya semua sama "-"
    }

    public int getRow(){
        return this.position.row;
    }

    public int getCol(){
        return this.position.col;
    }

    public String getSymbol(){
        return this.symbol;
    }

    public void setPosition(Point p) {
        this.position = p;
    }

    public void setPosition(int row, int col) {
        this.position = new Point(row, col);
    }

    public int getDamage(){ // damage yang dihasilkan peluru
        return this.damage;
    }


    // INI BELUM BERHASIL JUGA :(
    // ini buat teknis gerak pelurunya
    // Untuk SETIAP peluru,
    // 1. harus gerak ke kanan
    // 2. kalo ada tanaman lain di depannya, gimana caranya dia tetep ada tapi di tampilan layar ga keliatan? (ketimpa taneman)
    // 3. kalo ada zombie di depannya, gimana caranya pelurunya ilang langsung dan langsung ditimpa zombie kalo belom mati
    // 4. kalo udah sampe ujung layar ilang
    public void bulletMove(Backyard backyard){ 
        for (int i = 0; i < backyard.backyard.length; i++) {
            for (int j = 0; j < backyard.backyard[0].length; j++) {
                if (backyard.backyard[i][j] instanceof Zombie) {// intinya dia nyari di matrix kalo ada entitas zombie di depannya persis
                    if (this.getRow() == i && this.getCol() == j-1) {
                        backyard.removeBackyardMaterials(this, this.getRow(), this.getCol()); // dia bakal ilang
                        backyard.backyard[i][j].health -= this.damage; // health zombie berkurang sesuai damage dia
                        backyard.addBackyardMaterials(backyard.backyard[i][j], this.getRow(), this.getCol()); // ini maksudnya biar si zombienya tetep ada
                        // TAPI BELUM BERHASIL :(
                    }
                }
                if (backyard.backyard[i][j] instanceof Plants){ // ini nyari kalo ada entitas plants di depannya persis
                    if (this.getRow() == i && this.getCol() == j - 1){
                        backyard.removeBackyardMaterials(this, this.getRow(), this.getCol()); // dia bakal ilang
                        backyard.addBackyardMaterials(backyard.backyard[i][j], this.getRow(), this.getCol()); // ini maksudnyajg biar si plant tetap ada :(
                    }
                } 
            }
        }
        backyard.removeBackyardMaterials(this, this.getRow(), this.getCol()); // ini maksudnya setiap dia gerak, misal dari (2,5) ke (2,6)
        this.position.col += 1; 
        backyard.addBackyardMaterials(this, this.getRow(), this.getCol());// biar "-" di (2,5) ilang, muncul "-" di (2,6)   
    }
}

