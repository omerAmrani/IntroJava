package finalTests._2015;

public class _91 {
    public static boolean what(int[] a, int num) {
        int low = 0, high = 1;
        int sum  = a[low];

        while (low <= high && high < a.length) {
            if (sum == num) return true;
            if (sum < num) {
                sum += a[high];
                high++;
            }
            else {
                sum -= a[low];
                low++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {2,4,6,3,6, 7};

        System.out.println(what(a, 333));
        System.out.println(what(a, 13));
    }
}
