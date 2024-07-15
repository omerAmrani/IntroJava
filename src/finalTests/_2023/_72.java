package finalTests._2023;

public class _72 {
    // Finish 2

    public static int friend3(int[][] mat) {
        return friend3(mat, 0, 1, 2);
    }

    private static int friend3(int[][] mat, int i, int j, int k) {
        if (i > mat.length || j > mat.length || k > mat.length) return 0;
        if (i == j || j == k || k == i) return 0;
        if (mat[i][j] == 0 || mat[j][k] == 0) return 0;

        if (mat[i][j] == 1 && mat[j][k] == 1) {
            System.out.println(i + " " + j + " " + k);
            return 1;
        }

        return friend3(mat, i + 1, j, k) +
                friend3(mat, i,j +1, k) +
                friend3(mat, i,j, k + 1);
    }

    /**
     * peak is a cell in the array that is not smaller than it's neighbors 
     * @param arr
     * @return The first peak
     */
    public static int findPeak(int[]arr) {
       int low = 0, high = arr.length -1;

       while (low <= high) {

           int mid = (low + high) / 2;

           if ((mid == 0|| arr[mid -1] <= arr[mid]) &&
                   (mid == arr.length -1 || arr[mid + 1] <= arr[mid]))
               return arr[mid];
           else if (arr[mid -1] > arr[mid]) high = mid -1;
           else low = mid + 1;
       }

       return -1;
    }

    public static void main(String[] args) {
        int[] a = {67, 90, 90, 2, 15, 20, 10};
        int[] b = {1,2,3,4,5};
        int[][] m = {
                {0,1,1,1},
                {1,0,1,1},
                {1,1,0,1},
                {1,1,1,0}
        };

        System.out.println(friend3(m));

//        System.out.println(findPeak(a));
//        System.out.println(findPeak(b));
    }
}
