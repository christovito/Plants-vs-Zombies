public class ZombieConehead extends Zombie{

    public ZombieConehead(int row, int col){
        super(row, col);
        this.health = 100;
        this.speed = 4;
        this.damage = 5;
        this.symbol = "C";
    }

    // SEJAUH INI UDAH BERHASIL
    public void zombieMove(Backyard backyard) {
        this.speed = 4; // kita ngeset dulu speed

        for (int i = 0; i < backyard.backyard.length; i++) {
            for (int j = 0; j < backyard.backyard[0].length; j++) {
                if (backyard.backyard[i][j] instanceof Plants) { // kalo di depannya persis ada taneman
                    if (this.getRow() == i && this.getCol() == j + 1) {
                        this.speed = 0; // dia bakal berhenti untuk makan
                        backyard.backyard[i][j].health -= this.damage; // health taneman berkurang
                    }
                }

                }
            }
        backyard.removeBackyardMaterials(this, this.getRow(), this.getCol()); // ini ceritanya sama kaya yang bullet "-"
        this.position.col -= this.getSpeed(); // dia geraknya berdasarkan speed masing-masing
        backyard.addBackyardMaterials(this, this.getRow(), this.getCol());
    }
}