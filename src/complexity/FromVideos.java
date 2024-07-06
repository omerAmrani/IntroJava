package complexity;

public class FromVideos {
    /**
     * count substring that start and ends in c in string
     * @param s
     * @param c
     * @param k how many c can appear between start and end
     * @return
     */
    public static int subStrMaxC(String s, char c, int k) {
        int counter = 0;
        int countWords = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == c) {
                if (counter > 0) countWords += Math.min(k + 1, counter);
                counter++;
            }
        }

        return countWords;
    }



    /**
     * in a sorted mat, in up from lines and columns
     * @param mat
     * @return how many negative numbers are in the mat
     */
    public static int howManyNegativeNumbers(int[][] mat) {
        int i = 0;
        int j = mat[0].length - 1;
        int count = 0;

        while (j >= 0 && i < mat.length) {
            if (mat[i][j] < 0) {
                count = j + 1;
                i++;
            }
            else j--;
        }

        return count;
    }


    /**
     * X include in Y if every digit in X is appearing in Y expect K
     * digits that are in X and not in Y, if digit is appeared more than once
     * than its enough that its appears once.
     * Example: 4342113 is 2 include in 45111 because other than 3, 2
     * every digit in the first numbers also in the second.
     * @param x
     * @param y
     * @return K
     */
    public static int included(int x, int y) {
        boolean[] digits = new boolean[10];
        int k = 0;

        // counts which digits are in X
        while (y > 0) {
            digits[y % 10] = true;
            y /= 10;
        }
        // counts which digits are in Y
        while (x > 0) {
            digits[x % 10] = false;
            x /= 10;
        }

        // The only true in the digits array is the ones that are on X and not on Y
        for (int i = 0; i < digits.length; i++) {
            if (digits[i]) k++;
        }

        return k;

    }
}
