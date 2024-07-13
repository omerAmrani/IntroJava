package finalTests._2024;

public class _63 {
    // Finish 1 2 3 5
    public static int minPoints(int[][] m) {
        return minPoints(m, m.length -1, m[m.length -1].length -1, 0, 1);
    }

    private static int minPoints(int[][] m, int i, int j, int curr, int num) {
        if (j < 0 || i < 0) return Integer.MAX_VALUE;

        curr += m[i][j];
        if (curr < 0) num += (-1 * curr);

        if (j == 0 && i == 0) return num;


        int up = minPoints(m, i - 1, j, curr, num);
        int left = minPoints(m, i, j - 1, curr, num);
        return Math.min(up, left);
    }

    // O(1)
    public static int get(int[] b, int k) {
        if (k == 0) return b[0];
        return b[k] - b[k -1];
    }

    // O(log n)
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
        int[][] m = {
                {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}
        };
        System.out.println(minPoints(m));

//        System.out.println(get(b, 3));
//        System.out.println(find(b, -1));
    }
}
