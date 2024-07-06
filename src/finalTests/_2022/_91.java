package finalTests._2022;

public class _91 {
    // Finished

    public static int findTriplets(int[] arr) {
        int a =0, b = 1, c =2;
        int max = arr[a] * arr[b] * arr[c];
        int temp;

        for (int i = c; i < arr.length; i++) {
            temp = arr[a] * arr[b] * arr[i];
            if (temp > max) {
                max = temp;
                c = i;
            }
        }

        for (int i = b; i < arr.length - 1; i++) {
            temp = arr[a] * arr[i] * arr[c];
            if (temp > max) {
                max = temp;
                b = i;
            }
            if (i + 1 == c) i++;
        }

        for (int i = a; i < arr.length - 2; i++) {
            temp = arr[i] * arr[b] * arr[c];
            if (temp > max) {
                max = temp;
                a = i;
            }
            if (i + 1 == b) i++;
            if (i + 1 == c) i++;
        }

        System.out.println(arr[a] + " " + arr[b] + " " + arr[c]);
        return max;
    }

    public static int cheapRt(int[] stations, int step1, int step2, int limit) {
        return cheapRt(stations, step1, step2, limit, 0, "", 0);
    }

    private static int cheapRt(int[] stations, int step1, int step2, int limit, int i, String path, int min) {
        if (i >= stations.length) return Integer.MAX_VALUE;
        path += i + " ";
        min += stations[i];

        if (i == stations.length - 1) {
            System.out.println(path +  "  = " + min);
            return min;
        }

        int val1 = cheapRt(stations, step1, step2, limit, i + step1, path, min);
        if (limit > 0) {
            int val2 = cheapRt(stations, step1, step2, limit - 1, i + step2, path, min);
            return Math.min(val1, val2);
        }
        return val1;
    }

    // 3, 5 on iPad


    public static void main(String[] args) {
        int[] a = {-4,1,-8,9,6};
        int[] b = {2,4,8,3,10,1,12,3,2};

        System.out.println(cheapRt(b, 3,2, 4));
    }
}
