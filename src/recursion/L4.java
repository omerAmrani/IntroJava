package recursion;

public class L4 {
    public static double halfMin(double[] a) {
        return halfMin(a, 0, a[0]);
    }

    private static double halfMin(double[] a, int i, double min) {
        if (i == (a.length + 1) / 2) {
            return min;
        }
        if (a[i] < min) {
            min = a[i];
        }
        return halfMin(a, i + 1, min);
    }


    public static int maxEven(int[] a) {
        return maxEven(a, 0);
    }

    private static int maxEven(int[] a, int i) {
        if (i >= a.length) {
            return a[i - 2];
        }

        int max = maxEven(a, i + 2);
        return Math.max(a[i], max);

    }

    public static boolean twoAscending(int[] a) {
        if (a.length < 3) return true;
        return twoAscending(a, 0);
    }

    private static boolean twoAscending(int[] a, int i) {
        if (i + 2 >= a.length) {
            return true;
        }
        if (a[i] >= a[i + 2]) {
            return false;
        }

        return twoAscending(a, i + 1);
    }

    public static boolean zigzag(int[] a) {
        return zigzag(a, 0);
    }

    private static boolean zigzag(int[] a, int i) {
        if (a.length == i + 1) {
            return true;
        }

        boolean by2 = i % 2 == 0;
        boolean isEven = by2 && a[i] < a[i + 1];
        boolean isOdd = !by2 && a[i] > a[i + 1];

        if (isEven || isOdd) {
            return zigzag(a, i + 1);
        }
        return false;
    }

    public static boolean quadPrime(int[] a) {
        if (a.length % 4 != 0) return false;
        return quadPrime(a, 0);
    }

    private static boolean quadPrime(int[] a, int i) {
        if (a.length - i == 4) return true;

        int firstSum = a[i] * a[i + 1] * a[i + 2] * a[i + 3];
        int second = a[i + 4] * a[i + 5] * a[i + 6] * a[i + 7];

        if (firstSum == second) {
            return quadPrime(a, i + 4);
        }
        return false;
    }

    public static boolean similarK(int[] a, int[] b, int k) {
        return similarK(a, b, k, 0);
    }

    private static boolean similarK(int[] a, int[] b, int k, int i) {
        if (a.length == i) return true;
        return (a[i] % k == b[i] % k) && similarK(a, b, k, i + 1);
    }

    public static boolean isInIt(int num1, int num2, int num3) {
        return isIn(num2, num1) && isIn(num3, num1);
    }

    private static boolean isIn(int small, int big) {
        if (big < 100) return false;

        int temp = big % 1000;
        if (temp == small) return true;

        return isIn(small, big / 10);

    }

    public static int max(int[][] a) {
        return max(a, 0, 0);
    }

    private static int max(int[][] a, int i, int j) {
        if (i == a.length - 1 && j == a[i].length - 1) {
            return a[i][j];
        }

        if (j == a[i].length) {
            j = 0;
            i++;
        }
        int max = max(a, i, j + 1);
        return Math.max(a[i][j], max);
    }


    public static void main(String[] args) {
        System.out.println(max(new int[][]{{7, 2, 3}}));
    }


}
