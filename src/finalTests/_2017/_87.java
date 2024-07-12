package finalTests._2017;

public class _87 {
    public static boolean isPythagorean(int[] arr) {
        for (int i = arr.length -1; i > 1; i--) {
            int low = 0, high = i -1;
            while (low < high) {
                int sum = pow(arr[low]) + pow(arr[high]);
                if (sum == pow(arr[i])) {
                    System.out.println(arr[low] + " " + arr[high]);
                    return true;
                }
                else if (sum > pow(arr[i])) high--;
                else low++;
            }
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

