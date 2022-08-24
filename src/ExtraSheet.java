public class ExtraSheet {
    public static int noOfSwaps(int arr[], int count){
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]>arr[i]){
                count++;
                int temp = arr[i-1];
                arr[i-1] = arr[i];
                arr[i] = temp;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {5,1,3,6,2};
        System.out.println(noOfSwaps(arr, 0));

    }
}
