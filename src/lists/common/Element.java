package lists.common;

public class Element {
    private char _letter;
    private int _count;
    private Element _next;

    public Element() {
        _letter = ' ';
        _count = 0;
        _next = null;
    }

    public char getLetter() {
        return _letter;
    }

    public int getCount() {
        return _count;
    }

    public Element getNext() {
        return _next;
    }
}
