package finalTests._2017;

public class _87 {
    public static boolean isPythagorean(int[] arr) {

        int low = 0, high = arr.length -1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (pow(arr[mid - 1]) + pow(arr[mid]) == pow(arr[mid + 1])) {
                System.out.println(arr[mid - 1] + " " + arr[mid] + " " + arr[mid + 1]);
                return true;
            }
            else if (pow(arr[mid - 1]) + pow(arr[mid]) > pow(arr[mid + 1])) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }

    private static int pow(int num) {
        return (int) Math.pow(num, 2);
    }

    public static void main(String[] args) {
        int[] a = {1,3,4,5,6};
        int[] b = {4,5,6,10,12};

        System.out.println(isPythagorean(a));
        System.out.println(isPythagorean(b));
    }
}

