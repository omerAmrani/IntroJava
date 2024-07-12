package finalTests._2019;

public class _83 {
        public static int howManyNegativeNumbers(int[][] arr) {
            int count = 0;
            int i = arr.length - 1;
            int j = 0;

            while (i >= 0 && i < arr.length &&
                    j >= 0 && j < arr[i].length) {
                if (arr[i][j] < 0) {
                    count += i + 1;
                    j++;
                }
                else i--;
            }

            return count;
        }
}
