import javax.naming.PartialResultException;

public class UniquePaths {

    public static int unique(int[][] board, int i, int j){

        if (i < 0 || j < 0){
            return 0;
        }
         else if (i == 0 && j == 0){
             return 1;
         }

         else {
            return unique(board, i-1, j)+unique(board, i, j-1);
        }


    }

    public static void main(String[] args) {
        System.out.println(unique(new int[3][7], 3-1, 7-1));
    }

}
