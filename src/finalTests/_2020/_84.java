package finalTests._2020;

public class _84 {
    public static void findFactors(int n) {
        int low = 2, high = n;

        while (low <= high) {
            int mid = (low + high) /2;
            boolean left = isHighFactor(n, low, mid);
            boolean right = isHighFactor(n , mid, high);

            if (left && right) {
                System.out.println(mid + " " + n / mid);
                break;
            }

            if (left) high = mid - 1;
            else low = mid + 1;
        }
    }

    private static boolean isHighFactor(int n, int low, int mid) {
        return true;
    }
}
