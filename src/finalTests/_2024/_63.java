package finalTests._2024;

public class _63 {
    // O(1)
    public static int get(int[] b, int k) {
        if (k == 0) return b[0];
        return b[k] - b[k -1];
    }

    public static int find(int[] b, int x) {
        int low = 0, high = b.length -1;
        while (low <= high) {
            int mid = (low + high) /2;
            int val = get(b , mid);

            if (val == x) return mid;

            else if (val >= x) high = mid -1;
            else low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {-1,2,3,4,5};
        int[] b = {-1,1,4,8,13};

        System.out.println(get(b, 3));
        System.out.println(find(b, -1));
    }
}
