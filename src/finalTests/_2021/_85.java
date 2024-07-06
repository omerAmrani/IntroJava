package finalTests._2021;

public class _85 {

    /**
     * Using the sum of the array,
     * we add or subtract to the sum to get average that's equal to X.
     * @param arr
     * @param x
     * @return true and prints the indexes of cells that are equal to X in average
     */
    public static boolean findAverage(int[] arr, double x) {
        int left = 0;
        int right = arr.length - 1;
        int length = arr.length;

        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }

        while (left <= right && length > 0) {
            double avg = sum / length;
            if (avg == x) {
                System.out.println(left + "-" + right);
                return true;
            }
            if (avg > x) {
                sum -= arr[right];
                right--;
            }
            else {
                sum -= arr[left];
                left++;
            }
            length--;
        }

        System.out.println("No range of cells");
        return false;
    }


}
