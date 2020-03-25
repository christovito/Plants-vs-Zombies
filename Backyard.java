public class Backyard {
    int row;
    int col;
    BackyardMaterials [][] backyard;

    public Backyard(int row, int col){
        this.row = row;
        this.col = col;
        this.backyard = new BackyardMaterials[row][col];
    }

    public Backyard(BackyardMaterials[][] backyard) { //buat ngeprint tampilan matrix backyard
        row = backyard.length;
        col = backyard[0].length;
        this.backyard = new BackyardMaterials[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                    this.backyard[i][j] = backyard[i][j];
            }
        }
    }

    public void printBackyard(){
        System.out.print(" ");
        for (int j = 0; j < col + 1; j++){
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (j == 0){
                    int k = i + 1;
                    System.out.print(k + "*");
                }
                if (j == col - 1){
                    System.out.print("*");
                }
                if (backyard[i][j] == null){
                    System.out.print(" ");
                } else {
                    System.out.print(backyard[i][j].symbol);
                }
                
            }
            System.out.println();
            System.out.print(" ");
            for (int j = 0; j < col + 1; j++){
                System.out.print("*");
            }   
            System.out.println();
        }
    }

    public void addBackyardMaterials(BackyardMaterials bm, int row, int col) { // buat nambahin objek backyardmaterials ke matrix backyardnya
        bm.setPosition(row, col);
        backyard[row][col] = bm;
    }

    public void removeBackyardMaterials(BackyardMaterials bm, int row, int col){// buat menghilangkan objek backyardmaterials dari matrix backyard
        bm = null;
        backyard[row][col] = null;
    }

    
}