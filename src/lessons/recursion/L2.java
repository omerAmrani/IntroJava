package lessons.recursion;

public class L2 {
    public static int necklace(int n) {

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return necklace(n - 1) + necklace(n - 2);
        }
    }

    public static int strings(int n) {
        // for abcd
        if (n == 1) {
            return 4;
        }
        return 4 * strings(n - 1);
    }

//    public static int strings(int n)  {
//        return strings(n, "");
//    }
//
//    private static int strings(int n, String s)  {
//        if (n == 0) // הגענו למחרוזת באורך הנדרש, נוסיף אחד לספירה
//            return 1;
//        return strings(n - 1, s + 'a') +
//                strings(n - 1, s + 'b') +
//                strings(n - 1, s + 'c') +
//                strings(n - 1, s + 'd');
//    }

    public static int odd(int num) {
        if (num < 10) {
            if (num % 2 != 0) {
                return 1;
            } else return 0;
        }
        return odd(num % 10) + odd(num / 10);
    }

    public static int biggest(int num1, int num2) {
        return Integer.parseInt(biggestChar(num1, num2));
    }

    public static String biggestChar(int num1, int num2) {
        if (num1 < 10) {
            return Math.max(num1, num2) + "";
        }
        return biggest(num1 / 10, num2 / 10) + biggestChar(num1 % 10, num2 % 10);
    }


    public static int times(String s, char ch) {
        if (s.length() == 1) {
            if (s.charAt(0) == ch) {
                return 1;
            } else return 0;
        }
        return times(s.substring(1), ch) + times(s.substring(0, 1), ch);
    }


    public static boolean hasOne(int num) {
        if (num < 10)
            return num == 1;
        return num % 10 == 1 || hasOne(num / 10);
    }

    public static String noNumbers(String s) {
        if (s.isEmpty()) {
            return "";
        }
        if (s.charAt(0) >= '1' && s.charAt(0) <= '9') {
            return noNumbers(s.substring(1));
        }
        return s.charAt(0) + noNumbers(s.substring(1));
    }

    public static boolean upString(String s) {
        if (s.length() < 2) {
            return true;
        }
        if (s.charAt(0) > s.charAt(1)) {
            return false;
        }
        return upString(s.substring(1));
    }


    public static boolean isStringOk(String s) {
        if (s.length() < 2) {
            return true;
        }
        if (s.charAt(0) >= '1' && s.charAt(0) <= '9') {
            return onlyNumbers(s.substring(1));
        }
        if ((s.charAt(0) >= 'a' && s.charAt(0) <= 'z') || (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z')) {
            return onlyChars(s.substring(1));
        }

        return false;
    }

    private static boolean onlyNumbers(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (!(s.charAt(0) >= '1' && s.charAt(0) <= '9')) {
            return false;
        }
        return onlyNumbers(s.substring(1));
    }

    private static boolean onlyChars(String s) {
        if (s.isEmpty()) {
            return true;
        }

        char first = s.charAt(0);
        boolean is_az = first >= 'a' && first <= 'z';
        boolean is_AZ = first >= 'A' && first <= 'Z';

        if (!is_az && !is_AZ) {
            return false;
        }
        return onlyChars(s.substring(1));
    }

    public static int compare(String s1, String s2) {
        if (s1.isEmpty() && s2.isEmpty())
            return 0;
        if (s1.isEmpty() && !s2.isEmpty())
            return 1;
        if (!s1.isEmpty() && s2.isEmpty())
            return -1;
        if (s1.charAt(0) == s2.charAt(0))
            return compare(s1.substring(1), s2.substring(1));
        if (s1.charAt(0) < s2.charAt(0))
            return 1;
        else
            return -1;
    }


    public static boolean up(String s) {
        if (s.length() <= 2) {
            return true;
        }
        if (s.charAt(0) >= s.charAt(2)) {
            return false;
        }
        return up(s.substring(1));
    }

    public static void main(String[] args) {
        System.out.println("For call up(\"cbdbf\"), result is " + up("cbdbf"));

    }
}
