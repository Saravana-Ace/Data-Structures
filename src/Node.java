public class Node<T> {

    private T data;
    private Node next;

    public Node(T dataPortion) {
        this(dataPortion, null);
    }

    public Node(T dataPortion, Node nextNode) {
        data = dataPortion;
        next = nextNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNextNode() {
        return next;
    }

    public void setNextNode(Node nextNode) {
        next = nextNode;
    }
}