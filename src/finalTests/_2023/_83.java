package finalTests._2023;

public class _83 {

    public static String minimalSt(String s1, String s2) {
        boolean isS1Smaller = s1.length() < s2.length();
        String small = isS1Smaller ? s1 : s2;
        String big = isS1Smaller ? s2 : s1;
        return minimalSt(small, big, "");

    }

    private static String minimalSt(String small, String big, String s) {
        if (small.length() == 0) return s + big;

        if (small.charAt(0) == big.charAt(0)) {
            small = small.substring(1);
        }

        s += big.charAt(0);
        big = big.substring(1);


        if (big.length() < small.length()) {
            String temp = small;
            big = small;
            small = temp;
        }

        return minimalSt(small, big, s);

    }

    public static int findSmallestSubArrayLen(int[] arr, int num) {
        int low = 0, high = 0, min = arr.length, sum = arr[high];

        while (low <= high && high < arr.length) {
            if (sum > num) {
                System.out.println(low + " to " + high + " is " + sum);
                if (high - low + 1 < min ) min = high - low + 1;
                sum -= arr[low];
                low++;
            }
            else {
                high++;
                if (high < arr.length) sum += arr[high];
            }
        }
        return high - low + 1;
    }

    public static void main(String[] args) {
//        int[] a = {2,6,1,9,7,3,1,4,1,8};
//
//        System.out.println(findSmallestSubArrayLen(a, 15));

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(minimalSt(s1, s2));
    }


}
