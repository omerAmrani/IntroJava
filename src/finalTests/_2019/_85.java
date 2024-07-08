package finalTests._2019;

import java.util.Arrays;

public class _85 {
    public static int howManyPaths(int[][] mat) {

        int a= paths(mat,0 ,0);
        System.out.println(Arrays.deepToString(mat));
        return a;
    }

    private static int paths(int[][] mat, int i, int j) {
        if (i >= mat.length || i < 0 || j >= mat[i].length || j < 0
                || mat[i][j] == 0) return 0;
        if (i == mat.length -1 && j == mat[i].length -1) return 1;
        int k = mat[i][j];
        mat[i][j] = 0;

        int val = paths(mat, i + k, j) +
                paths(mat, i - k, j) +
                paths(mat, i, j + k) +
                paths(mat, i, j - k);

        mat[i][j] = k;
        return val;
    }


    public static int findSmallestMatchingIndex(int[] a, int[] b) {
        // Determine which array is shorter
        if (a.length < b.length) {
            return binarySearch(a, b);
        } else {
            return binarySearch(b, a);
        }
    }

    public static int binarySearch(int[] shorter, int[] longer) {
        int low = 0;
        int high = shorter.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (shorter[mid] == longer[mid]) {
                return mid;
            } else if (shorter[mid] < longer[mid]) {
                high = mid - 1; // Decrease the higher bound for decreasing order
            } else {
                low = mid + 1;  // Increase the lower bound for increasing order
            }
        }

        return -1; // Return -1 if no such index exists
    }

    public static void main(String[] args) {
        int[] a = {19,19,16,15,15,15,13,5};
        int[] b = {0,12,13,14,14,15,15,19,25};
        int[][] mat = {
                {1,3,1,6},
                {2,8,1,2},
                {6,2,7,5},
                {2, 4, 1, 3}
        };

        System.out.println(howManyPaths(mat));
//        System.out.println(findSmallestMatchingIndex(a,b));
    }
}
