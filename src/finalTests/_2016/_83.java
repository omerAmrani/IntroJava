package finalTests._2016;

public class _83 {
    public static boolean findX(int[] a, int x) {
        int low = 0, high = a.length -1;

        while (low < high) {
            int mid = (low + high) /2;
            int sum = a[mid] + a[mid + 1];
            if (sum == x) {
                System.out.println(a[mid] + " " + a[mid + 1]);
                return true;
            }
            if (sum > x) high = mid -1;
            else low = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,2,5,3,6,10,9};

        System.out.println(findX(a, 9));
        System.out.println(findX(a, 5));
    }
}
