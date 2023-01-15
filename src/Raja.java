import java.util.Stack;

public class Raja {

    public static boolean isAnagram(String str1, String str2){
        int [] array = new int [26];
        for(int i = 0 ; i < str1.length() ; i++) array[str1.charAt(i) - 'a']++;
        for(int i = 0 ; i < str2.length() ; i++) array[str2.charAt(i) - 'a']--;
        for(int i : array) if(i != 0) return false;
        return true;
    }


    public static double angleClock(int hr,int mn) {

        double hrAng = hr * 30 + 0.5 * mn;
        double minAng = 6 * mn;

        double total = Math.abs(hrAng - minAng);

        if(total <= 180) return total;
        else return 360.0 - total;

    }


    public int firstUniqChar(String s) {
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if (s.indexOf(ch) == s.lastIndexOf(ch)) return i;
        }
        return -1;
    }

    public static boolean isPrime(int n){

        int count = 0;
        for(int i = 2 ; i * i <= n ; i++){
            if(n % i == 0) {
                count++;
                break;
            }
        }
        if (count == 0) return true;
        else return false;

    }

    public static void firstFiftyPrime(){
        int countPrime = 1;
        int num = 2;
        int n = 1;
        while (countPrime <= 5){
            if (isPrime(num)){
                System.out.println(n++ + "th -->" + num);
                countPrime++;
            }
            num++;
        }

    }


    public static void binaryToDecimal(int bin){
        int decimal = 0;
        int n = 0;

        while(true){

            if (bin == 0) break;
            else{
                int temp = bin % 10;
                decimal += temp*Math.pow(2, n);
                bin = bin / 10;
                n++;
            }
        }
        System.out.println(decimal);
    }


    public static boolean isSubsequence(String str1, String str2){
        int count = 0;
        if (str1.length() == 0) return true;
        String st1 = null;
        String st2 = null;
        for(int i = 0 ; i < str2.length() ; i++){
            if (count < str1.length()){
                st1 = str1.charAt(count)+"";
            }
            st2 = str2.charAt(i)+"";

            if (st1.equals(st2)){
                count++;
            }
        }

        if (count == str1.length()) return true;
        else return false;

    }


    public static boolean isLeapYear(int year){
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) return true;
        else return false;
    }


    public static int minCoins(int[] array, int target){
        int[] dp = new int[target+1];

        for(int i = 1; i < dp.length ; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0 ; j < array.length ; j++){
                if (i >= array[j]){
                    min = Math.min(dp[i-array[j]], min);
                }
            }
            dp[i] = min + 1;
        }
        return dp[target];
    }



    public static int buyAndSellStock(int[] array){
        int minCost =  Integer.MAX_VALUE;
        int profit = 0;
        int overalProfit = 0;

        for (int i = 0 ; i < array.length ; i++){
            minCost = Math.min(minCost, array[i]);
            profit = array[i] - minCost;
            overalProfit = Math.max(overalProfit, profit);
        }

        return overalProfit;
    }


    public static String replaceString(String str){

        return str.replace("%?", " ");

    }

    public static boolean isValid(String str){
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);

            if (ch == '{' || ch == '[' || ch == '(') st.push(ch);
            else {
                if (!st.isEmpty()){
                    if (st.peek() == '{' && ch == '}') st.pop();
                    else if(st.peek() == '[' && ch == ']') st.pop();
                    else if(st.peek() == '(' && ch == ')') st.pop();
                }else return false;
            }

        }
        return st.isEmpty();
    }


    public static void printPyramid(int n){
        for(int i = 1 ; i <= n ; i++){
            for(int j = n ; j >= 1 ; j--){
                if (j > i) System.out.print(" ");
                else System.out.print(" *");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

//        System.out.println(isAnagram("abhishek", "abhishek"));
//        firstFiftyPrime();
//        binaryToDecimal(11111);

//        System.out.println(isSubsequence("abc", "ahbgdc"));

        System.out.println(isValid(""));
        printPyramid(4);
    }



}
