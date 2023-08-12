public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.performCalculation("12","-12",Sign.MINUS));
        System.out.println(calculator.performCalculation("12","2",Sign.MINUS));
        System.out.println(calculator.performCalculation("3","-12",Sign.MINUS));
        System.out.println(calculator.performCalculation("3","-12",Sign.PLUS));
        System.out.println(calculator.performCalculation("-3","-12",Sign.PLUS));
        System.out.println(calculator.performCalculation("3","3",Sign.MINUS));
        System.out.println(calculator.performCalculation("3","12",Sign.MINUS));
        System.out.println(calculator.performCalculation("3","12",Sign.PLUS));
    }
}
