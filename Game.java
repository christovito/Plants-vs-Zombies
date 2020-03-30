import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Random;

public class Game {
    public int totalSun = 150;
    public int gameScore = 0;
    public int gameTurn = 0;
    Backyard backyard;
    ArrayList<Zombie> zombieList;
    ArrayList<Plants> plantList;
    ArrayList<Bullet> bulletList;
    Iterator<Bullet> bullIter;
    Iterator<Zombie> zombieIter;
    Iterator<Plants> plantIter;

    public Game() {
        backyard = new Backyard(5,27);
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
                BackyardMaterials zn = new ZombieNormal(randomLane, 26);
                zombieList.add((Zombie) zn);
            } else if (randomZombie == 1){
                BackyardMaterials zc = new ZombieConehead(randomLane, 26);
                zombieList.add((Zombie) zc);
            } else if (randomZombie == 2) {
                BackyardMaterials zr = new ZombieRunner(randomLane, 26);
                zombieList.add((Zombie) zr);
            }
        }

        if (this.gameTurn > 3 && this.gameTurn % 3 == 0){
            this.totalSun += 25;
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
            if (b.getCol() >= 25) {
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
                    bullIter.remove();
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

    public int stringToInt(String input){
        if (input.equals("A")){
            return 1;
        } else if (input.equals("B")){
            return 2;
        } else if (input.equals("C")){
            return 3;
        } else if (input.equals("D")){
            return 4;
        } else if (input.equals("E")){
            return 5;
        } else if (input.equals("F")){
            return 6;
        } else if (input.equals("G")){
            return 7;
        } else if (input.equals("H")){
            return 8;
        } else if (input.equals("I")){
            return 9;
        } else if (input.equals("J")){
            return 10;
        } else if (input.equals("K")){
            return 11;
        } else if (input.equals("L")){
            return 12;
        } else if (input.equals("M")){
            return 13;
        } else if (input.equals("N")){
            return 14;
        } else if (input.equals("O")){
            return 15;
        } else if (input.equals("P")){
            return 16;
        } else if (input.equals("Q")){
            return 17;
        } else if (input.equals("R")){
            return 18;
        } else if (input.equals("S")){
            return 19;
        } else if (input.equals("T")){
            return 20;
        } else if (input.equals("U")){
            return 21;
        } else if (input.equals("V")){
            return 22;
        } else if (input.equals("W")){
            return 23;
        } else if (input.equals("X")){
            return 24;
        } else if (input.equals("Y")){
            return 25;
        } else if (input.equals("Z")){
            return 26;
        }
        return -1;
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

