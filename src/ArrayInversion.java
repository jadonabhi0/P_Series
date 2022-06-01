public class ArrayInversion {

    private int[] divide(int[] array, int low, int high){
        if (low == high){
            int[] base = new int[1];
            base[0] = array[low];
            return base;
        }
        int mid = (low + high) / 2;
        int[] left = divide(array, low, mid);
        int[] right = divide(array, mid+1, high);
        int[] merged = merge(left, right);
        return merged;
    }

    int count = 0;
    private int[] merge(int[] left, int[] right){

        int[] merged = new int[left.length + right.length];
        int i = 0 ;
        int j = 0 ;
        int k = 0 ;

       while (i < left.length && j < right.length){
           if (left[i] < right[j]){
               merged[k++] = left[i];
               i++;
           }else{
               count += (left.length - i);
               merged[k++] = right[j];
               j++;
           }
       }

       while(i < left.length){
           merged[k++] = left[i];
           i++;
       }

       while (j < right.length){
           merged[k++] = right[j];
           j++;
       }

        return merged;
    }

    public void arrayInversion(int[] array){
        divide(array, 0, array.length-1);
        System.out.println(count);
    }


    public static void main(String[] args) {


        int[] array = new int[]{8,5,3,4,1,6,2};
        ArrayInversion a = new ArrayInversion();
        a.arrayInversion(array);
    }





}
