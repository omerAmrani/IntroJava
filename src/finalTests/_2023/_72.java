package finalTests._2023;

public class _72 {

    /**
     * peak is a cell in the array that is not smaller than it's neighbors 
     * @param arr
     * @return The first peak
     */
    public static int findPeak(int[]arr) {
        // check first
        if (arr[0] > arr[1]) return arr[0];

        // check middle
        for (int i = 1; i < arr.length - 1; i++) {
            int left = arr[i -1];
            int right = arr[i + 1];

            if (arr[i] >= left && arr[i] >= right) return arr[i];
        }

        // check last
        if (arr[arr.length - 1] > arr[arr.length - 2]) return arr[arr.length - 1];

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {67, 90, 90, 2, 15, 20, 10};
        int[] b = {1,2,3,4,5};

        System.out.println(findPeak(b));
    }
}
