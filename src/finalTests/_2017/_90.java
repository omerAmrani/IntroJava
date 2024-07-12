package finalTests._2017;

public class _90 {
    public static int findSmallest(int[] arr) {
        int res = 1;
        for (int i = 0; i < arr.length && arr[i] <= res; i++) {
            res += arr[i];
        }
        return res;
    }
}
