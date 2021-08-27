package Calculator1;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        startCalc();

        while (true) {

            System.out.println("Введите выражение в формате: \"1 + 1 или I + I\" (через пробел) ");
            String line = sc.nextLine();


            try {
                String[] symbols = line.split(" ");
                if (symbols.length != 3) throw new Exception("Формат вводенных данных не удовлетворяет условиям работы Калькулятора");

                Number firstNumber = SelectService.parseAndValidate(symbols[0]);
                Number secondNumber = SelectService.parseAndValidate(symbols[2], firstNumber.getType());
                String result = Select.calculate(firstNumber, secondNumber, symbols[1]);
                System.out.println("Output: \n" + result);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                exitCalc();
                break;
            }
        }

        sc.close();
    }

    private static void startCalc() {
        System.out.println("Добро пожаловать в Калькулятор, он работает только с целыми арабскими и римскими цифрами от 1 до 10");
        System.out.println("Калькулятор выполняет только следующие операции:");
        System.out.println("Сложение(+), Вычитание(-), Умножение(*), Деление(/)");
    }

    private static void exitCalc() {

        System.out.println("Выход");

    }
}