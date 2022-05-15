import java.util.LinkedList;
import java.util.List;

public class SubsetII {

    public static List<List<Integer>> subset(int[] array, int pos, List<Integer> list, List<List<Integer>> ans){
//        if (pos == array.length){
//            return ans;
//        }
        ans.add(new LinkedList<>(list));

        for (int i = pos ; i < array.length ; i++){
            if(i > pos && array[i] == array[i-1]) continue;
            list.add(array[i]);
            subset(array, i+1, list, ans);
            list.remove(list.size()-1);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(subset(new int[]{1,4,4,4,4}, 0, new LinkedList<>(), new LinkedList<>()));
    }



}
