package permutationAndCombination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {


    public static void helper(int[] array, List<List<Integer>> ans, List<Integer> list, int tar, int s){
        if (tar == 0){
            ans.add(new LinkedList<Integer>(list));
            return;
        }
        if (tar < 0) return;

        for (int i = s ; i < array.length ; i++){
            if (i > s && array[i] == array[i-1]){
                continue;
            }
            else {
                list.add(array[i]);
                helper(array, ans, list, tar-array[i],i+1);
                list.remove(list.size()-1);
            }
        }

    }


    public static void main(String[] args) {
        int[] ar = {2,5,2,1,2};
        Arrays.sort(ar);
        List<List<Integer>> ans = new ArrayList<>();
        helper(ar, ans, new LinkedList<>(), 5,0);
        System.out.println(ans);
    }
}
