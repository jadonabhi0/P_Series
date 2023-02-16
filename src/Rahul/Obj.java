package Rahul;/*
    @author jadon
*/

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Obj {

    static class Student  {
        String name;
        int rollNo;
        String course;
        long phone;
        int dob;
        
        

        public Student(String name, int rollNo, String course, long phone, int dob) {
            this.name = name;
            this.rollNo = rollNo;
            this.course = course;
            this.phone = phone;
            this.dob = dob;
        }



    }

    public static void helper(){
        LinkedList<Student> list = new LinkedList<>();
        list.add(new Student("rahul", 14, "btech", 78979879, 2002));
        list.add(new Student("Abhishek", 17, "btech", 78975465, 2000));
        list.add(new Student("Salman", 17, "btech", 78975465, 2001));
        list.add(new Student("srk", 17, "btech", 78975465, 1999));

//
//        Collections.sort(list, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o2.name.compareTo(o1.name);
//            }
//        });
        for (Student s : list){
            if (s.name.startsWith("A") && s.dob > 2000){
                System.out.println(s.name + "- >"+ s.dob);
            }
        }
    }

    public static void main(String[] args) {

        helper();


    }
}



