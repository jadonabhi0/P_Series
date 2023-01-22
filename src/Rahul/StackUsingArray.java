package Rahul;/*
    @author jadon
*/

import java.util.Arrays;

public class StackUsingArray {
    int[] array;
    int top;
    int count;
    StackUsingArray(int s){
        array = new int[s];
        top = -1;
        count = 0;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int data){
        if(array.length-1 == top) throw new ArrayIndexOutOfBoundsException();
        top++;
        count++;
        array[top] = data;

        int lf = count/array.length;
        if(lf > 0.75) reHashing();

    }

    public int Size(){
        return count;
    }

    public int pop(){
        if(isEmpty()) throw new ArrayIndexOutOfBoundsException();
        int rm = array[top];
        top--;
        count--;
        return rm;
    }

    private void reHashing(){
//        System.out.println(Arrays.toString(array));
        int c = array.length;
        int[] nA = new int[c*2];
        int k = 0;
        for (int i : array){
            nA[k++] = i;
        }
        array = nA;
//        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {

        StackUsingArray st = new StackUsingArray(10);
        System.out.println(st.isEmpty());
        System.out.println(st.Size());

        st.push(78);
        st.push(79);
        st.push(80);
        st.push(71);
        st.push(72);
        st.push(73);
        st.push(73);
        st.push(73);
        st.push(73);
        st.push(73);
        st.push(73);
        st.push(73);
        st.push(73);
        st.push(73);
        st.push(73);
        st.push(73);


        System.out.println(st.isEmpty());
        System.out.println(st.Size());

        while(!st.isEmpty()){
            System.out.println(st.pop());
        }

    }

}
