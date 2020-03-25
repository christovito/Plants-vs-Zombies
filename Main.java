import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        Backyard backyard = new Backyard(5, 50); // menciptakan matrix backyard, ukurannya 5x50
        backyard.printBackyard();// print matrix backyard

        System.out.println("Welcome to Plants vs Zombies!");
        System.out.println("Type START to Start the Game!");
        String start = input.next();
        //long startTime = System.nanoTime();
        boolean running = true;
        boolean playing = true;

        while(running){

            if (start.equals("START")){
            wait(1000);
            cls();
            //long zombieCome = System.nanoTime();
            ArrayList<BackyardMaterials> zombieList = new ArrayList<BackyardMaterials>();
            //ArrayList<BackyardMaterials> bulletList = new ArrayList<BackyardMaterials>();
            BackyardMaterials zn = new ZombieNormal(2, 10); // menciptakan objek zombie normal di posisi x,y pada matrix backyard
            backyard.addBackyardMaterials(zn, 2, 10);
            zombieList.add(zn);

            while (playing){

                backyard.printBackyard();

                System.out.println("SKIP for Skipping");
                System.out.println("P for Peashooter");
                System.out.println("S for SnowPeashooter");
                System.out.println("Input the position of the plants!");
                System.out.println("Example : P 2 3");
                String no = input.next();
                
                if (no.equals("P")) { // kalo input P, dia bikin objek Peashooter di posisi x,y pada matrix
                    int x = input.nextInt();
                    int y = input.nextInt();
                    BackyardMaterials ps = new Peashooter(x-1, y-1);
                    backyard.addBackyardMaterials(ps, x-1, y-1);  
                } else if (no.equals("S")){ // kalo input S, dia bikin objek Snow Peashooter di posisi x,y pada matrix
                    int x = input.nextInt();
                    int y = input.nextInt();
                    BackyardMaterials sp = new SnowPeashooter(x-1, y-1);
                    backyard.addBackyardMaterials(sp, x-1, y-1);
                } else if (no.equals("SKIP")){ // setiap kali input SKIP, maka semua entitas akan jalan SATU LANGKAH

                    // INI BELUM BERHASIL NEMBAK TERUS MENERUS TANEMANNYA
                    for (int i = 0; i < backyard.backyard.length; i++) {
                        for (int j = 0; j < backyard.backyard[0].length; j++) {
                            if (backyard.backyard[i][j] instanceof Plants) { // kalo di matrix dia adalah taneman, dia bakal nembak peluru 1 kali
                                backyard.backyard[i][j].shoot(backyard);
                            } 
                            if (backyard.backyard[i][j] instanceof Zombie) { // kalo di matrix dia adalah zombie, dia bakal move
                                backyard.backyard[i][j].zombieMove(backyard);
                            }
                            if (backyard.backyard[i][j] instanceof Plants || backyard.backyard[i][j] instanceof Zombie) { // kalo dia taneman dan zombie, kalo healthnya <=0 maka dia mati, akan diremove dari matrix
                                if (backyard.backyard[i][j].health <= 0) {
                                    backyard.removeBackyardMaterials(backyard.backyard[i][j],i, j);
                                }
                            }
                        }
                    }
                }
                //System.out.println(zn.health);
                //System.out.println(zn.getCol());
                //System.out.println(zn.getRow());
                wait(1000);
                cls();
                }
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




