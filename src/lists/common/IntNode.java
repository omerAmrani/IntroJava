package lists.common;

public class IntNode
{
    private int _value;
    private IntNode _next;

    public IntNode(int val)
    {
        _value = val;
        _next = null;
    }
    public IntNode(int val, IntNode next)
    {
        _value = val;
        _next = next;
    }
    public int getValue() {
        return _value;
    }
    public void setValue(int v) {
        _value = v;
    }
    public IntNode getNext( ) {
        return _next;
    }
    public void setNext(IntNode node) {
        _next = node;
    }
}