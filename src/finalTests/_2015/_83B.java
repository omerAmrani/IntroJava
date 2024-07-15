package finalTests._2015;

import java.util.Arrays;

public class _83B {
    public static void replace(int[] a) {
        int max = 0;
        for (int i = a.length -1; i >= 0; i--) {
            if (a[i] > max) {
                int temp = max;
                max = a[i];
                a[i] = temp;
            }
            else a[i] = max;
        }
    }

    public static void main(String[] args) {;
        int[] a = {6,7,4,3,5,2};
        replace(a);
        System.out.println(Arrays.toString(a));
    }
}
