import java.awt.datatransfer.FlavorListener;
import java.time.temporal.JulianFields;
import java.util.*;

public class FindKClosestElements {

    static class Node  implements Comparable<Node>{
        int gap;
        int num;

        public Node(int gap, int num) {
            this.gap = gap;
            this.num = num;
        }


        @Override
        public int compareTo(Node o) {
            if (this.gap == o.gap) return this.num - o.num;
            else return this.gap - o.gap;
        }
    }
    public static List<Integer> helper(int[] array, int k, int x){
        PriorityQueue<Node> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0 ; i < array.length ; i++){
            if (q.size() < k){
                q.add(new Node(Math.abs(array[i] - x), array[i]));
            }else{
                if (q.peek().gap > Math.abs(array[i] - x)){
                    q.remove();
                    q.add(new Node(Math.abs(array[i] - x), array[i]));
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()){
            list.add(q.poll().num);
        }
        Collections.sort(list);
        return list;
    }



    public static List<Integer> helperOptmized(int[] array, int k, int x){
        int l = 0;
        int r = array.length-1;
        int mid = 0;
        while(l <= r){
            mid = (l+r)/2;
            if (array[mid] == x) break;
            else if(array[mid] < x) l = mid+1;
            else r = mid-1;
        }
        l = mid-1;
        r = mid;
        ArrayList<Integer> list = new ArrayList<>();
        while(l>=0 && r < array.length && k > 0){
            if(Math.abs(array[l]  - x ) <= Math.abs(array[r]-x)){
                list.add(array[l]);
                l--;
            }else{
                list.add(array[r]);
                r++;
            }
            k--;
        }

        while(l >= 0 && k > 0 ){
            list.add(array[l--]);
            k--;
        }
        while(r < array.length && k > 0){
            list.add(array[r++]);
            k--;
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
//        System.out.println(helper(new int[]{1, 2, 3, 4, 5}, 4, 3));
        System.out.println(helperOptmized(new int[]{1, 2, 3, 4, 5}, 4, 3));
    }
}
