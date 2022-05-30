package permutationAndCombination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {

    public static void helper(List<List<Integer>> ans, List<Integer> list, int n, int k, int idx){
        if(list.size() == k && n == 0){
            ans.add(new LinkedList<>(list));
            return;
        }
        for (int i = idx ;i <= 9 ;i++){
            list.add(i);
            helper(ans, list, n-i, k, i+1);
            list.remove(list.size()-1);

        }

    }


    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list,new LinkedList<>(),7, 3, 1 );
        System.out.println(list);
    }


}
