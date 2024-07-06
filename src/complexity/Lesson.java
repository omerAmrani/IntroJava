package complexity;

public class Lesson {
    // 2 index
    public static boolean hasAll(int[] a, int[] b) {
        if (a.length < b.length) return false;

        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] == b[i]) j++;
            i++;
        }
        return j == b.length;
    }

    // sum
    public static boolean equalParts(int[] a) {
        int sumAll = 0;
        int current = 0;

        for (int i = 0; i < a.length; i++) {
            sumAll += a[i];
        }

        for (int i = 0; i < a.length; i++) {
            current += a[i];
            if (current == sumAll - current) return true;
        }

        return false;
    }

    // use other array as index
    public static boolean dup(int[] a,int m) {
        if (a.length > m + 1) return true;

        boolean[] b = new boolean[m + 1];

        for (int i = 0; i < a.length; i++) {
            if (b[a[i]]) return true;
            b[a[i]] = true;
        }
        return false;
    }


    // 2 index
    public static boolean sum(int[] a,  int[] b, int num)  {
        int i = 0;
        int j = b.length - 1;

        while (i < a.length && j >= 0) {
            int temp = a[i] + b[j];

            if (temp == num) return true;
            if (temp > num) j--;
            else i++;
        }
        return false;
    }


    public static int binarySearch(int[] a, int x) {
        int left = 0;
        int right = a.length -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (a[mid] == x) return mid;
            if (a[mid] < x) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
