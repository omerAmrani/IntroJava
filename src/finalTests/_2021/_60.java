package finalTests._2021;

public class _60 {
    /**
     *
     * @param arr
     * @return true or false if we can split the cells in the array to 3 different groups
     * where each of them have the same sum.
     */
    public static boolean split3(int[] arr) {
        if (arr.length < 3) return false;

        return split3(arr, 0, 0, 0, 0);
    }

    /**
     * splitting the recursion between each part
     * @param arr
     * @param index only calculate when reaching the end of the array
     * @param sum1
     * @param sum2
     * @param sum3
     * @return
     */
    private static boolean split3(int[] arr,int index, int sum1, int sum2, int sum3) {
        if (arr.length == index) {
            return (sum1 == sum2 && sum2 == sum3);
        }

        return split3(arr, index + 1, sum1 + arr[index], sum2, sum3) ||
                split3(arr, index + 1, sum1, sum2  + arr[index], sum3) ||
                split3(arr, index + 1, sum1, sum2, sum3 + arr[index]);
    }

    /**
     * find the smallest sub array that its sum is bigger then k
     * SLIDING WINDOW method - move the left and the right together
     * @param a array
     * @param k the value to compare the sum of the array to
     * @return the length of the sub array
     */
    public static int smallestSub(int[] a, int k) {
        int sum = a[0];
        int left = 0;
        int right = 0;
        int minLength = a.length + 1;

        while (right < a.length) {
            if (sum <= k) {
                 right++;
                 if (right < a.length) sum+= a[right];
            }
            else {
                minLength = Math.min(minLength, right - left + 1);

                sum -= a[left];
                left++;
            }
        }

        return minLength;
    }
}