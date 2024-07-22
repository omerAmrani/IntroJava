package finalTests._2022;

public class _96 {
    public static int calc(int num, int result, int maxOp) {
        return calc(num, result, maxOp, "" + num, num);
    }

    private static int calc(int num, int result, int maxOp, String path, int currentValue) {
        if (currentValue > result || maxOp < 0) return 0;
        if (currentValue == result) {
            System.out.println(path + " = " + result);
            return 1;
        }

        maxOp--;
        return calc(num, result, maxOp, path + " + " + num, currentValue + num)
                + calc(num, result, maxOp, path + " - " + num, currentValue - num)
                + calc(num, result, maxOp, path + " * " + num, currentValue * num)
                + calc(num, result, maxOp, path + " / " + num, currentValue / num);
    }

    /**
     * with almost sorted array, check if there is a cell that equal to num.
     * Time lessons.complexity is O(log n), binary search.
     * The inner while loop will run max of K times, so it counts as O(1).
     * @param a array that is almost sorted by K:
     *          1. does not have negative numbers.
     *          2. if we ignore the zeros in the array, we will have sorted array.
     *          3. the longest zeros in a row will be K.
     * @param num
     * @return the index of the cell that equal to num, -1 if there isn't one.
     */
    public static int KAlmostSearch(int[] a, int num) {
        final int NOT_FOUND = -1;
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            // move right until no zero is met
            while (mid <= right && a[mid] == 0) {
                mid++;
            }

            if (mid > right) {
                mid--;
                // if it's not on the right than we have reach the end, and
                // we need to check the left side of the 0
                while (mid >= left && a[mid] == 0) {
                    mid--;
                }
                if (mid < left) return NOT_FOUND;
            }

            if (a[mid] == num) return mid;
            if (a[mid] < num) left = ((left + right) / 2) + 1;
            else right = ((left + right) / 2) - 1;
        }

        return NOT_FOUND;
    }

    public static void main(String[] args) {
        System.out.println(calc(3,3,4));
    }
}
