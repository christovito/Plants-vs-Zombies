public class ZombieConehead extends Zombie{

    public ZombieConehead(int row, int col){
        super(row, col);
        this.health = 100;
        this.speed = 1;
        this.damage = 10;
        this.symbol = "c";
    }

    public void zombieMove(Backyard backyard, Game game) {
        this.speed = 1;
        for (Zombie zombie : game.zombieList) {
            if (zombie == this){
                for (Plants plant : game.plantList) {
                    if (zombie == this) {
                        if (this.getRow() == plant.getRow() && this.getCol() == plant.getCol() + 1) {
                            this.speed = 0;
                            plant.health -= this.getDamage();
                            this.health -= plant.getDamage();
                        }
                    }
                }
            }          
        }
        backyard.removeBackyardMaterials(backyard, this.getRow(), this.getCol());
        this.position.col -= this.speed;
    }
}