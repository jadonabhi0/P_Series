package permutationAndCombination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationIII {

    public void perm(int[] array, Map<Integer, Integer> map, List<Integer> list, int idx){

        if (idx == array.length){
            System.out.println(list);
        }

        for (Integer i : map.keySet()){
            if (map.get(i)>0){
                map.put(i, map.get(i)-1);
                list.add(i);
                perm(array, map, list, idx+1);
                map.put(i, map.get(i)+1);
                list.remove(list.size()-1);
            }
        }

    }


    public static void main(String[] args) {

        int[] array = new int[]{1,1,2};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        PermutationIII p = new PermutationIII();
        p.perm(array, map, new ArrayList<>(), 0);
    }

}
