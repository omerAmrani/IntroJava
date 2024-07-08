package finalTests._2023;

public class _85 {
    final static char CHAR_A = '(';
    final static char CHAR_B = ')';

    public static int countPairs (int n) {
        return countPairs(n * 2 , "");
    }

    private static int countPairs(int n, String str) {
        if (str.length() == n) return isValid(str);

        return countPairs(n, str + CHAR_A) + countPairs(n, str + CHAR_B);
    }

    // combine the conditions for valid string
    private static int isValid(String str) {
        int countA = countChar(str, CHAR_A);
        int countB = countChar(str, CHAR_B);

        if (countB == countA && checkStart(str)) {
            System.out.println(str);
            return 1;
        }
        return 0;
    }

    // check that there is always more '(' than ')' on the given string
    private static boolean checkStart(String str) {
        if (str.length() == 0) return true;

        int countA = countChar(str, CHAR_A);
        int countB = countChar(str, CHAR_B);

        if (countB < countA) return false;
        return checkStart(str.substring(1));
    }

    // count how many chars are in a string
    private static int countChar(String str, char c) {
        if (str.length() == 0) return 0;
        if (str.charAt(0) == c) return countChar(str.substring(1), c) + 1;
        return countChar(str.substring(1), c);
    }

    public static void main(String[] args) {
        System.out.println(countPairs(4));
    }


    /**
     * Remove cells from K until reach 0.
     * time complexity of O(n).
     * @param arr
     * @param k
     * @return
     */
    public static boolean superInc (int [] arr, int k) {
        int sum = k;

        for (int i = arr.length - 1; i >= 0; i++) {
            if (arr[i] <= sum) sum -= arr[i];
            if (sum == 0) return true;
        }
        return false;
    }
}
