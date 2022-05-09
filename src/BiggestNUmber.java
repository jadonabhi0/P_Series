import java.util.*;

public class BiggestNUmber {

    public static void bigInt(Vector<String> array){


        Collections.sort(array, new Comparator<String>() {
            @Override
            public int compare(String X, String Y) {
                String XY = X + Y;
                String YX = Y + X;
                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });
        Iterator it = array.iterator();

        while (it.hasNext())
            System.out.print(it.next());
    }


    public static void main(String[] args) {
        Vector<String > st = new Vector<>();
        st.add("9");
        st.add("98");
        bigInt(st);
    }
}
