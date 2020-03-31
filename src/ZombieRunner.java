public class ZombieRunner extends Zombie{

    public ZombieRunner(int row, int col){
        super(row, col);
        this.health = 60;
        this.speed = 2;
        this.damage = 5;
        this.symbol = "r";
    }    

    public void zombieMove(Backyard backyard, Game game){
        this.speed = 2;
        for (Zombie zombie : game.zombieList) {
            if (zombie == this){
                for (Plants plant : game.plantList) {
                    if (zombie == this) {
                        if (this.getRow() == plant.getRow() && this.getCol() == plant.getCol() + 1) {
                            this.speed = 0;
                            plant.health -= this.getDamage();
                            this.health -= plant.getDamage();
                        }
                        else if (this.getRow() == plant.getRow() && this.getCol() == plant.getCol() + 2){
                            this.speed = 1;
                        }
                    }
                }
                if (this.getCol() - 2 < 0){
                    this.speed = 1;
                }
            }          
        }
        backyard.removeBackyardMaterials(backyard, this.getRow(), this.getCol());
        this.position.col -= this.speed;
    }
}

