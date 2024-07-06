package finalTests._2012;

public class _82 {

    /**
     * TODO not finished
     * In a sorted array find how many times does num appear
     * @param arr sorted array
     * @param num
     * @return how many times does num appear
     */
    public static int count(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;

        int leftIndex = -1;


        while (leftIndex == -1 && left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == num && (mid == left || arr[mid] > arr[mid - 1])) {
                leftIndex = mid;
            } else {
                if (arr[mid] > num || (arr[mid] == num && arr[mid] == arr[mid - 1])) {
                    right = mid - 1;
                }
                if (arr[mid] < num)
                    left = mid + 1;
            }
        }
        return -1;
    }
}
