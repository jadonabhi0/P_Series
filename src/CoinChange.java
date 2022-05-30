import java.util.LinkedList;
import java.util.List;

public class CoinChange {

    public static int coinChange(int[] array , int amount, List<Integer> list, int m){
        if (amount < 0){
            return 0;
        }
         if (amount == 0 && list.size() < m){
             m = list.size();
             return m;
         }
        for (int i = 0 ; i < array.length ; i++){
            list.add(array[i]);
            coinChange(array, amount-array[i], list, m);
            list.remove(list.size());
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11, new LinkedList<>(), Integer.MAX_VALUE));
    }
}
