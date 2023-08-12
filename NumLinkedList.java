public class NumLinkedList {
    Node head;
    Node tail;

    Sign sign;

    int count;

    public NumLinkedList() {
        head = null;
        tail = null;
        sign = Sign.PLUS;
        count = 0;
    }

    public void createListOfDigit(String numStr) {
        if (numStr.charAt(0) == '-') {
            sign = Sign.MINUS;
        }
        for (int i = 0; i < numStr.length(); i++) {
            char cur = numStr.charAt(i);
            if (cur >= '0' && cur <= '9') {
                byte num = (byte) (cur - '0');
                addDigit(num);
            }
        }

    }

    public void calculateSign(Sign sign) {
        if (sign == Sign.MINUS) {
            if (this.sign == Sign.MINUS) {
                this.sign = Sign.PLUS;
            } else {
                this.sign = Sign.MINUS;
            }
        }
    }

    private void addDigit(byte val) {
        count++;
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
        count++;
        Node node = new Node(val);
        if (head == null) {
            head = tail = node;
            return;
        }

        node.next = head;
        head.prev = node;
        head = node;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        Node tmp = head;
        StringBuilder stringBuilder = new StringBuilder();
        if (sign == Sign.MINUS){
            stringBuilder.append(sign);
        }
        while (tmp != null) {
            stringBuilder.append(String.valueOf(tmp.data));
            tmp = tmp.next;
        }
        return stringBuilder.toString();
    }
}
