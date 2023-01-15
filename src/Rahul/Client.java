package Rahul;/*
    @author jadon
*/

public class Client {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(5);
        list.add(52);
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(5);
        list.print();
        list.addAtPos(3, 1000);
        list.print();
    }
}
