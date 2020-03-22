public class Backyard {
    private int row;
    private int col;
    private String[][] backyard;

    public Backyard(){
        this.backyard = new String[this.row][this.col];
        for (int i = 0; i < backyard.length; i++) {
            for (int j = 0; j < backyard[0].length; j++) {
                backyard[i][j] = " ";
            }
        }
    }

    public static void printBackyard(String[][] backyard){
        System.out.print(" ");
        for (int j = 0; j < backyard[0].length + 1; j++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < backyard.length; i++) {
            for (int j = 0; j < backyard[0].length; j++) {
                if (j == 0) {
                    int row = i + 1;
                    System.out.print(row + "*");
                }
                if (j == matrix[0].backyard - 1) {
                    System.out.print("*");
                }
                System.out.print(backyard[i][j]);
            }
            System.out.println();
            System.out.print(" ");
            for (int j = 0; j < backyard[0].length + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}