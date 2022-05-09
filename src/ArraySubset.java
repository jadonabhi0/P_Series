import javax.swing.*;
import java.util.*;

public class ArraySubset {

    public Set<List<Integer>> generateSubset(int[] array, int idx,List<Integer> list, Set<List<Integer>> ans){
        if(array.length == idx){
           ans.add(new ArrayList<>(list));
            return  ans;
        }

        generateSubset(array, idx+1, list,ans);
        list.add(array[idx]);
        generateSubset(array, idx+1, list, ans);
        list.remove(list.size()-1);
        return ans;
    }


    public static void main(String[] args) {
        ArraySubset subset = new ArraySubset();
        System.out.println(subset.generateSubset(new int[]{4,4,4,1,4}, 0,new ArrayList<>(), new HashSet<>()));

    }
}
