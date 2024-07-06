package recursion;

public class L3 {
    public static double mul(double[] a) {
        return mul(a, 0);
    }

    private static double mul(double[] a, int i) {
        if (a.length == i) {
            return 1;
        }
        return a[i] * mul(a, i + 1);
    }

    public static void reverse(int[] a) {
        reverse(a, 0);
    }

    private static void reverse(int[] a, int i) {
        if (i > (a.length) / 2) {
            return;
        }
        int temp = a[i];
        a[i] = a[a.length - 1 - i];
        a[a.length - 1 - i] = temp;
        reverse(a, i + 1);
    }


    public static boolean count(int[] a1, int[] a2) {
        return count(a1, a2, 0);
    }


    private static boolean count(int[] a1, int[] a2, int i) {
        if (i == a1.length) {
            return true;
        }
        boolean not2digit = a1[i] > 9 && a1[i] < 100 && a2[i] != 2;
        boolean not1digit = a1[i] > -1 && a1[i] < 10 && a2[i] != 1;

        if (not1digit || not2digit) {
            return false;
        }

        return count(a1, a2, i + 1);
    }

    public static void palindrome(int[] a) {
        print(a, 0);
    }

    private static void print(int[] a, int i) {
        if (i < a.length) {
            System.out.print(a[i] + " ");
            print(a, i + 1);
            System.out.print(a[i] + " ");
        }
    }

    public static boolean kArray(int[] a) {
        if (a.length < 3) return true;
        return kArray(a, 0);
    }

    private static boolean kArray(int[] a, int i) {
        if (i == a.length - 2) {
            return true;
        }
        if (Math.pow(a[i] - a[i + 1], 2) != Math.pow(a[i + 1] - a[i + 2], 2)) {
            return false;
        }
        return kArray(a, i + 1);
    }

    public static int smallest(int[] a) {
        return smallest(a, 0, 0);
    }

    private static int smallest(int[] a, int i, int min) {
        if (i == a.length) {
            return min;
        }
        if (a[i] < a[min]) {
            min = i;
        }
        return smallest(a, i + 1, min);
    }

    public static void main(String[] args) {

        int[] a = {2, 0};
        System.out.println(smallest(a));
    }
}
