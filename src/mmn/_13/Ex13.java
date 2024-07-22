package mmn._13;

/**
 * This class holds static methods for MMN 13
 *
 * @author Omer Amrani
 * @version 24.05.2024
 */
public class Ex13 {

    /**
     * This method finds the single element in an array of pairs.
     * The time lessons.complexity is O(log n) because of the binary search.
     * The space lessons.complexity is O(1)
     *
     * @param a The array of pairs and one single.
     * @return The single element.
     */
    public static int findSingle(int[] a) {
        // If the array has only one element, it's the single.
        if (a.length == 1) return a[0];

        int left = 0;
        int right = a.length -1;

        while (left < right) {
            int mid = (left + right) / 2;

            // to always check pairs
            if (mid % 2 == 1)  mid--;

            // If we found a pair, search in the right part, move the left
            // move it in 2 to get the next pair
            if (a[mid] == a[mid + 1]) {
                left = mid + 2;
            }
            // Single element is on the left side, we move the right towards the left
            else {
                right = mid ;
            }
        }

        // left is the single
        return a[left];
    }


    /**
     * This method calculates how much units of water can be inside the array
     * The time lessons.complexity of this method is O(n) where n is the length of the array,
     * since we iterate through the array once.
     * The space lessons.complexity is O(1) since we only use the variables left, right, maxLeft, maxRight and units.
     *
     * @param heights array that describe a tool for accumulate water
     * @return how much units of water can be inside the array
     */
    public static int waterVolume(int[] heights) {
        // if length is less the 3 it can't have a pool
        if (heights.length < 3) return 0;
        int units = 0;
        int max = heights[0];

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > max) max = heights[i];
            else {
                units +=  max - heights[i];
            }
        }


        return units;


        /*
        int left = 0;
        int right = heights.length - 1;
        int maxLeft = heights[left];
        int maxRight = heights[right];
        int units = 0;

        // until the left and right are coming together (end of the search),
        // move the left into the right and right into the left
        while (left < right) {
            // the left is the limiting border
            if (heights[left] <= heights[right]) {
                // if the left is a new max, set it, else calculate water
                if (heights[left] > maxLeft) {
                    maxLeft = heights[left];
                } else {
                    units += maxLeft - heights[left];
                }
                left++;
            }
            // the right is the limiting border
            else {
                // if the right is a new max, set it, else calculate water
                if (heights[right] >= maxRight) {
                    maxRight = heights[right];
                } else {
                    units += maxRight - heights[right];
                }
                right--;
            }
        }
        return units;
        */

    }

    /**
     * Attempts to find the correct password by generating all possible strings
     * of a given length and checking each one.
     *
     * @param p the Password object
     * @param length the length of the password to be generated and checked
     * @return the cracked password
     */
    public static String findPassword (Password p, int length) {
        String s = getStringInLength("", length);
        return findPassword(p, s, 0);
    }

    /**
     * Recursive method that attempts to find the correct password by incrementing
     * characters in the string and recursively checking each possibility.
     *
     * @param p the Password object
     * @param s the current string being checked
     * @param index the current index in the string to be incremented
     * @return the correct password if found, otherwise an empty string
     */
    private static String findPassword(Password p, String s, int index) {
        if (p.isPassword(s)) return s;

        // the boundaries of the lessons.recursion
        if (index == s.length() || s.charAt(index) == 'z') return "";

        // increase the char at the index
        char increaseChar = (char) (s.charAt(index) + 1);
        s = s.substring(0, index) + increaseChar + s.substring(index + 1);

        // try with the new char and spilt the lessons.recursion
        String s1 = findPassword(p, s, index);

        if (s1.length() > 0) return s1;
        return findPassword(p, s, index + 1);
    }

    /**
     * Get base string in length to edit in the findPassword function
     *
     * @param str base string to append to
     * @param length the required length
     * @return string of 'a' in the length
     */
    private static String getStringInLength(String str, int length) {
        if (str.length() == length) {
            return str;
        } else {
            return getStringInLength(str + "a", length);
        }
    }


    /**
     * Counts the number of connected true sections in the matrix.
     *
     * @param mat the 2D boolean array
     * @return the number of connected true sections
     */
    public static int cntTrueReg (boolean[][]mat) {
        return cntTrueReg(mat, 0, 0, 0);
    }

    /**
     * Recursive method that counts the number of connected true sections in the matrix.
     *
     * @param mat the 2D boolean array
     * @param i the current row index
     * @param j the current column index
     * @param count the current count of true sections
     * @return the current count of true sections
     */
    private static int cntTrueReg (boolean[][]mat, int i, int j, int count) {
        // end of the mat
        if (i == mat.length) return count;

        // go to the next row
        if (j == mat[i].length ) return cntTrueReg(mat, i + 1, 0, count);

        if (mat[i][j]) {
            count++;
            fillFalse(mat, i, j);
        }

        return cntTrueReg(mat, i, j + 1, count);
    }

    /**
     * Fill the cells next to true
     * until it reach only false cells
     *
     * @param mat the 2D array
     * @param i the current row index
     * @param j the current column index
     */
    private static void fillFalse(boolean[][] mat, int i, int j) {
        // Stop when reach boundaries or encounter false
        if (i < 0 || j < 0
                || i >= mat.length || j >= mat[i].length
                // stop when u encounter false
                ||  !mat[i][j]) return;

        mat[i][j] = false;

        fillFalse(mat, i + 1, j);
        fillFalse(mat, i - 1, j);
        fillFalse(mat, i, j + 1);
        fillFalse(mat, i, j - 1);
    }
}
