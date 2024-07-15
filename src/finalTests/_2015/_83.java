package finalTests._2015;

public class _83 {
    public static boolean sum2(int[] arr, int num) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int sum = arr[low] + arr[high];
            if (sum == num) {
                System.out.println(arr[low] + " " + arr[high]);
                return true;
            }
            else if (sum > num) high --;
            else low++;
        }
        return false;
    }

    public static boolean sum3(int[] arr, int num) {
        int low = 0, high = arr.length -1;
        while (low < high) {
            int diff = num - (arr[low] + arr[high]);
            if (binarySearch(arr, diff)) return true;
            if ((arr[low] + arr[high]) > num) high--;
            else low++;
        }
        return false;
    }

    private static boolean binarySearch(int[] arr, int num) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low+ high) / 2;

            if (arr[mid] == num) return true;
            if (arr[mid] < num) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {-2,3,5,7,12};

        System.out.println(sum2(a, 17));
        System.out.println(sum2(a, 16));
        System.out.println(sum3(a, 17));
        System.out.println(sum3(a, 16));

    }
}
