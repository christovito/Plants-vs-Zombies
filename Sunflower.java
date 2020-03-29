public class Sunflower extends Plants{

    private int sunProductionCounter = 0;

    public Sunflower(int row, int col){
        super(row, col);
        this.symbol = "S";
        this.health = 50;
        this.cost = 50;
        this.damage = 0;
    }

    public void produceSun(Backyard backyard, Game game){
        if (this.sunProductionCounter % 3 == 0) {
            game.totalSun += 25;
        }
        sunProductionCounter++;   
    }    
}