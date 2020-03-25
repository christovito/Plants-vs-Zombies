import java.util.ArrayList;
import java.util.List;

public abstract class BackyardMaterials { // dia adalah parent class dari kelas bullet, plants, sama zombie, biar kalo mau akses matriks gampang
    protected Point position;
    protected String symbol;
    protected int health;
    protected int speed;
    protected int cost;
    protected int damage;
    protected boolean move = true;

    public BackyardMaterials(int row, int col){
        this.position = new Point(row, col);
    }
    public Point getPosition() {
        return this.position;
    }
    public int getRow() {
        return this.position.getRow();
    }

    public int getCol() {
        return this.position.getCol();
    }

    public String getSymbol(){
        if (this.symbol == null){
            return " ";
        } else {
            return this.symbol;
        }
    }

    public void setPosition(Point p) {
        this.position = p;
    }

    public void setPosition(int row, int col) {
        this.position = new Point(row, col);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void shoot(Backyard backyard){ // buat teknis nembak si plants
    }

    public void zombieMove(Backyard backyard){ // buat teknis gerak si zombie
    }
    
    public boolean isZombieOnLane(ArrayList<BackyardMaterials> zombieList) { // ini tadinya buat plants biar nembak cuma kalo di rownya ada zombie, kalo ga ada ga bakal nembak
        for (BackyardMaterials zombie : zombieList) {
            if (this.getRow() == zombie.getRow()){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void bulletMove(Backyard backyard){// buat teknis gerak si bullet
    }
}