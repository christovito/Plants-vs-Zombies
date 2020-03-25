public class ZombieNormal extends Zombie{

    public ZombieNormal(int row, int col){
        super(row, col);
        this.health = 60;
        this.speed = 1;
        this.damage = 5;
        this.symbol = "Z";
    }    

    public void zombieMove(Backyard backyard){
        this.speed = 1;
        backyard.removeBackyardMaterials(this, this.getRow(), this.getCol());
    
        for (int i = 0; i < backyard.backyard.length; i++) {
            for (int j = 0; j < backyard.backyard[0].length; j++) {
                if (backyard.backyard[i][j] instanceof Plants) {
                    if (this.getRow() == i && this.getCol() == j + 1) {
                        this.speed = 0;
                        backyard.backyard[i][j].health -= this.damage;
                    }
                }
            }
        }
        //backyard.removeBackyardMaterials(this.getRow(), this.getCol());
        this.position.col -= this.getSpeed();
        backyard.addBackyardMaterials(this, this.getRow(), this.getCol());
    }
}