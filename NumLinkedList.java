public class NumLinkedList {
    Node head;

    public NumLinkedList() {
        head = null;
    }

    public void createListOfDigit(String numStr) {
        head = null;
        for (int i = 0; i<numStr.length();i++){
            char cur = numStr.charAt(i);
            byte num = (byte) (cur - '0');
            addFront(num);
        }
    }

    private void addFront(byte val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }
}
