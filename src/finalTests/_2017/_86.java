package finalTests._2017;

public class _86 {
    public static int countTriplets(int[] arr, int num) {
        int count = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            int low = i + 1, high = arr.length - 1;
            while (low < high) {
                if (arr[i] + arr[low] + arr[high] < num) {
                    // If arr[i] + arr[low] + arr[high] is less than num,
                    // then all elements from low to high-1 will also form valid triplets with arr[i] and arr[low]
                    count += (high - low);
                    System.out.println(arr[i] + " " + arr[low] + " " + arr[high]);
                    low++;
                } else {
                    high--;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] a = {-2,0,1,3};
        int[] b = {1,3,4,5,7};

        System.out.println(countTriplets(a, 2));
        System.out.println(countTriplets(b, 12));
    }
}
