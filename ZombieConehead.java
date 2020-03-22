public class ZombieConehead extends Zombie{

    public ZombieConehead(int row, int col){
        super(row, col);
        this.health = 100;
        this.speed = 1;
        this.zombieDamage = 5;
        this.symbol = "C";
    }
}