public class Matrix <T> {
    private int row;
    private int col;
    private Object [][] matrix;

    public Matrix(int row, int col){
        this.row = row;
        this.col = col;
        this.matrix = new Object[row][col];
    }

    public Matrix(Object [][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        this.matrix = new Object[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }

    public T getVal(int row, int col){
        T val = (T) matrix[row][col];
        return val;
    }

    public T setVal(int row, int col, T val){
        matrix[row][col] = val;
        return val;
    }

    public T removeVal(int row, int col){
        T val = getVal(row, col);
        matrix[row][col] = null;
        return val;
    }

    public int getCol(){
        return this.col;
    }

    public int getRow(){
        return this.row;
    }

    public void printMatrix() 
    { 
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (matrix[i][j] ==  null){
                    System.out.print(".");
                } else {
                    System.out.print(matrix[i][j]); 
                }
            }
            System.out.println();
        }              
    }     
}