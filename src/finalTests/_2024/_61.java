package finalTests._2024;

public class _61 {
    // Finish 1 2 3 4 5
    public static int whatElf(int[] a) {
        // calculate max diff
        int min = a[0], diff = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] - min >  diff) diff = a[i] - min;
            if (a[i] < min) min = a[i];
        }
        return diff;
    }

    public static int minOfMax(int[][] mat) {
        return minOfMax(mat, 0, 0, 0);
    }

    private static int minOfMax(int[][] mat, int i, int j, int max) {
        if (i < 0 || j < 0 || i == mat.length || j == mat[i].length || mat[i][j] == -1) return Integer.MAX_VALUE;
        if (i == mat.length -1 && j == mat[i].length - 1) return max;

        if (mat[i][j] > max) max = mat[i][j];

        int temp = mat[i][j];
        mat[i][j] = -1;

        int up = minOfMax(mat, i + 1, j, max);
        int down = minOfMax(mat, i - 1, j, max);
        int right = minOfMax(mat, i, j + 1, max);
        int left = minOfMax(mat, i, j - 1, max);

        mat[i][j] = temp;
        int min1 = Math.min(up, down);
        int min2 = Math.min(right, left);

        return Math.min(min1, min2);
    }

    public static void main(String[] args) {
        int[][] a = {
                {4,5,8,2},
                {3,12,7,16},
                {13,1,10,14},
                {15,11,9,6}
        };
        System.out.println(minOfMax(a));
    }
}
