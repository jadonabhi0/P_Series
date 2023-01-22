package Rahul;/*
    @author jadon
*/

import javax.swing.plaf.IconUIResource;
import java.nio.BufferUnderflowException;

public class StackUsingNode {

    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int count = 0;

    public void push(int data){
        if(head == null) head = new Node(data);
        else{
            Node temp = head;
            Node prev = null;
            while (temp != null){
                prev = temp;
                temp = temp.next;
            }
            prev.next = new Node(data);
        }
        count++;
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public int pop(){
        if (head == null) throw new BufferUnderflowException();
        Node prev = null;
        Node temp = head;
        while (temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        count--;
        if (prev == null) return temp.data;
        int n = temp.data;
        prev.next = null;

        return n;
    }


    public static void main(String[] args) {
        StackUsingNode st = new StackUsingNode();
        System.out.println(st.isEmpty());
        System.out.println(st.size());
        st.push(45);
        st.push(46);
        st.push(47);
        st.push(48);
        st.push(49);
        st.push(50);
        System.out.println(st.isEmpty());
        System.out.println(st.size());


        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
    }

}
