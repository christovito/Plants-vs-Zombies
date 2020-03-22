public class Zombie {
    protected Point position;
    protected int health;
    protected int speed;
    protected int zombieDamage;
    protected String symbol;

    public Zombie(int row, int col){
        this.position = new Point(row, col);
    }

    public int getSpeed(){
        return this.speed;
    }

    public void move(){
        row = this.position.getRow();
        row -= this.getSpeed();
    }
}