public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.addTwoNum("123", "12"));
        System.out.println(calculator.addTwoNum("123", "123"));
        System.out.println(calculator.addTwoNum("12345678912345678", "9"));
        System.out.println(calculator.subtractTwoNum("12","3"));
        System.out.println(calculator.subtractTwoNum("123","3"));
        System.out.println(calculator.subtractTwoNum("120","3"));
        System.out.println(calculator.subtractTwoNum("123","123"));
        System.out.println(calculator.subtractTwoNum("111153","111023"));
    }
}
