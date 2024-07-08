package finalTests._2020;

public class _85 {
    public static int findMaximum(int[][] mat) {
        if (mat[0][0] == -1) return -1;
        return findMaximum(mat, 0, 0, 0);
    }

    private static int findMaximum(int[][] mat, int i, int j, int current) {
        if (i > mat.length || j > mat[i].length || j < 0
                || mat[i][j] == -1) return current;

        current += mat[i][j];
        int down = findMaximum(mat, i + 1, j, current);

        if (i % 2 == 0) return Math.max(
                findMaximum(mat, i, j + 1, current), down);
        else return Math.max(findMaximum(mat, i, j - 1, current), down);
    }

    public static int strictlyIncreasing(int[] a) {
        int count = 0, low = 0;

        for (int i = 1; i < a.length -1; i++) {
            if (a[i] > a[i -1]) count += (i - low);
            else low = i;
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] a =
                {{1,1,-1,1,1},
                {1,0,0,-1,1},
                {1,1,1,1,-1},
                {-1,-1,1,1,1},
                {1,1,-1,-1,1}};

        int[] b = {1,2,4,4,5};
        int[] c = {1,3,2};
        System.out.println(strictlyIncreasing(c));
//        System.out.println(findMaximum(a));
    }
}
