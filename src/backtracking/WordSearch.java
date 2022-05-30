package backtracking;

public class WordSearch {

    public boolean search(char[][] board,int i, int j, String word, int idx){


        if (i == board.length || i < 0 || j < 0 || j == board[0].length || word.charAt(idx) != board[i][j]) return false;

        if (idx == word.length()-1){
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '*';
        boolean find = search(board, i+1, j, word, idx+1)||
                        search(board, i-1, j, word, idx+1)||
                        search(board, i, j+1, word, idx+1)||
                        search(board, i, j-1, word, idx+1);

        board[i][j] = temp;

        return find;
    }


    public static void main(String[] args) {

        WordSearch w = new
                WordSearch();

        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEEE";

        for (int i = 0 ; i < board.length ; i++){
            for (int j = 0 ; j < board[0].length ; j++){
                if (word.charAt(0) == board[i][j] && w.search(board, 0, 0, word, 0)){
                    System.out.println(true);
                }
            }
        }




    }


}
