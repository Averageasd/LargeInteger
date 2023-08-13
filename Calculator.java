public class Calculator {

    NumLinkedList firstNumList;
    NumLinkedList secNumList;

    public Calculator() {
        firstNumList = new NumLinkedList();
        secNumList = new NumLinkedList();
    }

    public NumLinkedList performCalculation(String n1, String n2, Sign sign) {
        NumLinkedList res = new NumLinkedList();
        NumLinkedList firstList = new NumLinkedList();
        NumLinkedList secondList = new NumLinkedList();
        firstList.createListOfDigit(n1);
        secondList.createListOfDigit(n2);
        NumLinkedList biggerNum = CalculateBiggerNumber.getBiggerNumber(firstList, secondList);
        NumLinkedList smallerNum;
        if (biggerNum == firstList) {
            smallerNum = secondList;
        } else {
            smallerNum = firstList;
        }
        if (sign == Sign.MINUS || sign == Sign.PLUS) {
            secondList.calculateSign(sign);
            if (firstList.sign == secondList.sign) {
                res = addTwoNum(firstList, secondList);
                res.calculateSign(firstList.sign);
            } else {
                res = subtractTwoNum(biggerNum, smallerNum);
                if (biggerNum.sign == Sign.MINUS) {
                    res.sign = Sign.MINUS;
                }
            }
        } else {
            res = multiplyTwoNum(biggerNum, smallerNum);
        }

        return res;
    }

    private NumLinkedList multiplyTwoNum(NumLinkedList firstNumList, NumLinkedList secNumList) {

        // multiply the last node of second list with each node in
        // by doing this, we will create a new linked list of digits
        // then we move the pointer of second list and do the same thing.
        // then we add these linked lists together to get the final result.
        Node pt = secNumList.tail;
        NumLinkedList prev = null;
        NumLinkedList cur = new NumLinkedList();
        byte remember = 0;
        int numZerosNeedToAdd = 0;
        while (pt != null) {
            remember = 0;
            cur = new NumLinkedList();
            Node tmp = firstNumList.tail;
            byte curDigit = pt.data;
            while (tmp != null) {
                byte val = tmp.data;
                byte res = (byte) (((val * curDigit) + remember) % 10);
                remember = (byte) (((val * curDigit) + remember) / 10);
                cur.addFront(res);
                tmp = tmp.prev;
            }
            if (remember > 0) {
                cur.addFront(remember);
            }

            for (int i = 0; i < numZerosNeedToAdd; i++) {
                cur.addDigit((byte) 0);
            }

            if (prev != null) {
                cur = addTwoNum(cur, prev);
            }

            numZerosNeedToAdd += 1;
            prev = cur;
            pt = pt.prev;
        }

        if (firstNumList.sign == secNumList.sign) {
            cur.sign = Sign.PLUS;
        } else {
            if (cur.head.data != 0) {
                cur.sign = Sign.MINUS;
            }
        }

        cur.removeLeadingZeros();
        return cur;
    }

    private NumLinkedList addTwoNum(NumLinkedList firstNumList, NumLinkedList secNumList) {
        NumLinkedList res = new NumLinkedList();
        Node pt1 = firstNumList.tail;
        Node pt2 = secNumList.tail;
        byte remember = 0;
        while (pt1 != null || pt2 != null) {
            byte newVal = 0;
            if (pt1 == null) {
                newVal = (byte) (pt2.data + remember);
                pt2 = pt2.prev;
            } else if (pt2 == null) {
                newVal = (byte) (pt1.data + remember);
                pt1 = pt1.prev;
            } else {
                newVal = (byte) (pt1.data + pt2.data + remember);
                pt1 = pt1.prev;
                pt2 = pt2.prev;
            }
            if (newVal >= 10) {
                newVal = (byte) (newVal % 10);
                remember = 1;
            } else {
                remember = 0;
            }
            res.addFront(newVal);
        }

        if (remember == 1) {
            res.addFront(remember);
        }
        res.removeLeadingZeros();
        return res;
    }

    private NumLinkedList subtractTwoNum(NumLinkedList firstNumList, NumLinkedList secNumList) {
        NumLinkedList res = new NumLinkedList();
        Node pt1 = firstNumList.tail;
        Node pt2 = secNumList.tail;
        byte remember = 0;
        while (pt1 != null || pt2 != null) {
            byte val = 0;
            if (pt1 == null) {
                val = pt2.data;
                val -= remember;
                remember = 0;
                pt2 = pt2.prev;
            } else if (pt2 == null) {
                val = pt1.data;
                val -= remember;
                remember = 0;
                pt1 = pt1.prev;
            } else {
                byte fDigit = pt1.data;
                byte sDigit = pt2.data;
                sDigit += remember;
                if (fDigit < sDigit) {
                    fDigit = (byte) (fDigit + 10);
                    remember = 1;
                } else {
                    remember = 0;
                }
                val = (byte) (fDigit - sDigit);
                pt1 = pt1.prev;
                pt2 = pt2.prev;
            }
            res.addFront(val);
        }

        res.removeLeadingZeros();
        return res;
    }
}
