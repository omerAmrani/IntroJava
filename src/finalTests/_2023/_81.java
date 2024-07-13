package finalTests._2023;

public class _81 {
    // Finish 2
    public static int greatestRoute(int[][] mat) {
        return greatestRoute(mat, 0, 0, 0, "");
    }

    private static int greatestRoute(int[][] mat, int i, int j, int max, String path) {
        if (i < 0 || j <0 || i > mat.length - 1
                || j > mat[i].length - 1 || mat[i][j] == 0) return 0;


        path += "(" + i +", " + j + ") [" + mat[i][j] + "] ";
        max += mat[i][j];

        if (i == mat.length -1 && j == mat[i].length -1) {
            System.out.println(path + "= " + max);
            return max;
        }

        path += "--> ";

        mat[i][j]--;
        int up = greatestRoute(mat, i + 1, j, max, path);
        int down = greatestRoute(mat, i - 1, j, max, path);
        int right = greatestRoute(mat, i, j + 1, max, path);
        int left = greatestRoute(mat, i, j - 1, max, path);
        mat[i][j]++;

        int max1 = Math.max(up, down);
        int max2 = Math.max(right, left);

        return Math.max(max1, max2);

    }

    public static void findSubArray(int[] arr, int target) {
        int low= 0, high = 0, sum = 0;

        while (low <= high && high < arr.length) {
            if (sum == target) {
                System.out.println("indexes: " + low + " and " + high + " with sum " + sum);
                return;
            }
            if (sum < target) {
                sum += arr[high];
                high++;
            }
            else {
                sum -= arr[low];
                low++;
            }
        }
        System.out.println("Not found");
    }

    public static void main(String[] args) {
        int[] a = {2,6,0,1,9,7,3,1,4,1,8};
        int[][] m = {
                {2, 3},
                {4, 1}
        };
        System.out.println(greatestRoute(m));

//        findSubArray(a, 15);
//        findSubArray(a, 16);
//        findSubArray(a, 8);
//        findSubArray(a, 22);
    }
}
