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
        System.out.println(calculator.performCalculation("123","29",Sign.MULTIPLY));
        System.out.println(calculator.performCalculation("123","123",Sign.MULTIPLY));
        System.out.println(calculator.performCalculation("123","-123",Sign.MULTIPLY));
        System.out.println(calculator.performCalculation("-123","-123",Sign.MULTIPLY));
        System.out.println(calculator.performCalculation("2460","369",Sign.PLUS));
        System.out.println(calculator.performCalculation("2100","150",Sign.MINUS));
        System.out.println(calculator.performCalculation("1233","1134",Sign.MULTIPLY));
        System.out.println(calculator.performCalculation("-123","0",Sign.MULTIPLY));
    }
}
