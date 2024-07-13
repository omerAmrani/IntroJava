package finalTests._2023;

public class _72 {
    // Finish 2


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

        System.out.println(findPeak(a));
        System.out.println(findPeak(b));
    }
}
