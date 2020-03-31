public class Zombie extends BackyardMaterials {
    protected int counter;
    protected boolean move = true;
    protected boolean stopedByAnother = false;

    public Zombie(int row, int col){
        super(row, col);
        this.cost = 0;
    }

    public void zombieMove(Backyard backyard, Game game) {
    }
        
}