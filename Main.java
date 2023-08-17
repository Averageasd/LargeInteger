import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String choice = "";
        do {
            printMenu();
            choice = choice();
            switch (choice) {
                case "1":
                    String firstNum = enterNum();
                    String secondNum = enterNum();
                    String sign = enterSign();
                    calculate(calculator, firstNum, secondNum, sign);
                    break;
                case "2":
                    System.out.println("end");
                    break;
            }
        } while (!choice.equals("2"));
    }

    private static void calculate(Calculator calculator,
                                  String firstNum,
                                  String secondNum,
                                  String sign) {
        NumLinkedList result = null;
        switch (sign) {
            case "+":
                result = calculator.performCalculation(firstNum, secondNum, Sign.PLUS);
                break;
            case "-":
                result = calculator.performCalculation(firstNum, secondNum, Sign.MINUS);
                break;
            case "*":
                result = calculator.performCalculation(firstNum, secondNum, Sign.MULTIPLY);
                break;
        }

        System.out.printf("%s %s %s = %s\n", firstNum, sign, secondNum, result);

    }

    private static String enterNum() {
        String numPattern = "-?[0-9]+";
        System.out.println("Enter number: ");
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        while (!num.matches(numPattern)) {
            System.out.println("Number contains only digits and can optionally start with a minus sign!!!");
            num = scanner.nextLine();
        }
        return num;
    }

    private static String enterSign() {
        String signs = "[-+*]";
        System.out.println("Enter sign (+, - or *):");
        Scanner scanner = new Scanner(System.in);
        String sign = scanner.nextLine();
        while (!sign.matches(signs)) {
            System.out.println("please enter -, + or *");
            sign = scanner.nextLine();
        }
        return sign;
    }

    private static String choice() {
        String choicePattern = "[12]";
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        while (!choice.matches(choicePattern)) {
            System.out.println("Please enter 1 or 2.");
            choice = scanner.nextLine();
        }
        return choice;
    }

    private static void printMenu() {
        System.out.println("1./ Enter two numbers then sign.\n2./End");
    }
}
