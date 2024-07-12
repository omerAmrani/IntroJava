package finalTests._2023;

public class _57 {

    // 1 2

    // Hard
    public static int selectedPrimes(int num, int x) {

        return selectedPrimes(num, x, 2, 0);

    }

    private static int selectedPrimes(int num, int x, int prime, int count) {
        if (num < prime || num == 1) return count;
        if (x == countRow(num, prime, 0)) {
            System.out.print(prime + " ");
            return selectedPrimes((int) (num / Math.pow(prime, x)),
                    x, nextPrime(prime), count + 1);
        }
        return selectedPrimes(num, x, nextPrime(prime), count);
    }

    private static int nextPrime(int prime) {
        return 1;
    }

    private static int countRow(int num, int prime, int count) {
        if (num % prime != 0 || num == 1) return count;
        return countRow(num / prime, prime, count + 1);
    }

    public static int findAlmostSorted(int[] arr, int num) {
        int low = 0, high = arr.length -1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] == num) return mid;
            if (arr[mid] > num) {
                if (arr[mid -1] == num) return mid -1;
                high = mid -2;
            }
            else {
                if (arr[mid + 1] == num) return mid + 1;
                low = mid + 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
