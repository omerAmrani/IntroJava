package mmn._13;


import static mmn._13.Ex13.findPassword;
import static mmn._13.Ex13.findSingle;

public class Tests {
    public static void main(String[] args) {
        test3();
    }

    public static void test3() {
        Password pass = new Password("azaz");
        System.out.println(pass.getPassword());
        System.out.println(findPassword(pass, 4));
    }

    private static void test(int[] array, int expected, String testName) {
        int result = findSingle(array);
        if (result == expected) {
            System.out.println("Passed : " + testName);
        } else {
            System.out.println("Failed (Expected " + expected + ", got " + result + ")" + testName);
        }
    }

    public static void test1() {
//        test(new int[]{1}, 1, "Single element");
        test(new int[]{1, 1, 2}, 2, "Single at end");
        test(new int[]{2, 1, 1}, 2, "Single at start");
        test(new int[]{1, 1, 2, 2, 3}, 3, "Single at the end after pairs");
        test(new int[]{3, 1, 1, 2, 2}, 3, "Single at start with pairs after");
        test(new int[]{1, 1, 2, 3, 3}, 2, "Single in middle");
        test(new int[]{1, 1, 2, 2, 3, 3, 4}, 4, "Single at end with multiple pairs");
        test(new int[]{4, 2, 2, 3, 3}, 4, "Single at start with multiple pairs");
        test(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5}, 5, "Long array with single at end");
        test(new int[]{5, 1, 1, 2, 2, 3, 3, 4, 4}, 5, "Long array with single at start");
    }

    public static void test2() {
        test(new int[]{0}, 0, "No walls");
        test(new int[]{1, 2, 3, 4, 5}, 0, "Monotonically increasing");
        test(new int[]{5, 4, 3, 2, 1}, 0, "Monotonically decreasing");
        test(new int[]{3, 3, 3, 3}, 0, "Flat surface");
        test(new int[]{3, 1, 2, 1, 3}, 5, "One big pool");
        test(new int[]{4, 1, 3, 1, 4, 2, 1, 3}, 10, "Multiple pools");
        test(new int[]{2, 1, 1, 4, 1, 5, 1, 1, 2, 3}, 10, "Complex multiple pools");
        test(new int[]{5, 1, 4, 2, 3, 2, 4, 1, 5}, 18, "High boundary walls");
        test(new int[]{3, 3, 2, 3, 3}, 1, "Center dip");
        test(new int[]{1, 1, 1, 1, 10, 1, 1, 1, 1}, 0, "Deep single dip");
    }
}
