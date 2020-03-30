public abstract class BackyardMaterials {
    protected Point position;
    protected String symbol;
    protected int health;
    protected int speed;
    protected int cost;
    protected int damage;

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
          if (this.symbol ==  null){
            return " "; 
        } else {
            return this.symbol;
        }
    }

    public int getHealth(){
        return this.health ;
    }

    public int getSpeed(){
        return this.speed ;
    }

    public int getCost(){
        return this.cost ;
    }

    public int getDamage(){
        return this.damage ;
    }

    public void setPosition(Point p) {
        this.position = p;
    }

    public void setPosition(int row, int col) {
        this.position = new Point(row, col);
    }
    
}