import java.util.Arrays;

public class ChocolateDistribution {

    public  static  int minDiff(int[] array, int s){

        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = i+s-1;
        Arrays.sort(array);
        while (j < array.length){

            min = Math.min(min, array[j] - array[i]);
            i++;
            j++;
        }
        return min;
    }

    public static void main(String[] args) {
        int arr[] = {12, 4, 7, 9, 2, 23,
                25, 41, 30, 40, 28,
                42, 30, 44, 48, 43,
                50};
        System.out.println(minDiff(arr, 7));
    }
}
