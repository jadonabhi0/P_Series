public class ShortestPathinBinarMatrix {

    public static int path(int[][] board, int i, int j, int path, int min){

        if (i >= board.length || j >= board[0].length || i < 0 || j < 0){
            return 0;
        }

        if (i == board.length-1 && j == board[0].length-1){
            if(path < min){
                min = path;
            }
            return min;
        }

        if (board[i][j] == 1){
            return 0;
        }

        path(board, i+1, j, path+1, min);
        path(board, i-1, j, path+1, min);
        path(board, i, j+1, path+1, min);
        path(board, i, j-1, path+1, min);
//        path(board, i-1, j-1, path+1, min);
//        path(board, i+1, j+1, path+1, min);
//        path(board, i-1, j+1, path+1, min);
//        path(board, i+1, j-1, path+1, min);
        return min;
    }


    public static void main(String[] args) {
        int[][] array ={{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(path(array, 0, 0, 0, Integer.MAX_VALUE));

    }


}
