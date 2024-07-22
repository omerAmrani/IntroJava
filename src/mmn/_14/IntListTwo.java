package mmn._14;

public class IntListTwo
{
    IntNodeTwo _head, _tail;
    // שימו לב ! בכוונה, ובניגוד למה שלמדתם בקורס,
    // לא הגדרנו את שתי התכונות הללו כ-private.
    // הסיבה לכך היא לצורך הבדיקה שלנו את העבודה שלכם.
    // השאירו הגדרה זאת כפי שהיא ואל תשנו אותה !

    public IntListTwo()
    {
        _head = null;
        _tail = null;
    }

    /**
     * adds a new node to the end of the list where its value is the received number
     * @param num - integer
     */
    public void addToEnd (int num) {

        IntNodeTwo newNode = new IntNodeTwo(num);
        if (_head == null) { // List empty, new node is new head
            _head = newNode;
            _tail = newNode;
        }
        else {
            newNode.setPrev(_tail);
            _tail.setNext(newNode);
            _tail = newNode;
        }
    }

    //the method return a String that represents the list
    /**
     * Returns a String that represents the list
     * @return a String that represents the list in the fprmat:
     * {first value, seconed bofore, ..., last value}
     */
    public String toString()
    {
        //if the list is empty return empty parentheses
        if(_head == null)
            return "{}";

        //opening parenthesis
        String s = "{";
        IntNodeTwo temp = _head;

        //for each node return its value and + ", "
        while (temp != _tail)
        {
            s += temp.getNum() + ", ";
            temp = temp.getNext();
        }

        //the last and closing parenthesis
        s += _tail.getNum() + "}";
        return s;
    }

    public int size()
    {
        IntNodeTwo temp;
        int result;
        for (temp = _head, result = 0;
        temp != null;
        result++, temp = temp.getNext());
        return result;
    }

    /**
     * This method makes amir play the best strategy
     * against tamar to win or get a tie in the coins game.
     * Time lessons.complexity is O(n),
     * we go through the node list by only 2 iterations,
     * first to calculate sum of even and odd nodes, to determine of strategy.
     * second is the game.
     * @return the diff between amir and tamar.
     */
    public int win() {
        int amir = 0;
        int tamar = 0;
        int sumEven = 0;
        int sumOdd = 0;
        IntNodeTwo left = _head;
        IntNodeTwo right = _tail;
        boolean amirTurn = false;

        // Calculates sums of even and odd nodes
        IntNodeTwo current = _head;
        boolean even = true;
        while (current != null) {
            if (even) sumEven += current.getNum();
            else sumOdd += current.getNum();

            current = current.getNext();
            even = !even;
        }

        int temp = amir;
        // to determine which side is the best to start, odd or even
        if (sumEven >= sumOdd) {
            amir += left.getNum();
            left = left.getNext();
        }
        else {
            amir += right.getNum();
            right = right.getPrev();
        }
        System.out.println("Amir took " + (amir - temp));

        boolean game = true;
        while (game) {
            game = left != right;
            boolean leftIsBigger = left.getNum() > right.getNum();

            if (amirTurn) {
                // amir play
                temp = amir;
                if (leftIsBigger) {
                    amir += left.getNum();
                    left = left.getNext();
                }
                else {
                    amir += right.getNum();
                    right = right.getPrev();
                }
                System.out.println("Amir took " + (amir - temp));
            }
            else {
                // tamar play
                temp = tamar;
                if (leftIsBigger) {
                    tamar += left.getNum();
                    left = left.getNext();
                }
                else {
                    tamar += right.getNum();
                    right = right.getPrev();
                }
                System.out.println("Tamar took " + (tamar - temp));
            }

            amirTurn = !amirTurn;
        }

        System.out.println("Final Score:\n" +
                "Amir total " + amir + "\n" +
                "Tamar total " + tamar);

        return amir - tamar;
    }

    /**
     * return the sum between the nodes low and high
     */
    private int f (int low, int high) {
        int result = 0;
        IntNodeTwo temp = _head;

        for (int i = 0; i < low; i++)
            temp = temp.getNext();

        for (int j = low; j <= high; j++) {
            result += temp.getNum();
            temp = temp.getNext();
        }
        return result;
    }

    /**
     * A. The method checks if a sublist sum equals to num.
     * @return true if there is a sublist equals to sum, false if there is not.
     * Print the nodes range that is the sum.
     * B. Time lessons.complexity of O(n^3), call for f() is O(n).
     * Space lessons.complexity is O(1).
     */
    public boolean what (int num) {
        int listSize = size();

        for (int i = 0; i < listSize; i++) {
            for (int j = i; j < listSize; j++) {
                if (f(i, j)  == num) {
                    System.out.println("between " + i + " and " + j);
                    return true;
                }
            }
        }
        System.out.println("No ");
        return false;
    }

    /**
     * Check if there is a node range which is equal to num
     * time lessons.complexity is O(n), using sliding window technique to find a match
     * @param num
     * @return true if node range exits, prints the range
     */
    public boolean betterWhat (int num) {
        int currentSum = _head.getNum();
        IntNodeTwo left = _head;
        int leftIndex = 0;
        IntNodeTwo right = _head;
        int rightIndex = 0;

        // until not reach to end
        while (right != null) {
            if (currentSum == num) {
                System.out.println("between " + leftIndex + " and " + rightIndex);
                return true;
            }
            else {
                // if smaller try to get add the next node
                if (currentSum < num) {
                    right = right.getNext();
                    if (right != null) {
                        currentSum += right.getNum();
                        rightIndex++;
                    }
                }
                // remove the node from the top
                else {
                    currentSum -= left.getNum();
                    left = left.getNext();
                    leftIndex++;
                }
            }
        }

        System.out.println("No ");
        return false;
    }

    /**
     * @param list2 the list to compare.
     * @return the size of the longest common sublist.
     */
    public int longestCommonSublist(IntListTwo list2) {
        return longestCommonSublist(_head, list2._head, 0);
    }

    // Recursive method that finds the longest common sublist size.
    private int longestCommonSublist(IntNodeTwo node1, IntNodeTwo node2, int max) {
        if (node1 == null || node2 == null) return max;

        if (node1.getNum() == node2.getNum()) max++;

        int size1 = longestCommonSublist(node1.getNext(), node2, max);
        int size2 = longestCommonSublist(node1, node2.getNext(), max);

        return Math.max(size1, size2);
    }


    /**
     * @return the max length of strict sublist.
     * default with 1 as lowest number of values appear, only one time is the minimum.
     */
    public int maxEqualValue() {
        return maxEqualValue(_head, 1, 1);
    }

    // Recursive method that find the max length of strict sublist
    private int maxEqualValue(IntNodeTwo current, int currentMax, int max) {
        if (current.getNext() == null) return max;

        if (current.getNum() == current.getNext().getNum()) currentMax++;

        // if the number has changed we check if there is a need to set a new max.
        else if (currentMax > max) {
            max = currentMax;
            currentMax = 1;
        }

        return maxEqualValue(current.getNext(), currentMax, max);
    }
}
