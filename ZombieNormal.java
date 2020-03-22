public class ZombieNormal extends Zombie{

    public ZombieNormal(int row, int col){
        super(row, col);
        this.health = 60;
        this.speed = 1;
        this.zombieDamage = 5;
        this.symbol = "Z";
    }
}