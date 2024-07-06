package finalTests._2019;

public class _84 {


    /**
     * @param num
     * @return true or false if number can be written as a sum of pow of 3.
     * 3^0 + 3^2 + 3^3 = 37
     */
    public static boolean sumPower3(int num) {
        return sumPower3(num, 0);
    }

    private static boolean sumPower3(int num, int pow) {
        int val = (int) Math.pow(3, pow);

        if (val == num) return true;
        if (val > num) return false;

        boolean sum1 = sumPower3(num - val, pow + 1);
        if (sum1) return true;
        return sumPower3(num - val, pow + 2);
    }


    /**
     * SUM METHOD we use the sum of the array to determine the sum of the right part
     * @param arr
     * @return the index in the array in which it spilt the array in 2 parts,
     * left is <= i, right is > i,
     * which index is the max diff between the left and right parts in abs
     */
    public static int average(int[] arr) {
        int leftSum = 0;
        double maxDiff = 0;
        int maxIndex = 0;
        int arrSum = 0;

        for (int i = 0; i < arr.length; i++) {
            arrSum += arr[i];
        }

        for (int i = 0; i < arr.length - 1; i++) {
            leftSum += arr[i];

            double leftAvg = (double) leftSum / (i + 1);
            double rightAvg = (double) (arrSum - leftSum) / (arr.length - (i + 1));
            double diff = Math.abs(rightAvg - leftAvg );

            if (diff > maxDiff){
                maxDiff = diff;
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public static void main(String[] args) {
//        int[] arr = {5, 7, -2, 10};
//        System.out.println(average(arr));
        System.out.println(sumPower3(5));
    }
}
