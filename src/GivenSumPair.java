public class GivenSumPair {


    public String sumpair(int[] array, int sum){
        int i = 0;
        int j = array.length-1;

        while(i < j){
            if (array[i]+array[j] == sum)
            {
                return array[i]+" "+array[j]+"";
            }
            else if(array[i]+array[j] > sum){
                i++;
            }
            else {
                j--;
            }
        }
        return "no";
    }

    public static void main(String[] args) {
        int arr[] = {11, 15, 6, 8, 9, 10};
        int sum = 16;
        GivenSumPair g = new GivenSumPair();
        System.out.println(g.sumpair(arr, 16));
    }
}
