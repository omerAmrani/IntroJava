package lessons.lists;

import lessons.lists.common.Element;


public class Lecture {

    public static int encodedStringCmp(Element str1, Element str2) {
        Element tmp1 = str1;
        Element tmp2 = str2;

        while (tmp1 != null && tmp2 != null) {
            if (tmp1.getLetter() < tmp2.getLetter()) return -1;
            if (tmp1.getLetter() > tmp2.getLetter()) return 1;
            if (tmp1.getCount() > tmp2.getCount()) {
                if (tmp2.getNext() == null) return 1;
                if (tmp2.getNext().getLetter() < tmp1.getLetter()) return 1;
                return -1;
            }
            if (tmp1.getCount() < tmp2.getCount()) {
                if (tmp1.getNext() == null) return -1;
                if (tmp1.getNext().getLetter() < tmp2.getLetter()) return -1;
                return 1;
            }

            tmp1 = tmp1.getNext();
            tmp2 = tmp2.getNext();
        }
        if (tmp1 == null && tmp2 == null) return 0;
        if (tmp1 == null) return -1;
        return 1;
    }
}
