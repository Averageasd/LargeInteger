public class CalculateBiggerNumber {

    public static NumLinkedList getBiggerNumber(NumLinkedList l1, NumLinkedList l2) {
        if (l1.getCount() > l2.getCount()) {
            return l1;
        } else if (l2.getCount() > l1.getCount()) {
            return l2;
        }

        Node digitPt1 = l1.head;
        Node digitPt2 = l2.head;
        while (digitPt1 != null && digitPt2 != null) {
            byte firstVal = digitPt1.data;
            byte secondVal = digitPt2.data;
            if (firstVal > secondVal) {
                return l1;
            } else if (secondVal > firstVal) {
                return l2;
            }
            digitPt1 = digitPt1.next;
            digitPt2 = digitPt2.next;
        }

        return l1;
    }
}
