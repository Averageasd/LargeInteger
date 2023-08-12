public class Node {
    byte data;
    Node next;

    Node prev;

    public Node(byte data) {
        this.data = data;
        next = null;
        prev = null;
    }
}
