import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class NextGreaterElement {

    public static void secGreator(int n, int x, int[] array){
        int [] ans = new int [array.length];
        int c = array.length - 1;
        Stack<Integer> st = new Stack<>();
        st.push(array[c]);
        ans[c] = -1;

        for(int i = c - 1 ; i >=0 ; i--) {

            while (st.size() > 0 && st.peek() < array[i]+x) {
                st.pop();
            }
            if (st.size() == 0){
                ans[i] = -1;
            }
            else {
                st.pop();
                while (st.size() > 0 && st.peek() < array[i]+x) {
                    st.pop();
                }
                if (st.size() == 0){
                    ans[i] = -1;
                }else {
                    ans[i] = st.peek();
                }

            }
            st.push(array[i]);
        }


    }


    public static void main(String[] args) {

        int [] array = new int[]{3,2,1,6,9,5,4,5,8,6,0,5,1};
//        int [] ans = new int [array.length];
//
//        int c = array.length-1;
//
//        Stack<Integer> st =  new Stack<>();
//        st.push(array[c]);
//        ans[c] = -1;
//
//        for(int i = c - 1 ; i >=0 ; i--) {
//
//            while (st.size() > 0 && st.peek() <= array[i]) {
//                st.pop();
//            }
//            if (st.size() == 0){
//                ans[i] = -1;
//            }
//            else {
//                ans[i] = st.peek();
//            }
//
//
//            st.push(array[i]);
//        }
//
//        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(ans));



        secGreator(7, 2, new int[]{1, 2, 3, 4, 7, 6, 7});

    }

}
