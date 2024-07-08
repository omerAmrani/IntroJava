package finalTests._2023;

public class _83 {
    public static int findSmallestSubArrayLen(int[] arr, int num) {
        int low = 0, high = 0, min = arr.length, sum = arr[high];

        while (low <= high && high < arr.length) {


            if (sum > num) {
                System.out.println(low + " to " + high + " is " + sum);
                if (high - low + 1 < min ) min = high - low + 1;
                sum -= arr[low];
                low++;
            }
            else {
                high++;
                if (high < arr.length) sum += arr[high];
            }
        }
        return high - low + 1;
    }

    public static void main(String[] args) {
        int[] a = {2,6,1,9,7,3,1,4,1,8};

        System.out.println(findSmallestSubArrayLen(a, 15));
    }


}
