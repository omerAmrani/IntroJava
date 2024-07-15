package finalTests._2014;

public class _85 {
    public static boolean what(int n) {
        return (f(n) % 2 == 0);
    }

    private static int f(int n) {
        int count = 1;
        for (int i = 2; i <= n ; i++) {
            if (n % i == 0) count++;
        }
        return count;
    }

}
