package finalTests._2016;

public class _67 {
    // Finish 1
    public static int passingCars(int[] a) {
        int Q = 1, countP = 0, count = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == Q) count += countP;
            else countP++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a = {0,1,0,1,1};
        int[] b = {0,0,1,0,0};

        System.out.println(passingCars(b));
    }
}
