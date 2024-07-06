package finalTests._2021;

public class _62 {

    /**
     *
     * @param arr
     * @return true if we can split the cells to 2 groups that are equal by sum and number of cells
     */
    public static boolean equalSplit(int[] arr ){
        return equalSplit(arr, 0, 0, 0, 0, 0);
    }

    private static boolean equalSplit(int[] arr, int num1, int num2, int sum1, int sum2, int i) {
        if (num1 + num2 == arr.length) {
            return sum1 == sum2;
        }
        if (i >= arr.length) return false;

        return equalSplit(arr, num1 + 1, num2, sum1 + arr[i], sum2, i + 1) ||
                equalSplit(arr, num1, num2 + 1, sum1, sum2 + arr[i], i + 1);

    }

    public static void main(String[] args) {
        int[] a = {-3, 5, 12, 14, -9, 13};
        int[] b = {-3, 5, -12, 14, -9, 13};
        int[] c = {-3, 5, -12, 14, -9};

        System.out.println(equalSplit(a));
        System.out.println(equalSplit(b));
        System.out.println(equalSplit(c));
    }
}
