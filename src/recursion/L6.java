package recursion;

import java.util.Arrays;

public class L6 {
    public boolean disco(boolean[] a, boolean[] b) {
        return disco(a, b, 0);
    }

    private boolean disco(boolean[] a, boolean[] b, int i) {
        // Stop conditions
        if (Arrays.equals(a, b)) return true;
        if (i == a.length) return false;

        // backtracking
        press(a, i);
        if (disco(a, b, i + 1)) return true;
        press(a, i);
        return disco(a, b, i + 1);
    }

    private void press(boolean[] a, int i) {
        a[i] = !a[i];
        if (i > 0) a[i-1] = !a[i-1];
        if (i < a.length -1) a[i+1] = !a[i+1];
    }

    public static int equalSum(int[] a, int i) {
        if (i == a.length) return -1;
        if (arrSum(a, 0, i) == arrSum(a, i, a.length)) return i - 1;
        return equalSum(a, i+ 1);
    }

    private static int arrSum(int[] a, int min, int max) {
        if (min == max) return 0;
        return a[min] + arrSum(a, min + 1, max);
    }

    public static int maxSumSnake(int[][] mat) {
        return maxSumSnake(mat, 5, 5);
    }

    private static int maxSumSnake(int[][] m, int x, int y) {
        if (x == 0 && y == 0) return 0;
        if (x == 0 || y == 0) return 1;

        return maxSumSnake(m, x - 1, y) + maxSumSnake(m, x, y - 1);
    }

    public static int edit (String str1, String str2) {
        if (str1.charAt(0) == str2.charAt(0)) return 0;

        int delete = edit(str1, str2);
        int add = edit(str1, str2);

        return Math.min(add, delete);
    }

    private static String diff(String s1, String s2) {
        if (s1.isEmpty() && s2.isEmpty()) return "";
        if (s1.isEmpty()) return s2;
        if (s2.isEmpty()) return s1;

        if (s1.charAt(0) == s2.charAt(0)) {
            return diff(s1.substring(1), s2.substring(1));
        }
        return diff(s1.charAt(0) + s1.substring(1), s2.substring(1));
    }

    public static boolean isJump(String str1, String str2, int k) {
        if (str2.isEmpty()) return true;
        if (str1.charAt(0) != str2.charAt(0)) return false;

        return isJump(str1.substring(k), str2.substring(1), k);
    }

    public int maxRow(int[][] mat) {
        return maxRow(mat, 0);
    }

    private int maxRow(int[][] mat, int i) {
        if (i == mat.length - 1) return i;

        int k = maxRow(mat, i + 1);

        if (sumRow(mat[k], 0) > sumRow(mat[i], 0)) return k;
        return i;
    }

    private int sumRow(int[] a, int i) {
        if (i == a.length) return 0;
        return a[i] + sumRow(a, i + 1);
    }

    public static boolean subSetSum(int[] a, int num) {
        return subSetSum(a, num, 0);
    }

    private static boolean subSetSum(int[] a, int num, int i) {
        if (num == 0) return true;

        if (i == a.length || a[i] > num) return false;

        if (subSetSum(a, num - a[i], i + 1)) return true;
        return subSetSum(a, num , i + 1);
    }


    public static int countPaths(int[][] mat) {
        return countPaths(mat, 0, 0);
    }

    private static int countPaths(int[][] mat, int i, int j) {
        if (i >= mat.length || j >= mat[i].length
                || mat[i][j] == 0) return 0;

        if (i == mat.length - 1 && j == mat[i].length) return 1;

        int big = mat[i][j] / 10;
        int small = mat[i][j] % 10;

        if (big == small) return countPaths(mat, i + big, i + small);
        return countPaths(mat, i + big, i + small) + countPaths(mat, i + small,i +  big);
    }

    public static void printPathWeights(int[][] mat) {
        printPathWeights(mat, 0, 0, 0);
    }

    private static void printPathWeights(int[][] mat, int i, int j, int sum) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length) return;
        if (mat[i][j] == -1) return;

        if (mat.length - 1 == i && mat[0].length - 1 == j) System.out.println(mat[i][j] + sum + " ");

        int temp = mat[i][j];
        mat[i][j] = -1;

        printPathWeights(mat, i + 1, j, sum + temp);
        printPathWeights(mat, i - 1, j, sum + temp);
        printPathWeights(mat, i, j + 1, sum + temp);
        printPathWeights(mat, i, j - 1, sum + temp);

        mat[i][j] = -1;
    }

    public static boolean isSumOf(int[] s, int n) {
        return isSumOf(s, n, 0, "");
    }

    private static boolean isSumOf(int[] s, int n, int i, String str) {
        if (n == 0) return true;
        if (i == s.length || n < 0) return false;

        if (s[i] == n) {
            System.out.println(s[i] + " " + str);
        }

        if (isSumOf(s, n - s[i], i, s[i] + " " + str)) return true;
        return isSumOf(s, n, i + 1, str);
    }

    public static int maxDeadEndSnake(int[][] m) {
        // Entry point for finding the longest path of connected cells that leads to a dead end.
        return maxDeadEndSnake(m, 0, 0);
    }

    private static int maxDeadEndSnake(int[][] m, int i, int j) {
        final int BEEN_HERE = -10;

        // If the current cell is a dead end, return 1.
        if (isDeadEnd(m, i, j)) {
            return 1;
        }

        // Mark the current cell as visited.
        int temp = m[i][j];
        m[i][j] = BEEN_HERE;

        int up = 0, down = 0, left = 0, right = 0;

        // Recursively search in all four possible directions.
        if (i - 1 >= 0 && Math.abs(temp - m[i - 1][j]) <= 1) {
            up = maxDeadEndSnake(m, i - 1, j);
        }
        if (i + 1 < m.length && Math.abs(temp - m[i + 1][j]) <= 1) {
            down = maxDeadEndSnake(m, i + 1, j);
        }
        if (j - 1 >= 0 && Math.abs(temp - m[i][j - 1]) <= 1) {
            left = maxDeadEndSnake(m, i, j - 1);
        }
        if (j + 1 < m[0].length && Math.abs(temp - m[i][j + 1]) <= 1) {
            right = maxDeadEndSnake(m, i, j + 1);
        }

        // Restore the original value of the current cell.
        m[i][j] = temp;

        // If all directions are dead ends, return 0.
        if (up == 0 && down == 0 && left == 0 && right == 0) {
            return 0;
        }

        // Return the length of the longest path found plus one for the current cell.
        int max = Math.max(Math.max(up, down), Math.max(left, right));
        return max + 1;
    }

    private static boolean isDeadEnd(int[][] m, int i, int j) {
        // Check if the cell has no valid moves (i.e., all adjacent cells are either out of bounds or differ by more than 1).
        if (i - 1 >= 0 && Math.abs(m[i][j] - m[i - 1][j]) <= 1) {
            return false;
        }
        if (i + 1 < m.length && Math.abs(m[i][j] - m[i + 1][j]) <= 1) {
            return false;
        }
        if (j - 1 >= 0 && Math.abs(m[i][j] - m[i][j - 1]) <= 1) {
            return false;
        }
        if (j + 1 < m[0].length && Math.abs(m[i][j] - m[i][j + 1]) <= 1) {
            return false;
        }
        return true;
    }



    public static void main(String[] args) {
        System.out.println("For call isSumOf(new int[] {4,9,3}, 9), result is " + isSumOf(new int[] {4,9,3}, 9));

    }
}
