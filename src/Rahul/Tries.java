package Rahul;/*
    @author jadon
*/

import java.util.HashMap;

public class Tries {


    class Node{
        char ch;
        HashMap<Character, Node> children;
        boolean isTerminal;
        Node(char ch){
            this.ch = ch;
            this.children = new HashMap<>();
            this.isTerminal = false;
        }
    }




    private Node root;

    Tries(){
        this.root = new Node('*');
    }

    public void insert(String str){
        Node cur = this.root;
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            if (cur.children.containsKey(ch)){
                cur = cur.children.get(ch);
            }else{
                Node node = new Node(ch);
                cur.children.put(ch,node);
                cur = node;
            }
        }
        cur.isTerminal = true;
    }


    public boolean startsWith(String str){
        Node cur = this.root;
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            if(cur.children.containsKey(ch)){
                cur = cur.children.get(ch);
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean contains(String str){
        Node cur = this.root;
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            if (cur.children.containsKey(ch)){
                cur = cur.children.get(ch);
            }else return false;
        }
        return cur.isTerminal;
    }

    public static void main(String[] args) {
        Tries tr = new Tries();
        tr.insert("abhishek");
        tr.insert("aman");
        tr.insert("Yash");
        tr.insert("shiv");
        System.out.println(tr.startsWith("abhih"));
        System.out.println(tr.contains("abhishek"));
    }
}
