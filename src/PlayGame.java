public class PlayGame{
    private int totalSunflowers;
    private ArrayList<Zombie> zombieList;
    private ArrayList<Plants> plantsList;
    private ArrayList<Bullet> bulletList;
    private boolean gameOver = false;
    private Backyard backyard;
    private int gameScore;

    public PlayGame(){
        this.totalSunflowers = 200;
        this.zombieList = new ArrayList<Zombie>();
        this.plantsList = new ArrayList<Plants>();
        this.bulletList = new ArrayList<Bullet>();
        this.backyard = new Plants [5][10];
    }

    public void updateGame(){
        gameOver = false;

        ZombieNormal normal = new ZombieNormal();
        zombieList.add(normal);

        ZombieConehead conehead = new ZombieConehead();
        zombieList.add(conehead);


        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 10; j++){
                
            }
        }




    }
}