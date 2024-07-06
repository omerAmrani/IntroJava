package finalTests._2024;

public class _69 {

    public static int count(int sum) {
        return count(sum, 0);
    }

    // TODO
    private static int count(int sum, int val) {
        if (sum < val) return 0;
        if (sum == val) return 1;
        System.out.println(val);

        return count(sum, val + (val + 1)) +  count(sum, val + (val+ 2));
    }

    /**
     * The method fills the array with numbers that will be equal to s
     * The number need to be minimum
     * Time complexity is O(n).
     * @param arr fill with 0.
     * @param s
     */
    public static void minNumWithSum(int[] arr, int s) {
        // no possible combination
        if (!(s < arr.length * 9)) return;

        for (int i = 0; i < arr.length; i++) {

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
        int a = count(7);
        System.out.println(a);
    }
}
