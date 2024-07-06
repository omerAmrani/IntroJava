package recursion;

public class L1 {
    private static void binary(int n, String str) {
        if (n == 0) {
            System.out.println(str);
        } else {
            binary(n - 1, str + "a");
            binary(n - 1, str + "b");
            binary(n - 1, str + "c");
        }
    }

    public static int sum(int num) {
        if (num == 0) {
            return 0;
        } else {
            return num + sum(num - 1);
        }
    }

    public static int div(int num1, int num2) {
        if (num1 < num2) {
            return 0;
        } else {
            return 1 + div(num1 - num2, num2);
        }
    }

    public static void main(String[] args) {
        binary(3, "");
    }
}
