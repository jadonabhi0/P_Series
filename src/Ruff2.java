import java.util.Comparator;
import java.util.PriorityQueue;

public class Ruff2 {



    public int helper(int [] array){

        if(array.length == 0) return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0 ; i < 2 ; i++){
            pq.add(array[i]);  // 1, 1

        }

        for(int i = 2 ; i < array.length ; i++){
            if (array[i] > pq.peek()){
                pq.poll(); // 10, 14
                pq.add(array[i]);

            }
        }

        int a = pq.poll();
        int b = pq.poll();

        return a == b ? -1 :a;
    }


    public int helper2(int hr, int min){ // 00, 10

        int hr_ang_hr = 30; // angle made by hour hand int one hour
        int hr_and_min = 1 / 2; // ang  made by hour hand in one min

        int total_ang_hr_hand = hr_ang_hr * hr + min * hr_and_min;  // 30 * 00+ 0.5 * 10= 5

        int min_and_hand = 6; // 6 * 10 = 60

        int total_ang_min_hand = 6 * min;

        int total = Math.abs(total_ang_hr_hand - total_ang_min_hand);


        if (total <= 180) return total;
        else return 360 - total;


    }




    public static void main(String[] args) {


    }

}
