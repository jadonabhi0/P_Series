package ComparableAndComparetor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparatorr {

    public static void main(String[] args) {


        List<StudentComparator> list = new ArrayList<>();
        list.add(new StudentComparator(1, "B"));
        list.add(new StudentComparator(4, "A"));
        list.add(new StudentComparator(2, "G"));
        list.add(new StudentComparator(3, "L"));
        list.add(new StudentComparator(6, "T"));
        list.add(new StudentComparator(5, "Y"));


//        Collections.sort(list,new sortByName());

        // using lambda function
//        Collections.sort(list, (o1, o2) ->{
//            if (o1.getName().equals(o2.getName())){
//                return o1.getId()- o2.getId();
//            }else {
//                return o1.getName().compareTo(o2.getName());
//            }
//
//        });

        // new way
//        Collections.sort(list, Comparator.comparing(StudentComparator::getName));


        // using anonymous comparator

        Collections.sort(list, new Comparator<StudentComparator>() {
            @Override
            public int compare(StudentComparator o1, StudentComparator o2) {
                if (o1.getName().equals(o2.getName())){
                    return o1.getId()- o2.getId();
                }else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });

        Collections.sort(list, Comparator.comparing(StudentComparator::getName).thenComparing(StudentComparator::getId).reversed());

        list.forEach(System.out::println);
    }

    static class sortByName implements Comparator<StudentComparator>{

        @Override
        public int compare(StudentComparator o1, StudentComparator o2) {
            if (o1.getName().equals(o2.getName())){
                return o1.getId()- o2.getId();
            }else {
                return o1.getName().compareTo(o2.getName());
            }
        }
    }


}
