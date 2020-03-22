public class SnowPeashooter extends Plants implements Shooter{

    public SnowPeashooter(int row, int col){
        super(row, col);
        this.cost = 175;
        this.health = 25;
        this.symbol = "S";
    }

    public void shoot(){
        Bullet bulletSnowPea = new BulletSnowPea(super.position.getRow() + 1, super.position.getCol());
        bulletList.add(bulletSnowPea);
    }
}