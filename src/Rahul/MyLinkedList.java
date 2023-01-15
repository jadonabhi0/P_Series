package Rahul;/*
    @author jadon
*/

public class MyLinkedList {

    class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;

    public void add(int data){
        if(head == null){
            head = new Node(data);
        }
        else {
            Node temp = head;
            Node prev = null;
            while (temp != null){
                prev = temp;
                temp = temp.next;
            }
            prev.next = new Node(data);
        }
    }

    public void addFirst(int data){
        Node temp = new Node(data);
        temp.next = head;
        head = temp;

    }

    public void addAtPos(int pos , int data){
        Node temp = head;
        Node prev = null;
        while (pos -- > 0){
            prev = temp;
            temp = temp.next;
        }
        Node node = new Node(data);
        Node hold = prev.next;
        prev.next = node;
        node.next = hold;
    }

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

}
