import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Main {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        
        boolean valid = true;
        while (valid){
            cls();
            System.out.println("Welcome to Plants vs Zombies!");
            System.out.println("1. Start Game");
            System.out.println("2. Scoreboard");
            System.out.println("3. Quit");

            int number = input.nextInt();

            if (number == 1){
                Game game = new Game();
                wait(1000);
                cls();

                System.out.println("Hurry up! The zombies are approaching!");
                System.out.println("Tips : Get 100 points to win the game!");
                System.out.println("Good luck!");
                wait(3000);
                cls();

                boolean playing = true;

                while (playing && !game.isGameOver() && game.getScore() < 100){
                    System.out.println("Total Score : " + game.gameScore);
                    System.out.println("Total Sunflower Points : " + game.totalSun);
                    game.backyard.printBackyard();          
                    
                    System.out.println("What do you want to do?");
                    System.out.println("SKIP to skip a few steps");
                    System.out.println("PLANT to plant");
                    System.out.println("SHOVEL to remove a plant");
                    System.out.println("EXIT to exit the game");
                    
                    String command = input.next();

                    if (command.equals("PLANT")){
                        System.out.println("Choose your plant!");
                        System.out.println("1.  (50) Sunflower");
                        System.out.println("2. (100) Peashooter");
                        System.out.println("3. (175) Snow Peashooter");
                        System.out.println("4.  (50) Walnut");
                        int noPlant = input.nextInt();
                        if (noPlant == 1){
                            System.out.println("Choose the position to plant your Sunflower!");
                            System.out.println("Example : 2 A");
                            int sx = input.nextInt();
                            String sy = input.next();
                            if (game.totalSun >= 50){
                                BackyardMaterials s = new Sunflower(sx-1, game.stringToInt(sy)-1);
                                game.plantList.add((Plants) s);
                                game.totalSun -= s.getCost();
                                game.update();
                                game.backyard.updateBackyard(game);
                            } else {
                                System.out.println("Your sunflower points are not enough!");
                            }
                            
                        } else if (noPlant == 2){
                            System.out.println("Choose the position to plant your Peashooter!");
                            System.out.println("Example : 2 A");
                            int px = input.nextInt();
                            String py = input.next();
                            if (game.totalSun >= 100){
                                BackyardMaterials p = new Peashooter(px-1, game.stringToInt(py)-1);
                                game.plantList.add((Plants) p);
                                game.totalSun -= p.getCost();
                                game.update();
                                game.backyard.updateBackyard(game);
                            } else {
                                System.out.println("Your sunflower points are not enough!");
                            }
                        } else if (noPlant == 3){
                            System.out.println("Choose the position to plant your Snow Peashooter!");
                            System.out.println("Example : 2 A");
                            int spx = input.nextInt();
                            String spy = input.next();
                            if (game.totalSun >= 175){
                                BackyardMaterials sp = new SnowPeashooter(spx - 1, game.stringToInt(spy)-1);
                                game.plantList.add((Plants) sp);
                                game.totalSun -= sp.getCost();
                                game.update();
                                game.backyard.updateBackyard(game);
                            } else {
                                System.out.println("Your sunflower points are not enough!");
                            } 
                        } else if (noPlant == 4){
                            System.out.println("Choose the position to plant your Walnut!");
                            System.out.println("Example : 2 A");
                            int wx = input.nextInt();
                            String wy = input.next();
                            if (game.totalSun >= 50){
                                BackyardMaterials w = new Walnut(wx-1, game.stringToInt(wy)-1);
                                game.plantList.add((Plants) w);
                                game.totalSun -= w.getCost();
                                game.update();
                                game.backyard.updateBackyard(game);
                            } else {
                                System.out.println("Your sunflower points are not enough!");
                            } 
                        }
                    } else if (command.equals("SKIP")){
                            game.update();
                            game.backyard.updateBackyard(game);
                    } else if (command.equals("SHOVEL")){
                        System.out.println("Which plant do you want to remove?");
                        System.out.println("Input position! Example 2 A");
                        int rx = input.nextInt();
                        String ry = input.next();
                        game.plantIter = game.plantList.iterator();
                        while (game.plantIter.hasNext()) {
                            Plants p = game.plantIter.next();
                            if (p.getRow() == rx-1 && p.getCol() == game.stringToInt(ry)-1){
                                game.plantIter.remove();
                                game.backyard.removeBackyardMaterials(game.backyard, p.getRow(), p.getCol());
                            }
                        }
                        game.update();
                        game.backyard.updateBackyard(game);
                    } else if (command.equals("EXIT")){
                        playing = false;
                    }
                    wait(1000);
                    cls();
                }
                if (game.isGameOver()){
                    System.out.println("The zombies ate your brain!");
                    System.out.println("You lose!");
                    wait(5000);
                    System.out.println("Your score : " + game.gameScore);
                    System.out.println("Input your name!");
                    String name = input.next();
                    System.out.println(name + ", your score has been added to the scoreboard!");
                    wait(5000);
                    cls();
                } else if (game.gameScore >= 100){
                    System.out.println("You defeat all the zombies!");
                    System.out.println("Congratulations! You win!");
                    wait(5000);
                    System.out.println("Your score : " + game.gameScore);
                    System.out.println("Input your name!");
                    String name = input.next();
                    System.out.println(name + ", your score has been added to the scoreboard!");
                    wait(5000);
                    cls();
                }
            } else if (number == 2){

            } else if (number == 3){
                valid = false;
            }
        }
        
    }

    public static void cls() {// ini buat clear screen
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception E) {
            System.out.println(E);
        }
    }

    public static void wait(int ms) {// ini buat real timenya nanti
        try {
            Thread.sleep(ms);
        } catch (InterruptedException E) {
            Thread.currentThread().interrupt();
        }
    }
}




