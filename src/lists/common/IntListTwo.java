package lists.common;

public class IntListTwo
{
    private IntNodeTwo _head, _tail;

    public IntListTwo()
    {
        _head = null;
        _tail = null;
    }

    public boolean diff (int num) {
        if (empty() || _head.getNext() == null) {
            return false;
        }

        int max = _head.getValue();
        int min = _head.getValue();
        IntNodeTwo pointer = _head.getNext();

        while (pointer != null) {
            if (pointer.getValue() > max) max = pointer.getValue();
            if (pointer.getValue() < min) min = pointer.getValue();

            if ((max - min) > num) return true;

            pointer = pointer.getNext();
        }

        return false;
    }

    public boolean empty()
    {
        return _head == null;
    }

    public void addToEnd(IntNodeTwo node)
    {
        if (empty())
        {
            _head = node;
            _tail = node;
            _head.setNext(null);
            _head.setPrev(null);
        }
        else
        {
            IntNodeTwo ptr = _head;
            while (ptr.getNext() != null)
                ptr = ptr.getNext();
            ptr.setNext(node);
            node.setNext(null);
            node.setPrev(ptr);
            _tail = node;
        }
    }

    public static void main(String[] args) {
        IntListTwo l1 = new IntListTwo();
        IntNodeTwo n1 = new IntNodeTwo(7);
        l1.addToEnd(n1);
        IntNodeTwo n2 = new IntNodeTwo(3);
        l1.addToEnd(n2);
        IntNodeTwo n3 = new IntNodeTwo(2);
        l1.addToEnd(n3);
        IntNodeTwo n4 = new IntNodeTwo(4);
        l1.addToEnd(n4);
        IntNodeTwo n5 = new IntNodeTwo(3);
        l1.addToEnd(n5);

        System.out.println("List is: {7,3,2,4,3}, diff(3) return " + l1.diff(3));
        System.out.println("List is: {7,3,2,4,3}, diff(5) return " + l1.diff(5));
        System.out.println("List is: {7,3,2,4,3}, diff(6) return " + l1.diff(6));
    }
}
