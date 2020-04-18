import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
import java.util.Random;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GameBoard extends JPanel implements Runnable, MouseListener, MouseMotionListener {
    
    private final int PANEL_WIDTH = 800;
    private final int PANEL_HEIGHT = 600;
    private final int DELAY = 25;
    private final long ZOMBIE_DELAY = 25000;
    private final long SUN_DELAY = 10000;
    private final int ZOMBIE_TO_BEAT = 15;
    private long zombieCreated;
    private long sunCreated;
    private int totalSun = 50;
    private int deadZombie = 0;
    private int zombieCounter = 0;
    private ArrayList<Plant> plantList;
    private ArrayList<Zombie> zombieList;
    protected ArrayList<Bullet> bulletList;
    protected ArrayList<SunflowerPoint> sunList;
    private ArrayList<Plant> plantListRemove;
    private ArrayList<Zombie> zombieListRemove;
    private ArrayList<Bullet> bulletListRemove;
    private ArrayList<SunflowerPoint> sunListRemove;
    private Thread thread;
    private int xMouseStart;
    private int yMouseStart;
    private int xMouseEnd;
    private int yMouseEnd;
    private boolean drag;
    private int clickedButton = -1;

    public GameBoard() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setLayout(null);
        setOpaque(false);
        setVisible(true);
        addMouseListener(this);
        addMouseMotionListener(this);

        plantList = new ArrayList<>();
        zombieList = new ArrayList<>();
        sunList = new ArrayList<>();
        bulletList = new ArrayList<>();

        plantListRemove = new ArrayList<>();
        zombieListRemove = new ArrayList<>();
        sunListRemove = new ArrayList<>();
        bulletListRemove = new ArrayList<>();

        zombieCreated = System.currentTimeMillis();
        sunCreated = System.currentTimeMillis();
    }

    public void createZombie(){
        long currentTime = System.currentTimeMillis();

        Random random = new Random();
        int maxLane = 5;
        int maxZombie = 3;
        int randomZombie = random.nextInt(maxZombie);
        int randomLane = random.nextInt(maxLane);

        if (this.zombieCounter < ZOMBIE_TO_BEAT && currentTime - zombieCreated >= ZOMBIE_DELAY) {
            this.zombieCounter += 1;
            zombieCreated = currentTime;
            if (randomZombie == 0) {
                Zombie zombie = new ZombieNormal(900, convertLane(randomLane));
                zombieList.add(zombie);
            } else if (randomZombie == 1) {
                Zombie zombie = new ZombieConehead(900, convertLane(randomLane));
                zombieList.add(zombie);
            } else if (randomZombie == 2) {
                Zombie zombie = new ZombieNewspaper(900, convertLane(randomLane));
                zombieList.add(zombie);
            }
        }  
    }

    public void createSun(){
        long currentTime = System.currentTimeMillis();

        Random random = new Random();
        int maxCol = 9;
        int randomCol = random.nextInt(maxCol);

        if ((currentTime - sunCreated >= SUN_DELAY)) {
            sunCreated = currentTime;
            SunflowerPoint sun = new SunflowerPoint(convertCol(randomCol), 80, true);
            sunList.add(sun);
        }
    }

    public void resumeGame(){
        for (Bullet bullet : bulletList) {
            if (bullet.getX() >= PANEL_WIDTH) {
                bulletListRemove.add(bullet);
            }
            for (Zombie zombie : zombieList){
                if (zombie.getX() - bullet.getX() <= 50 && zombie.getY() == bullet.getY()){
                    zombie.health -= bullet.getDamage();
                    bulletListRemove.add(bullet);
                }
            }
        }
       
        for (Zombie zombie : zombieList) {
            for (Plant plant : plantList) {
                if (zombie.getX() - plant.getX() <= 50 && zombie.getY() == plant.getY()){
                    zombie.moving = false;
                    plant.health -= zombie.getDamage();
                    if (plant.health <= 0){
                        plantListRemove.add(plant);
                        zombie.moving = true;
                    }
                }
            }
        }

        for (Zombie zombie : zombieList){
            if (zombie.health <= 0) {
                zombieListRemove.add(zombie);
                this.deadZombie += 1;
            }        
        }

        for (SunflowerPoint sun : sunList){
            if (System.currentTimeMillis() - sun.getTimeAppear() >= sun.getSunDuration()){
                sunListRemove.add(sun);
            }
        }

        for (Plant plant : plantList){
            if (plant.getX() < 42 && plant.getX() > 766 && plant.getY() < 84 && plant.getY() > 564){
                plantListRemove.add(plant);
            }
        }

        bulletList.removeAll(bulletListRemove);
        zombieList.removeAll(zombieListRemove);
        plantList.removeAll(plantListRemove);
        sunList.removeAll(sunListRemove);
    }

    public void act(){
        for (int i = 0; i < zombieList.size(); i++) {
            zombieList.get(i).act(this);
        }

        for (int i = 0; i < plantList.size(); i++) {
            plantList.get(i).act(this);
        }

        for (int i = 0; i < bulletList.size(); i++) {
            bulletList.get(i).act(this);
        }

        for (int i = 0; i < sunList.size(); i++) {
            sunList.get(i).act(this);
        }
    }

    public void update() {
        createZombie();
        createSun();
        resumeGame();
        act(); 
    }
    
    private void gameOver(Graphics g) {
        g.setColor(new Color(0, 32, 48));
        g.fillRect(200, 250, 400, 100);
        g.setColor(new Color(232, 234, 171));
        g.drawRect(200, 250, 400, 100);
        Font font = new Font("MS PGothic", Font.BOLD, 40);
        g.setColor(new Color(232, 234, 171));
        g.setFont(font);
        g.drawString("GAME OVER", 280, 315);
    }

    private void winGame(Graphics g) {
        g.setColor(new Color(0, 32, 48));
        g.fillRect(150, 250, 500, 100);
        g.setColor(new Color(232, 234, 171));
        g.drawRect(150, 250, 500, 100);
        Font font = new Font("MS PGothic", Font.BOLD, 40);
        g.setColor(new Color(232, 234, 171));
        g.setFont(font);
        g.drawString("CONGRATULATIONS!", 197, 315);
    }

    private int convertLane(int y){
        if (y == 0){
            return 90;
        } else if (y == 1){
            return 178;
        } else if (y == 2){
            return 276;
        } else if (y == 3){
            return 378;
        } else if (y == 4){
            return 470;
        }
        return -1;
    }

    private int convertCol(int x){
        if (x == 0){
            return 50;
        } else if (x == 1){
            return 124;
        } else if (x == 2){
            return 208;
        } else if (x == 3){
            return 292;
        } else if (x == 4){
            return 368;
        } else if (x == 5){
            return 450;
        } else if (x == 6){
            return 530;
        } else if (x == 7){
            return 608;
        } else if (x == 8){
            return 688;
        }
        return -1;
    }

    private int convertMouseLane(int y){
        if (y >= 84 && y <= 172){
            return 90;
        } else if (y > 172 && y <= 270){
            return 178;
        } else if (y > 270 && y <= 372){
            return 276;
        } else if (y > 372 && y <= 460){
            return 378;
        } else if (y > 460 && y <= 564){
            return 470;
        }
        return -100;
    }

    private int convertMouseCol(int x){
        if (x >= 42 && x <= 116){
            return 50;
        } else if (x > 116 && x <= 200){
            return 124;
        } else if (x > 200 && x <= 284){
            return 208;
        } else if (x > 284 && x <= 360){
            return 292;
        } else if (x > 360 && x <= 442){
            return 368;
        } else if (x > 442 && x <= 522){
            return 450;
        } else if (x > 522 && x <= 600){
            return 530;
        } else if (x > 600 && x <= 680){
            return 608;
        } else if (x > 688 && x <= 766){
            return 688;
        }
        return -100;
    }

    public boolean isZombieOnLane(int col, int lane){
        for (int i = 0; i < zombieList.size(); i++) {
            if (zombieList.get(i).getY() == lane && zombieList.get(i).getX() > col ){
                return true;
            }
        }
        return false;
    }

    private boolean isWinning(){
        return (this.deadZombie == ZOMBIE_TO_BEAT);
    }

    private boolean isGameOver(){
        for (int i = 0; i < zombieList.size(); i++) {
            if (zombieList.get(i).getX() <= -100) {
                return true;
            }
        }
        return false;
    }

    private boolean isEmptyBlock(int x, int y){
        for (int i = 0; i < plantList.size(); i++) {
            if (plantList.get(i).getX() == x && plantList.get(i).getY() == y) {
                return false;
            }
        }
        return true;
    }

    private boolean isMouseDragging(){
        return (this.xMouseStart != this.xMouseEnd && this.yMouseStart != this.yMouseEnd);
    }

    @Override
    public void addNotify(){
        super.addNotify();
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void paintComponent(Graphics g){
        writeSunflowerPoints(g);
        drawPlant(g);
        drawZombie(g);
        drawSun(g);
        drawBullet(g);
        if (isGameOver()) {
            gameOver(g);
        } else if (isWinning()) {
            winGame(g);
        }
        g.dispose();
    }

    @Override
    public void run() {
        try {
            long beforeTime, timeDiff, sleep;
            beforeTime = System.currentTimeMillis();

            while (!isGameOver() && !isWinning()) {
                update();

                timeDiff = System.currentTimeMillis() - beforeTime;
                sleep = DELAY - timeDiff;

                if (sleep < 0) {
                    sleep = 1;
                }
                    
                Thread.sleep(sleep);

                beforeTime = System.currentTimeMillis();
                repaint();
            }
        } catch (InterruptedException e) {
        } catch (ConcurrentModificationException e){
        }
    }

    private void drawPlant(Graphics g){
        for (int i = 0; i < plantList.size(); i++) {
            g.drawImage(plantList.get(i).getImage(), plantList.get(i).getX(), plantList.get(i).getY(), this);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawZombie(Graphics g) {
        for(int i = 0; i < zombieList.size(); i++){
            g.drawImage(zombieList.get(i).getImage(), zombieList.get(i).getX(), zombieList.get(i).getY() - 40, this);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawSun(Graphics g) {
        for (int i = 0; i < sunList.size(); i++) {
            g.drawImage(sunList.get(i).getImage(), sunList.get(i).getX(), sunList.get(i).getY(), this);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawBullet(Graphics g){
        for (int i = 0; i < bulletList.size(); i++) {
            g.drawImage(bulletList.get(i).getImage(), bulletList.get(i).getX(), bulletList.get(i).getY(), this);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    private void writeSunflowerPoints(Graphics g) {

        Font font = new Font("MS PGothic", Font.BOLD, 16);
        String totalSunString = Integer.toString(this.totalSun);
        g.setColor(Color.black);
        g.setFont(font);
        if (this.totalSun < 10) {
            g.drawString(totalSunString, 52, 75);
        } else if (this.totalSun >= 10 && this.totalSun < 100) {
            g.drawString(totalSunString, 48, 75);
        } else if (this.totalSun >= 100 && this.totalSun < 1000) {
            g.drawString(totalSunString, 42, 75);
        } else if (this.totalSun >= 1000) {
            g.drawString(totalSunString, 37, 75);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.xMouseStart = e.getX();
        this.yMouseStart = e.getY();

        for (SunflowerPoint sun : sunList){
            if ((xMouseStart <= sun.getX() + 50 && xMouseStart >= sun.getX() - 50) && (yMouseStart <= sun.getY() + 50 && yMouseStart >= sun.getY() - 50)){
                this.totalSun += 25;
                sunListRemove.add(sun);
            }
        }
        sunList.removeAll(sunListRemove);

        if (xMouseStart >= 94 && xMouseStart <= 138 && yMouseStart >= 5 && yMouseStart <= 72) {
            this.clickedButton = 1;
            this.drag = true;
        } else if (xMouseStart >= 144 && xMouseStart <= 188 && yMouseStart >= 5 && yMouseStart <= 72) {
            this.clickedButton = 2;
            this.drag = true;
        } else if (xMouseStart >= 194 && xMouseStart <= 238 && yMouseStart >= 5 && yMouseStart <= 72) {
            this.clickedButton = 3;
            this.drag = true;
        } else if (xMouseStart >= 244 && xMouseStart <= 288 && yMouseStart >= 5 && yMouseStart <= 72) {
            this.clickedButton = 4;
            this.drag = true;
        } else if (xMouseStart >= 462 && xMouseStart <= 526 && yMouseStart >= 5 && yMouseStart <= 67) {
            this.clickedButton = 5;
            this.drag = true;
        }     
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.xMouseEnd = e.getX();
        this.yMouseEnd = e.getY();

        if (isEmptyBlock(convertMouseCol(this.xMouseEnd), convertMouseLane(this.yMouseEnd)) && isMouseDragging()){
            if (this.clickedButton == 1 && this.totalSun >= 50) {
                Plant sunflower = new Sunflower(convertMouseCol(this.xMouseEnd), convertMouseLane(this.yMouseEnd));
                plantList.add(sunflower);
                this.totalSun -= sunflower.getCost();
            } else if (this.clickedButton == 2 && this.totalSun >= 100) {
                Plant pea = new Peashooter(convertMouseCol(this.xMouseEnd), convertMouseLane(this.yMouseEnd));
                plantList.add(pea);
                this.totalSun -= pea.getCost();
            } else if (this.clickedButton == 3 && this.totalSun >= 175) {
                Plant snowpea = new SnowPeashooter(convertMouseCol(this.xMouseEnd), convertMouseLane(this.yMouseEnd));
                plantList.add(snowpea);
                this.totalSun -= snowpea.getCost();
            } else if (this.clickedButton == 4 && this.totalSun >= 50) {
                Plant walnut = new Walnut(convertMouseCol(this.xMouseEnd), convertMouseLane(this.yMouseEnd));
                plantList.add(walnut);
                this.totalSun -= walnut.getCost();
            }
        }
        if (!isEmptyBlock(convertMouseCol(this.xMouseEnd), convertMouseLane(this.yMouseEnd)) && isMouseDragging()){
            if (this.clickedButton == 5) {
                for (Plant plant : plantList) {
                    if (plant.getX() == convertMouseCol(this.xMouseEnd) && plant.getY() == convertMouseLane(this.yMouseEnd)) {
                        plant.removed = true;
                        plantListRemove.add(plant);
                    }
                }
                plantList.removeAll(plantListRemove);
            }
        }
        this.clickedButton = -1;
        this.drag = false;  
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (drag) {
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}