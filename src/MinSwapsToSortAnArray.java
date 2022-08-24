import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinSwapsToSortAnArray {

    public static int helper(int[] array, int count){
        List<int[]> list = new ArrayList<>();
        for (int i = 0 ; i < array.length ; i++){
            list.add(new int[]{array[i],i});
        }
//        Collections.sort(list, Integer.compare());

        return 0;
    }

    public static void main(String[] args) {

        int[] array = new int[]{4,3,6,8,9,6,2,1};
        helper(array,0);
    }

}
