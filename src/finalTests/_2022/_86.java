package finalTests._2022;

public class _86 {

    public static int maxPath(int[][] mat) {
        return maxPath(mat, 0 ,0,0);
    }

    private static int maxPath(int[][] mat, int i, int j, int max) {
        if (i >= mat.length || j >= mat[0].length) return -1;

        int val = mat[i][j];
        if (i == mat.length - 1 && j == mat[0].length - 1) return max + val;

        int units = val % 10;
        int tens = val / 10;

        max += val;

        int stp1= maxPath(mat, i + units, j + tens, max);
        int stp2 = maxPath(mat, i + tens, j + units, max);

        return Math.max(stp1, stp2);
    }

    /**
     * O(n *k)
     * @param a
     * @param k
     */
    public static void sortMod(int[] a, int k) {
        int sorted_index = 0;

        for (int i = 0; i < k; i++) {
            for (int j = sorted_index; j < a.length; j++) {

                if (a[j] % k == i) {// Swaps between both elements.
                    int tempVal = a[sorted_index];
                    a[sorted_index] = a[j];
                    a[j] = tempVal;
                    sorted_index++;
                }
            }
        }
    }

    // 3 Trace Tree iPad
    // 5 Trace List TODO


    public static void main(String[] args) {
        int[][] matrix = {
                {12, 22, 23, 54, 11},
                {43, 35, 21, 20, 30},
                {34, 23, 43, 22, 30},
                {25, 31, 2, 20, 34},
                {10, 22, 10, 11, 10},
                {40, 13, 3, 1, 23}
        };

        System.out.println(maxPath(matrix));
    }
}
