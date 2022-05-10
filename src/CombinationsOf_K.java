import java.util.LinkedList;
import java.util.List;

public class CombinationsOf_K {

    public static List<List<Integer>> comb(int n,  int k, List<Integer> list, List<List<Integer>> ans){
      if(n == 0){
          if (list.size() == k){
              ans.add(new LinkedList<>(list));
          }
          return ans;
      }
      comb(n-1, k, list, ans);
      list.add(n);
      comb(n-1, k, list, ans);
      list.remove(list.size()-1);
      return ans;
    }

    public static void main(String[] args) {
        int n = 4;

        List<List<Integer>> ans = new LinkedList<>();
        ans = comb(4,2, new LinkedList<>(), ans);
        System.out.println(ans);
    }
}
