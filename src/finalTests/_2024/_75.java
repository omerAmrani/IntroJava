package finalTests._2024;

public class _75 {

    /**
     * TODO: improve complexity
     * @param arr
     * @return the smallest positive number that is not in the array
     */
    public static int findFirstMissing (int [] arr) {
        int min = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) {
                min += 1;
                i = -1;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 1};
        int[] arr2 = {1, 2, 3, 4};
        int[] arr3 = {2 , -2 , 0 , 1 , 3 , -1 , 5} ;
        int[] arr4 = {14 , 12 , 11 , 9 , 8 , 7} ;

//        System.out.println(findFirstMissing(arr1)+ " should be 2");
//        System.out.println(findFirstMissing(arr2)+ " should be 5");
        System.out.println(findFirstMissing(arr3) + " should be 4");
        System.out.println(findFirstMissing(arr4)+ " should be 1");
    }
}
