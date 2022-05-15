import java.util.HashMap;

public class UniquePathII {

    public static int path(int[][] board, int i, int j, HashMap<String ,Integer> map){
        String key = i+"x"+j;
        if (map.containsKey(key)){
            return map.get(key);
        }

        if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == 1){
            return 0;
        }
        if(i == board.length-1 && j == board[0].length-1){
            return 1;
        }
        int a = path(board, i+1, j, map) ;
        int b = path(board, i, j+1, map);
        map.put(key,a+b);
        return a+b;
    }



    public static int solve (int[][] arr, int sr, int sc) {
        if ( sr == arr.length || sc == arr[0].length || arr[sr][sc] == 1) {
            return 0;
        }


        if (sr == arr.length - 1 && sc == arr[0].length - 1) {
            return 1;
        }
        return solve(arr, sr + 1, sc) + solve(arr, sr, sc + 1);
    }


    public static void main(String[] args) {
        int[][] ar = new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        HashMap<String, Integer> map = new HashMap<>();
        System.out.println(path(ar, 0, 0, map));
        System.out.println(solve(ar, 0, 0));
    }
}
