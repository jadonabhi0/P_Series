import java.util.ArrayList;
import java.util.List;

public class SubsetIterative {

    public static List<List<Integer>> subset(int[] array){
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for(int i : array){
            int n = res.size();

            for(int j = 0 ; j < n ; j++){
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(i);
                res.add(temp);
            }

        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(subset(new int[]{1, 2, 3}));
    }

}
