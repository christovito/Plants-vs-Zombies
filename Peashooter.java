public class Peashooter extends Plants implements Shooter {
    
    public Peashooter(int row, int col) {
        super(row, col);
        this.cost = 100;
        this.health = 20;
        this.symbol = "P";
    }

    public void shoot(){
        Bullet bulletPea = new BulletPea(super.position.getRow() + 1, super.position.getCol());
        bulletList.add(bulletPea);
    }
}