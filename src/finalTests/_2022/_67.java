package finalTests._2022;

public class _67 {
    public static boolean isIdentity(int[][] mat, int x, int size) {
        if (mat[x][x] != 1) return false;
        if (size == 0) return true;

        x++;
        size--;

        boolean checkRow = checkZero(x, size, mat[x]);
        boolean checkColumn = checkZero(x, size, mat[size]); // TODO

        if (checkRow || checkColumn) return false;

        return isIdentity(mat, x, size);
    }

    private static boolean checkZero(int x, int size, int[] arr) {
        if (size == 0) return true;
        if (arr[x] != 0) return false;

        return checkZero(x + 1, size - 1, arr);
    }

    public static int maxMatrix(int[][] mat) {
        return maxMatrix(mat, mat[mat.length /2][mat.length /2], 0);
    }

    private static int maxMatrix(int[][] mat, int start, int max) {
        if (start == -1 || !isIdentity(mat, start, max)) return max;

        return maxMatrix(mat, start - 1, max + 1);

    }

    public static int findMissingIndex(int[] a) {
        int mid, low = 0, high = a.length - 1, left, right;

        while (low <= high && (low + high) / 2 < a.length - 1) {
            mid = (low + high) / 2;
            left = a[mid] - a[mid - 1];
            right = a[mid +1] - a[mid];

            if (left != right) return mid;
            if(a[mid] - a[low] != (mid - low) * 2) high = mid - 1;
            else low = mid + 1;
        }

        return a.length;
    }

    public static void main(String[] args) {
        int[] a = {22, 24, 26, 32, 34, 36, 38, 40};
        int[] b = {22, 26, 28};
        int[] c = {2, 4, 6, 8, 10};

        System.out.println(findMissingIndex(a));
        System.out.println(findMissingIndex(b));
        System.out.println(findMissingIndex(c));
    }

    // 3 Trace on iPad
}
