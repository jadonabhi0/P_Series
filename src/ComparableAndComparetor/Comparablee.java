package ComparableAndComparetor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comparablee {

    public static void main(String[] args) {

        List<StudentComparable> list = new ArrayList<>();
        list.add(new StudentComparable(3234, "C", 890000));
        list.add(new StudentComparable(7464, "D", 56000));
        list.add(new StudentComparable(2323, "R", 67889));
        list.add(new StudentComparable(8799, "T", 23400));
        list.add(new StudentComparable(8797, "H", 90000));

        Collections.sort(list);
        list.forEach(System.out::println);

    }


}
