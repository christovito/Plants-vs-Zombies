public abstract class Zombie extends BackyardMaterials {
    //protected int health;
    //protected int speed;
    //protected int zombieDamage;

    public Zombie(int row, int col){
        super(row, col);
    }

    public int getSpeed(){
        return this.speed;
    }

    public int getRow(){
        return this.position.row;
    }

    public int getCol(){
        return this.position.col;
    }

    public Point getPosition() {
        return this.position;
    }

    public int getHealth() {
        return this.health;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setPosition(Point p) {
        this.position = p;
    }

    public void setPosition(int row, int col) {
        this.position = new Point(row, col);
    }

    public void setSpeed(Backyard backyard){
    }

    public void zombieMove(Backyard backyard) {
    }

}