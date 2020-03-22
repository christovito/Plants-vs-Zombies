public class Bullet{
    protected Point position;
    protected int bulletDamage;

    public Bullet(int row, int col){
        this.position = new Point(row, col);
    }

    public void bulletMove(){
        int row = this.position.getRow();
        row += 1;
    }
}

