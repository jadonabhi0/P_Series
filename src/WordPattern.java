import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordPattern {

    static boolean ans ;
    public static boolean solution(String str, String pattern, HashMap<Character,String> map,String orgPattern){

        if(pattern.length() == 0){
            if (str.length() == 0){
                Set<Character> set  = new HashSet<>();
                for (int i = 0 ; i < orgPattern.length() ; i++){
                    char ch = orgPattern.charAt(i);
                    if(!set.contains(ch)){
                        System.out.println(ch+" -> "+map.get(ch));
                        set.add(ch);
                    }
                }
              ans = true;
            }
            return ans;
        }

        char ch = pattern.charAt(0);
        String restOfPattern  = pattern.substring(1);

        if (map.containsKey(ch)){
            String previousMapPattern = map.get(ch);
            if(str.length()>=previousMapPattern.length()){
                String left = str.substring(0,previousMapPattern.length());
                String right = str.substring(previousMapPattern.length());
                if(previousMapPattern.equals(left)){
                    solution(right, restOfPattern, map, orgPattern);
                }
            }
        }else{
            for (int i = 0 ; i < str.length() ; i++){
                String left = str.substring(0, i+1);
                String right = str.substring(i+1);
                map.put(ch, left);
                solution(right, restOfPattern, map, orgPattern);
                map.remove(ch);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        String pattern = "abba";
        String str = "dogcatcatdog";
        HashMap<Character, String > map = new HashMap<>();
        System.out.println(solution(str, pattern, map, pattern));


    }

}
