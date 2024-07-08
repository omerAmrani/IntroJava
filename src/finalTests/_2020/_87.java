package finalTests._2020;

public class _87 {

    public static void printTriplets(int[] a, int num) {
        for (int i = a.length -1; i > 1; i--) {

            int cur = a[i];
            int high = i - 1;
            int low = 0;

            while (low <= high && cur <= num) {
                int val = a[low] * a[high] * cur;

                if (val == num) {
                    System.out.println( a[low] + " " + a[high] + " " + cur);
                    // keep searching for more
                    low++;
                }
                else if (val < num) low++;
                else high--;
            }
        }
    }


    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        int[] b = {1,3,6,8};

        printTriplets(a, 40);
        System.out.println("AAAA");
        printTriplets(b, 40);
    }
}
