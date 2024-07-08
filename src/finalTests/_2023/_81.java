package finalTests._2023;

public class _81 {
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

        findSubArray(a, 15);
//        findSubArray(a, 16);
//        findSubArray(a, 8);
//        findSubArray(a, 22);
    }
}
