package finalTests._2021;

public class _92 {
    public static int printExpr(int[] arr, int num) {
        return printExpr(arr, num, arr[0], "" + arr[0], 0);
    }

    private static int printExpr(int[] arr, int num, int val, String path, int i) {
        if (val > num || i >= arr.length) return 0;
        if (val == num) {
            System.out.println(path);
            return 1;
        }

        return printExpr(arr, num, val + arr[i], path + " + " + arr[i], i + 1)
                + printExpr(arr, num, val + arr[i], path + " + " + arr[i] , i + 2)
                + printExpr(arr, num, val - arr[i], path + " - " + arr[i], i + 1)
                + printExpr(arr, num, val - arr[i], path + " - " + arr[i], i + 2);
    }

    public static int longestSequence(int[] arr, int k) {
        int count = 0, kCount = k, max = 0, ki = 0, kj = 0;
        int[] zeros = new int[arr.length]; //TODO should be different size

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                if (count > max) max = count;
            }
            else {
                zeros[ki] = i;
                ki++;
                kCount--;
                if (kCount < 0) {
                    count -= zeros[kj];
                }
            }

        }

        return max;
    }

    public static void main(String[] args) {
        int[] a = {1,3,6,2};
        int[] b = {1,1,0,1,1,0,1,1,1,1,0,0};

        System.out.println(longestSequence(b, 0));
        System.out.println(longestSequence(b, 1));
        System.out.println(longestSequence(b, 2));
        System.out.println(longestSequence(b, 3));
        System.out.println(longestSequence(b, 4));
//        System.out.println(printExpr(a, 3));
    }
}
