public abstract class Plants {
    protected Point position;
    protected int cost;
    protected int health;
    protected ArrayList<Bullet> bulletList;
    protected String symbol;

    public Plants(int row, int col){
        this.position = new Point(row, col);
        bulletList = new ArrayList<Bullet>();
    }

    public Point getPosition() {
        return this.position;
    }

    public int getRow(){
        return this.position.getRow();
    }

    public int getCol(){
        return this.positoin.getCol();
    }

    public void setPosition(Point p) {
        this.position = p;
    }

    public void setPosition(int row, int col) {
        this.position = new Point(row, col);
    }
}