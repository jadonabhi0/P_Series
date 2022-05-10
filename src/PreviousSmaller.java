import java.sql.Array;
import java.util.Arrays;
import java.util.Stack;

public class PreviousSmaller {

    public static int[] smaller(int[] array){
        Stack<Integer> st = new Stack<>();
        int[] ps = new int[array.length];
        for(int i = 0 ; i < array.length ; i++){
            while (st.size() > 0  && st.peek() > array[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ps[i] = -1;
            }
            else {
                ps[i] = st.peek();

            }
            st.push(array[i]);
        }
        return ps;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4,10,5,8,20,15,3,12};
        System.out.println(Arrays.toString(smaller(array)));
    }

}
