package finalTests._2018;

import java.util.Arrays;

public class _91 {
    public static void sortMod(int[] a, int k) {
        int sorted_index = 0;

        for (int i = 0; i < k; i++) {
            // k size loop
            for (int j = sorted_index; j < a.length; j++) {

                if (a[j] % k == i) {
                    // Swaps between both elements.
                    int tempVal = a[sorted_index];
                    a[sorted_index] = a[j];
                    a[j] = tempVal;
                    sorted_index++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {35,17,13,252,4,128,7,3,81};

        sortMod(a, 10);
        System.out.println(Arrays.toString(a));
    }
}
