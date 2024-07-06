package mmn_14;

public class MyTester {
    public static void q3test() {
        IntListTwo list1 = new IntListTwo();
        list1.addToEnd(1);
        list1.addToEnd(2);
        list1.addToEnd(3);
        list1.addToEnd(4);
        list1.addToEnd(5);
        list1.addToEnd(6);
        list1.addToEnd(7);
        list1.addToEnd(8);

        IntListTwo list2 = new IntListTwo();
        list2.addToEnd(2);
        list2.addToEnd(3);
        list2.addToEnd(10);
        list2.addToEnd(0);
        list2.addToEnd(15);
        list2.addToEnd(6);
        list2.addToEnd(8);

        IntListTwo list3 = new IntListTwo();
        list3.addToEnd(15);
        list3.addToEnd(10);
        list3.addToEnd(4);

        IntListTwo list4 = new IntListTwo();
        list4.addToEnd(56);
        list4.addToEnd(156);
        list4.addToEnd(12);


        System.out.println(list1.longestCommonSublist(list2));
        System.out.println(list2.longestCommonSublist(list3));
        System.out.println(list4.longestCommonSublist(list2));

        System.out.println("test1 is " + (list1.longestCommonSublist(list2) == 4));
        System.out.println("test2 is " + (list2.longestCommonSublist(list3) == 1));
        System.out.println("test3 is " + (list4.longestCommonSublist(list2) == 0));
    }

    public static void q4test() {
        IntListTwo list1 = new IntListTwo();
        list1.addToEnd(-1);
        list1.addToEnd(-1);
        list1.addToEnd(-1);
        list1.addToEnd(3);
        list1.addToEnd(3);
        list1.addToEnd(3);
        list1.addToEnd(3);
        list1.addToEnd(0);
        list1.addToEnd(2);


        IntListTwo list2 = new IntListTwo();
        list2.addToEnd(56);
        list2.addToEnd(156);
        list2.addToEnd(12);

        IntListTwo list3 = new IntListTwo();
        list3.addToEnd(2);

//        System.out.println(list1.maxEqualValue());
        System.out.println("test1 is " + (list1.maxEqualValue() == 4));
        System.out.println("test2 is " + (list2.maxEqualValue() == 1));
        System.out.println("test3 is " + (list3.maxEqualValue() == 1));

    }

    public static void q2test() {
        // Test 1: Example provided
        IntListTwo list1 = new IntListTwo();
        list1.addToEnd(1);
        list1.addToEnd(2);
        list1.addToEnd(4);
        list1.addToEnd(5);
        // Expected sublist with sum 6: [2, 4]

        System.out.println("Test is match: " + (list1.what(6) == list1.betterWhat(6)));

        // Test 2: Multiple elements, sublist sum at the beginning
        IntListTwo list2 = new IntListTwo();
        list2.addToEnd(3);
        list2.addToEnd(3);
        list2.addToEnd(4);
        list2.addToEnd(5);
        // Expected sublist with sum 6: [3, 3]
        System.out.println("Test 2 is match: " + (list2.what(6) == list2.betterWhat(6)));

        // Test 3: Multiple elements, sublist sum in the middle
        IntListTwo list3 = new IntListTwo();
        list3.addToEnd(1);
        list3.addToEnd(5);
        list3.addToEnd(1);
        list3.addToEnd(2);
        // Expected sublist with sum 6: [1, 5]
        System.out.println("Test 3 is match: " + (list3.what(6) == list3.betterWhat(6)));

        // Test 4: Multiple elements, sublist sum at the end
        IntListTwo list4 = new IntListTwo();
        list4.addToEnd(1);
        list4.addToEnd(2);
        list4.addToEnd(3);
        list4.addToEnd(3);
        // Expected sublist with sum 6: [3, 3]
        System.out.println("Test 4 is match: " + (list4.what(6) == list4.betterWhat(6)));

        // Test 5: Multiple elements, no sublist sum equals num
        IntListTwo list5 = new IntListTwo();
        list5.addToEnd(1);
        list5.addToEnd(2);
        list5.addToEnd(3);
        list5.addToEnd(4);
        // Expected no sublist with sum 10
        System.out.println("Test 5 is match: " + (list5.what(10) == list5.betterWhat(10)));

        // Test 6: Single element equals num
        IntListTwo list6 = new IntListTwo();
        list6.addToEnd(6);
        // Expected sublist with sum 6: [6]
        System.out.println("Test 6 is match: " + (list6.what(6) == list6.betterWhat(6)));

        // Test 7: Single element does not equal num
        IntListTwo list7 = new IntListTwo();
        list7.addToEnd(10);
        list7.addToEnd(6);
        // Expected no sublist with sum 6
        System.out.println("Test 7 is match: " + (list7.what(6) == list7.betterWhat(6)));


    }

    public static void q1test() {
        IntListTwo list1 = new IntListTwo();
        list1.addToEnd(15);
        list1.addToEnd(19);
        list1.addToEnd(21);
        list1.addToEnd(13);
        list1.addToEnd(14);
        list1.addToEnd(30);
        list1.addToEnd(23);
        list1.addToEnd(16);

//        System.out.println(list1.win());

        IntListTwo list2 = new IntListTwo();
        list2.addToEnd(10);
        list2.addToEnd(10);
//        list2.addToEnd(3);
//        list2.addToEnd(2);

        System.out.println(list2.win());


    }


    public static void main(String[] args) {
    q1test();
        //        q2test();
        //        q3test();
//        q4test();
    }
}
