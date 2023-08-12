public class NumLinkedList {
    Node head;
    Node tail;

    public NumLinkedList() {
        head = null;
    }

    public void clearList() {
        head = null;
        tail = null;
    }

    public void createListOfDigit(String numStr) {
        head = null;
        for (int i = 0; i < numStr.length(); i++) {
            char cur = numStr.charAt(i);
            byte num = (byte) (cur - '0');
            addDigit(num);
        }
    }

    private void addDigit(byte val) {
        Node node = new Node(val);
        if (head == null) {
            head = tail = node;
            return;
        }

        node.prev = tail;
        tail.next = node;
        tail = node;
    }

    public void addFront(byte val) {
        Node node = new Node(val);
        if (head == null) {
            head = tail = node;
            return;
        }

        node.next = head;
        head.prev = node;
        head = node;
    }

    @Override
    public String toString() {
        Node tmp = head;
        StringBuilder stringBuilder = new StringBuilder();
        while (tmp != null) {
            stringBuilder.append(String.valueOf(tmp.data));
            tmp = tmp.next;
        }
        return stringBuilder.toString();
    }
}
