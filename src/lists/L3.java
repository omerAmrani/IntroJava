package lists;

import lists.common.IntNodeTwo;

public class L3 {
    IntNodeTwo _head;
    IntNodeTwo _tail;

    public int what() {
        int res = 0;
        IntNodeTwo p = _head;
        while (p != null)
        {
            res++;
            p = p.getNext();
        }
        return res;
    }
    public int secret()
    {
        int temp = what();
        int m = 0, i=0;
        IntNodeTwo p = _head;

        while (p != null) {
            IntNodeTwo q = _tail;

            int j = temp-1;

            while (q != p) {
                if (p.getValue() == q.getValue()) {
                    int curr = Math.abs(j-i);
                    if (curr > m)
                        m = curr;
                }
                q = q.getPrev();
                j--;
            }
            p = p.getNext();
            i++;
        }

        return m;
    }

    // list sum
    public int f()
    {
        int res = 0;
        IntNodeTwo temp = _head;
        while (temp != null)
        {
            res = res + temp.getValue();
            temp = temp.getNext();
        }
        return res;
    }

    // list length
    public int g()
    {
        int res = 0;
        IntNodeTwo temp = _head;
        while (temp != null)
        {
            res++;
            temp = temp.getNext();
        }
        return res;
    }

    public boolean what (double target)
    {
        int length = g();
        int sum = f();

        double c = length;
        double avg = sum / c;

        IntNodeTwo p1 = _head;
        IntNodeTwo p2 = _tail;

        while (p1 != p2) {
            if (avg == target) return true;

            if (avg < target) {
                sum = sum - p1.getValue();
                p1 = p1.getNext();
            }
            else {
                sum = sum - p2.getValue();
                p2 = p2.getPrev();
            }
            c--;
            avg = sum/c;
        }
        return avg == target;
    }


}
