package finalTests._2024;

public class _75 {

    // Finish 1 2 3
    public static int countEqualDiff(int[] a) {
        return count(a, 0, 0, 0, 0 , "" , "", 0);
    }

    private static int count(int[] a, int len1, int len2, int sum1, int sum2, String path1, String path2, int i) {
        if (len1 + len2 == a.length) {
            if (Math.abs(len1 - len2) == Math.abs(sum1 - sum2)) {
                System.out.println("{ " + path1 + " } sum = " + sum1 + " count = " + len1);
                System.out.println("{ " + path2 + "} sum = " + sum2 + " count = " + len2);
                System.out.println("------");
                return 1;
            }
            else return 0;
        }

        int right = count(a, len1 + 1, len2, sum1 + a[i], sum2, path1 + a[i] + " ", path2, i + 1);
        int left = count(a, len1, len2 + 1, sum1, sum2 + a[i], path1, path2 + a[i] + " ", i + 1);
        return right + left;
    }

    /**
     * @param arr
     * @return the smallest positive number that is not in the array
     */
    public static int findFirstMissing (int [] arr) {
       int i= 0;
       while (i < arr.length) {
           if (arr[i] >= 1 && arr[i] <= arr.length) { //arr[i] <= arr.length ?
                int goTo = arr[i] - 1;

                if (arr[i] == i + 1 || arr[i] == arr[goTo]) i++;

                else if (goTo > i) swap(arr, i, goTo);
                else {
                    arr[goTo] = arr[i];
                    i++;
                }

           } else i++;

       }

        for (int j = 0; j < arr.length; j++) {
            if (arr[i] != i + 1) return i + 1;
        }
        return arr.length + 1;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1,2,0,3,-1};
//        System.out.println(countEqualDiff(a));

        int[] arr1 = {1, 1, 1};
        int[] arr2 = {1, 2, 3, 4};
        int[] arr3 = {2 , -2 , 0 , 1 , 3 , -1 , 5} ;
        int[] arr4 = {14 , 12 , 11 , 9 , 8 , 7} ;

        System.out.println(findFirstMissing(arr1)+ " should be 2");
        System.out.println(findFirstMissing(arr2)+ " should be 5");
        System.out.println(findFirstMissing(arr3) + " should be 4");
        System.out.println(findFirstMissing(arr4)+ " should be 1");
    }
}
