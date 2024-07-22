package finalTests._2024;

public class _69 {

    // Finish 1 2
    public static int count(int sum) {
        return count(sum, 1);
    }

    private static int count(int sum, int start) {
        if (sum == 0) return 1;

        if (sum < start) return 0;

        return count(sum, start + 1) +
                count(sum - start, start + 1);
    }

    /**
     * The method fills the array with numbers that will be equal to s
     * The number need to be minimum
     * Time lessons.complexity is O(n).
     * @param arr fill with 0.
     * @param s
     */
    public static void minNumWithSum(int[] arr, int s) {
        // no possible combination
        if (!(s < arr.length * 9)) return;

        for (int i = 0; i < arr.length; i++) {

            // O(1)
            for (int j = 1; j <= 9; j++) {

                if (s - j <= (arr.length - 1 - i) * 9) {
                    arr[i] = j;
                    s = s- j;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] b= new int[4];
        minNumWithSum(b , 14);

        int a = count(7);
        System.out.println(a);
    }
}
