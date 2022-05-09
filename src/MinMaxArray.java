public class MinMaxArray {

    static class BestPair{
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }

    public static BestPair getMinMax(int[] array){
        BestPair bpair = new BestPair();

        if (array.length == 0) return  bpair;

        if(array.length == 1){
            bpair.max = array[0];
            bpair.min = array[0];
            return bpair;
        }
        if (array.length == 2){
            if (array[0] > array[1]){
                bpair.max = array[0];
                bpair.min = array[1];
            }
            else {
                bpair.max = array[1];
                bpair.min = array[0];
            }
            return bpair;
        }

        for (int i = 0 ; i < array.length ; i++){
            if (bpair.max < array[i]){
                bpair.max = array[i];
            }
            if(bpair.min > array[i]){
                bpair.min = array[i];
            }
        }
        return bpair;

    }



    public static void main(String[] args) {

        int[] array = {1,8,90,4,0,3,1,26,72};
        BestPair b = getMinMax(array);
        System.out.println(b.max);
        System.out.println(b.min);

    }


}
