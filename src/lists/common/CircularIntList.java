package lists.common;

public class CircularIntList {

    private IntNode _head;
    public CircularIntList( ) {
        _head = null;
    }

    public CircularIntList(IntNode node) {
        _head = node;
    }

    public void printList() {
        if (_head == null) return;

        System.out.print(_head.getValue() + "-->");
        IntNode tmp = _head.getNext();


        while (tmp != _head) {
            System.out.print(tmp.getValue() + "-->");
            tmp = tmp.getNext();
        }
    }

    public void printDouble() {
        if (empty())
            return;
        printDouble(_head);
    }

    private void printDouble(IntNode current) {
        if (current == null) return;

        System.out.print(current.getValue() + " ");
        printDouble(current.getNext());
        System.out.print(current.getValue() + " ");
    }

    public IntNode secondMax() {
        if (length() < 2) return null;
        return secondMax(_head, _head.getNext(), _head);
    }

    private IntNode secondMax(IntNode max, IntNode max2, IntNode current) {
        if (current == null) return max2;

        if (current.getValue() > max2.getValue()) max2 = current;

        IntNode temp = max;
        if (max2.getValue() > max.getValue()) {
            max = max2;
            max2 = temp;
        }

        return secondMax(max, max2, current.getNext());
    }

    public void addToEnd(IntNode node) {
        if (empty())
        {
            _head = node;
            _head.setNext(_head);
        }
        else {
            IntNode ptr = _head;
            while (ptr.getNext() != _head)
                ptr = ptr.getNext();
            ptr.setNext(node);
            node.setNext(_head);
        }
    }

    public boolean empty() {
        return _head == null;
    }

    public int length() {
        IntNode temp = _head;
        int count = 0;
        while (temp != null)
        {
            count++;
            temp = temp.getNext();
        }
        return count;
    }
}
