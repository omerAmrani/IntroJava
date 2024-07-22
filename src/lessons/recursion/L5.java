package lessons.recursion;

public class L5 {

    public static String strings(String s1, String s2) {
        if (s1.isEmpty() && s2.isEmpty()) {
            return "";
        }

        String c1 = "";
        String c2 = "";

        if (!s1.isEmpty() && s2.isEmpty()) {
            c1 += s1.charAt(0);
            return c1 + "" + strings(s1.substring(1), s2);
        }
        if (s1.isEmpty()) {
            c2 += s2.charAt(0);
            return c2 + "" + strings(s1, s2.substring(1));
        }
        c1 += s1.charAt(0);
        c2 += s2.charAt(0);

        return c1 + "" + c2 + "" + strings(s1.substring(1), s2.substring(1));
    }


    public static int distance(String s1, String s2) {
        if (contains(s1, s2)) return s2.length() - s1.length();
        return -1;
    }

    private static boolean contains(String s1, String s2) {
        if (s1.isEmpty()) return true;
        if (s2.isEmpty()) return false;

        if (s1.charAt(0) == s2.charAt(0)) {
            return contains(s1.substring(1), s2.substring(1));
        } else {
            return contains(s1, s2.substring(1));
        }
    }

    public static boolean match (int [] a, int [] pattern) {
        return match(a, pattern, 0);
    }

    private static boolean match (int [] a, int [] pattern, int i) {
        if (i == pattern.length) return true;
        if (inArray(pattern[i], a, 0)) {
            return match(a, pattern, i +1);
        }
        return false;
    }

    private static boolean inArray(int pattern, int[] a, int i) {
        if (i == a.length) return false;

        boolean single = a[i] >= 0 && a[i] < 10;
        boolean doubleDigit = a[i] > 9 && a[i] < 100;

        if (pattern == 0 & (single || doubleDigit)) return true;
        if (pattern == 1 && single) return true;
        if (pattern == 2 && doubleDigit) return true;

        return inArray(pattern, a, i + 1);
    }


    public static int howManySorted(int n, int max) {
        if (max == 1) return 1;
        if (n == 1) return max;
        return howManySorted(n- 1, max) + howManySorted(n, max - 1);

    }

    public static void main(String[] args) {
        System.out.println(distance("bcg", "bcd"));
    }
}
