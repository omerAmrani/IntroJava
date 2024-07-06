package finalTests._2022;

public class _89 {
    // Finished
    public static boolean isJump(String str1, String str2, int step) {
        if (str1.length() < str2.length()) return false;
        return isJump(str1, str2, step, 0);
    }

    private static boolean isJump(String str1, String str2, int step, int i) {
        if (step > str1.length()) return true;
        if (i == str2.length()) return true;
        if (str1.charAt(0) != str2.charAt(i)) return false;
        return isJump(str1.substring(step), str2, step, i + 1);
    }

    public static int strStep(String str1, String str2) {
        return strStep(str1, str2, 1);
    }

    private static int strStep(String str1, String str2, int step) {
        if (step > str1.length()) return -1;
        if (isJump(str1, str2, step)) return step;

        int otherStep = strStep(str1, str2,step + 1);
        if (otherStep != -1) return otherStep;
        return strStep(str1, str2, step + 2);
    }

    /**
     * O(n)
     * @param a
     * @return
     */
    public static int longestSubArray(int[] a) {
        int left = 0, right = 0;
        int maxLeft = left, maxRight = right;

        while(left <= right && right < a.length -1) {
            boolean pos = a[right] > 0 && a[right + 1] < 0;
            boolean neg = a[right] < 0 && a[right + 1] > 0;

            if (pos || neg) right++;
            else left++;

            if (right - left > maxRight - maxLeft) {
                maxRight = right;
                maxLeft = left;
            }
        }

        System.out.println("Starting index: " + maxLeft + " Ending index: " + maxRight);
        // for the missing single place
        return maxRight - maxLeft + 1;
    }

    // 3 Trace on iPad

    public static void main(String[] args) {
        int[] a = {-1, 1,-1,-5,2,2};
        int[] b = {3,3,2,-7,2,1,1,-2,-2};
        int[] c = {1,2,3,4,5};
        int[] d = {1,-2,3,-4,-5,4,2,-4,6,-2};

        System.out.println(longestSubArray(a));
        System.out.println(longestSubArray(b));
        System.out.println(longestSubArray(c));
        System.out.println(longestSubArray(d));


//        String str1 = "abc";

//        String str2 = "adbrcfa";
//        String str3 = "cbdadbrcfa";
//        String str4 = "adcfbaagcxabcd";
//        String str5 = "abcfbaagcxabcd";

//        System.out.println(isJump(str2, str1, 2));
//        System.out.println(isJump(str3, str1, 2));
//        System.out.println(isJump(str4, str1, 4));
//        System.out.println(isJump(str5, str1, 1));

//        String str2 = "adbrcfa";
//        String str3 = "cbdadbrcfa";
//        String str4 = "adcfbaagcxabcd";
//        String str5 = "abcfbaagcxabcd";
//
//        System.out.println(strStep(str2, str1));
//        System.out.println(strStep(str3, str1));
//        System.out.println(strStep(str4, str1));
//        System.out.println(strStep(str5, str1));
    }
}
