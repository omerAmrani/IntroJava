package finalTests._2017;

public class _85 {
    public static void printClosest(int[] a, int[] b, int x) {
        int i = 0, j = b.length -1;
        int iClose = 0, jClose = 0;
        int diff = Integer.MAX_VALUE;

        while (i < a.length && j >= 0) {
            int temp = a[i] + b[j] - x;
            if (temp < diff) {
                iClose = i;
                jClose = j;
                diff = temp;
            }

            if (a[i] + b[j] > x) j--;
            else i++;
        }

        System.out.println(iClose + " and " + jClose + " is closet");
    }
}
