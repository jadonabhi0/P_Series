import java.util.Arrays;
import java.util.Stack;

public class MaxHistogram {

    public static void main(String[] args) {
        int[] array = new int[]{1,1};
        int[] rb = new int[array.length];
        Stack<Integer> st = new Stack<>();
        st.push(array.length-1);
        rb[array.length-1] = array.length;
        for(int i = array.length-2 ; i >= 0 ; i--){
            while (st.size() > 0 && array[i] <= array[st.peek()]){
                st.pop();
            }

            if (st.size() == 0){
                rb[i] = array.length;
            }
            else{
                rb[i] = st.peek();
            }
            st.push(i);
        }


        int[] lb = new int[array.length];

        Stack<Integer> stt = new Stack<>();
        stt.push(0);
        lb[0] = -1;
        for(int i = 1 ; i < array.length ; i++){
            while (stt.size() > 0 && array[i] <= array[stt.peek()]){
                stt.pop();
            }

            if (stt.size() == 0){
                lb[i] = -1;
            }
            else{
                lb[i] = stt.peek();
            }
            stt.push(i);
        }

        int maxArea = 0;
        for(int i =0 ; i < array.length ; i++){
            int width = rb[i] - lb[i] -1;
            int area = width * array[i];
            if (area > maxArea){
                maxArea = area;
            }
        }
        System.out.println(Arrays.toString(lb));
        System.out.println(Arrays.toString(rb));
        System.out.println(maxArea);
    }

}
