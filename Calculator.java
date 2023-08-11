public class Calculator {

    NumLinkedList firstNumList;
    NumLinkedList secNumList;

    public Calculator() {
        firstNumList = new NumLinkedList();
        secNumList = new NumLinkedList();
    }

    public NumLinkedList addTwoNum(String n1, String n2){
        firstNumList.createListOfDigit(n1);
        secNumList.createListOfDigit(n2);
        return null;
    }


}
