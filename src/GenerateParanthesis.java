import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateParanthesis {

    // ======================== Brute force =============================


    public List<String> generate(char[] array, int pos, List<String> list){
        if(pos == array.length){
            if (valid(array)){
                list.add(new String(array));
            }
            return list;
        }

        array[pos] = '(';
        generate(array,pos+1, list);
        array[pos] = ')';
        generate(array, pos+1, list);
        return  list;
    }

    public boolean valid (char[] array){
        int b = 0;
        for(char ch : array){
            if(ch == '(') b++;
            else b--;
            if(b < 0) return false;
        }
        return b == 0;
    }

    public  List<String> generateAll(int n){
//        char[] array = new char[2*n];
//        return generate(array, 0,new LinkedList<>());
        return generateAll(new ArrayList<>(), "", 0, 0, n);
    }

    // ========================= Backtracking ========================


    public List<String> generateAll(List<String> list, String s, int o , int c, int n){
        if(n*2 == s.length()){
            list.add(s);
            return list;
        }

        if (o<n) generateAll(list, s+'(',o+1, c, n);
        if (c<o) generateAll(list, s+')',o, c+1, n);
        return list;

    }





    public static void main(String[] args) {
        GenerateParanthesis gp = new GenerateParanthesis();
        System.out.println(gp.generateAll(10));
    }


}
