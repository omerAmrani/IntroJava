package lists;

import lists.common.IntNode;

public class L5 {
    public IntNode merge(IntNode list1, IntNode list2) {
        if (list1 == null ) return list2;
        if (list2 == null) return list1;

        if (list1.getValue() < list2.getValue()) {
            list1.setNext(merge(list1.getNext(), list2));
            return list1;
        }
        list2.setNext(merge(list1, list2.getNext()));
        return list2;

    }
}
