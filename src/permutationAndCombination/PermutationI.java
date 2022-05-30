package permutationAndCombination;

import java.util.ArrayList;
import java.util.List;

public class PermutationI {

    public void perm(int[] array, int idx, List<Integer> list, boolean[] vis){

        if (idx == array.length){
            System.out.println(list);
            return;
        }

        for (int i = 0 ; i < array.length ; i++){
            if (vis[i]) continue;
            vis[i] = true;
            list.add(array[i]);
            perm(array ,idx+1, list,vis);
            list.remove(list.size()-1);
            vis[i] = false;
        }


    }


    public static void main(String[] args) {

        PermutationI p = new PermutationI();
        int[] array = new int[]{1,2,3};
        boolean[] vis = new boolean[array.length];
        p.perm(array, 0, new ArrayList<>(),vis);
    }


}
