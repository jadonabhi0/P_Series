public class AllPossibleCombinationArray {

    public static  void  cmb(int[] array, int idx, String pair, int r){
        if (idx == array.length){
            System.out.println(pair);
            return;
        }

//        for (int i = 0 ; i < r ; i++){
//
//        }

        cmb(array,idx+1,pair+array[idx]+" ",r);
        cmb(array,idx+1,pair+" ",r);
    }

    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4};
        cmb(ar,0, "",3);
    }

}
