import java.util.*;

public class Ruff {
    public static void main(String[] args) {
       int[][] arv = {{1,3},{2,4},{6,8},{9,10},{4,6}};
        Arrays.sort(arv,((o1, o2) -> Integer.compare(o1[0],o2[0] ) ));
        for (int[] i : arv){
            System.out.println(Arrays.toString(i));
        }

       StringBuffer sb = new StringBuffer("aman");
        System.out.println(sb == sb.reverse());

        Stack<Character> st = new Stack<>();
        st.push('a');
        st.push('c');
        StringBuilder sbb = new StringBuilder();
        sbb.insert(0,'c');
        sbb.insert(0,'d');
        sbb.insert(0,'e');
        sbb.insert(0,'f');
        System.out.println(sbb);
    }
}
