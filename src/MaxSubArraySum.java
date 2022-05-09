public class MaxSubArraySum {

    public static int sum(int[] array){
       int cursum = 0;
       int max = Integer.MIN_VALUE;

       for (int i = 0 ; i < array.length ; i++){

           cursum+=array[i];
           max = Math.max(cursum,max);

           if (cursum < 0){
               cursum = 0;
           }
       }
       return max;
    }




//    public static int maxSubArray(int[] nums) {
//
//    }


    public static void main(String[] args) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};

    }


}
