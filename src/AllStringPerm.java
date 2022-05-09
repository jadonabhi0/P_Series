import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllStringPerm {

   static List<String> list = new LinkedList<>();
    public static List<String> perm(String str, String substr, List<String> list){

        if (str.length() == 0){
            list.add(substr);
            return  list;
        }
        for (int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            String s = str.substring(0,i)+str.substring(i+1);
            perm(s,ch+substr,list);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(perm("abc", "", list));
    }

}
