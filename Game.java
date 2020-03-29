import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Random;

public class Game {
    public int totalSun;
    public int gameScore;
    public int gameTurn = 1;
    Backyard backyard;
    ArrayList<Zombie> zombieList;
    ArrayList<Plants> plantList;
    ArrayList<Bullet> bulletList;
    Iterator<Bullet> bullIter;
    Iterator<Zombie> zombieIter;
    Iterator<Plants> plantIter;

    public Game() {
        this.totalSun = 150;
        this.gameScore = 0;
        backyard = new Backyard(5,50);
        zombieList = new ArrayList<>();
        plantList = new ArrayList<>();
        bulletList = new ArrayList<>();
    }

    public void update() {
        this.gameTurn += 1;

        Random random = new Random();
        int maxLane = 5; // 0, 1, 2, 3, 4
        int maxZombie = 3; // 0, 1, 2
        int randomZombie = random.nextInt(maxZombie);
        int randomLane = random.nextInt(maxLane);
        if (this.gameTurn > 4 && this.gameTurn % 4 == 0){
            if (randomZombie == 0){
                BackyardMaterials zn = new ZombieNormal(randomLane, 48);
                zombieList.add((Zombie) zn);
            } else if (randomZombie == 1){
                BackyardMaterials zc = new ZombieConehead(randomLane, 48);
                zombieList.add((Zombie) zc);
            } else if (randomZombie == 2) {
                BackyardMaterials zr = new ZombieRunner(randomLane, 48);
                zombieList.add((Zombie) zr);
            }
        }

        for (Plants plant : plantList) {
            if (plant instanceof Shooter){
                if (isZombieOnLane(plant.getRow(), plant.getCol())){
                    plant.shoot(backyard,this);
                }     
            } else if (plant instanceof Sunflower){
                plant.produceSun(backyard, this);
            }   
        }
        
        bullIter = bulletList.iterator();
        while (bullIter.hasNext()) {
            Bullet b = bullIter.next();
            if (b.getCol() >= 48) {
                bullIter.remove();
                backyard.removeBackyardMaterials(backyard, b.getRow(), b.getCol());
            }
            for (Zombie zombie : zombieList) {
                if (b.getRow() == zombie.getRow() && b.getCol() == zombie.getCol()+1) {
                    zombie.health -= b.getDamage();
                    bullIter.remove();
                    backyard.removeBackyardMaterials(backyard, b.getRow(), b.getCol());
                }
                if (b.getRow() == zombie.getRow() && b.getCol() == zombie.getCol()){
                    zombie.health -= b.getDamage();
                    backyard.removeBackyardMaterials(backyard, b.getRow(), b.getCol()+1);
                }
            }
            b.bulletMove(backyard, this);                
        }
            
        for (Zombie z : zombieList){
            z.zombieMove(backyard, this);
        }

        plantIter = plantList.iterator();
        while (plantIter.hasNext()) {
            Plants p = plantIter.next();
            if (p.health <= 0){
                plantIter.remove();
                backyard.removeBackyardMaterials(backyard, p.getRow(), p.getCol());
            }
        }

        zombieIter = zombieList.iterator();
        while (zombieIter.hasNext()) {
            Zombie z = zombieIter.next();
            if (z.health <= 0) {
                zombieIter.remove();
                backyard.removeBackyardMaterials(backyard, z.getRow(), z.getCol());
                this.gameScore += 10;
            }
        }    
    }
         
    public void clearBackyard(){
        zombieIter = zombieList.iterator();
        while (zombieIter.hasNext()) {
            zombieIter.remove();
        }

        plantIter = plantList.iterator();
        while (plantIter.hasNext()) {
            plantIter.remove();
        }

        bullIter = bulletList.iterator();
        while (bullIter.hasNext()) {
            bullIter.remove();
        }
    }

    public boolean isZombieOnLane(int lane, int col){
        for (Zombie zombie : zombieList){
            if (zombie.getRow() == lane && zombie.getCol() >= col){
                return true;
            }
        }
        return false;
    }

    public boolean isGameOver(){
        for (Zombie zombie : zombieList){
            if (zombie.getCol() == 0){
                return true;
            } 
        }
        return false;
    }

    public ArrayList<Zombie> getZombieList(){
        return this.zombieList;
    }

    public ArrayList<Plants> getPlantList(){
        return this.plantList;
    }

    public ArrayList<Bullet> getBulletList() {
        return this.bulletList;
    }

    public int getScore(){
        return this.gameScore;
    }

    public int getTotalSun(){
        return this.totalSun;
    }

    public int getGameTurn(){
        return this.gameTurn;
    }
}

