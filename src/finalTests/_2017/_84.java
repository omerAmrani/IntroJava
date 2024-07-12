package finalTests._2017;

public class _84 {
    public static boolean findSum(int[] a, int sum) {
        int start = 0;
        // find where the array has moved
        for (int k = 1; k < a.length; k++) {
            if (a[k] < a[k -1]) {
                start = k;
                break;
            }
        }

        int i = start, j, end;
        if (i == 0) end = a.length;
        else end = start;
        j = end -1;

        while (i <= end ) {
            int temp = a[i] + a[j];
            if (temp == sum) return true;

            else if (temp > sum) {
                // reset the j
                if (j == 0) j = a.length -1;
                else j--;
            }
            else if (i == a.length -1) i =0;
            else i++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {65,70,-5,3,48,49,52};
        System.out.println(findSum(a, 44));
        System.out.println(findSum(a, 45));
    }
}
