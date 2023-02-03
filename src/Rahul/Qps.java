package Rahul;/*
    @author jadon
*/

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

public class Qps {

    public static int reverse(int x){
        int ans = 0;
        while(x != 0){
            int rem = x % 10;
            x /= 10;
            ans = ans * 10 + rem;
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(reverse(-456));
    }

}
