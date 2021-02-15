package homework_2.task_1;

import java.util.Scanner;

public class Calculator {
    double number1;
    double number2;
    double number3;

    public void start() {

        Scanner scan1 = new Scanner(System.in);
        System.out.println("Введите желаемую операцию (+, -, *, ^, !, F): ");
        String symbol1 = scan1.nextLine();

        switch (symbol1) {
            case "+":
                enterTwoNumbers();
                addition(number1, number2);
                break;
            case "-":
                enterTwoNumbers();
                subtraction(number1, number2);
                break;
            case "*":
                enterTwoNumbers();
                multiplication(number1, number2);
                break;
            case "^":
                enterTwoNumbers();
                power(number1, number2);
                break;
            case "!":
                enterOneNumber();
                factorial(number3);
                break;
            case "F":
                enterOneNumber();
                fibonacci(number3);
                break;
            default:
                System.out.println("Вы ввели неверный символ");
        }
    }

    public void enterTwoNumbers() {
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        number1 = scan2.nextDouble();
        Scanner scan3 = new Scanner(System.in);
        System.out.println("Введите второе число: ");
        number2 = scan3.nextDouble();
    }

    public void enterOneNumber() {
        Scanner scan4 = new Scanner(System.in);
        System.out.println("Введите число: ");
        number3 = scan4.nextDouble();
    }

    public void addition(double number1, double number2) {
        System.out.println("Сумма чисел: " + (number1 + number2));
    }

    public void subtraction(double number1, double number2) {
        System.out.println("Разность чисел: " + (number1 - number2));
    }

    public void multiplication(double number1, double number2) {
        System.out.println("Произведение чисел: " + (number1 * number2));
    }

    public void power(double number1, double number2) {
        int result = 1;
        for (int i = 1; i <= (int) number2; i++)
            result *= (int) number1;

        System.out.println("Возведение в степень: " + (result));
    }

    public void factorial(double number3) {
        int result = 1;
        for (int i = 1; i <= (int) number3; i++)
            result = result * i;

        System.out.println("Факториал числа " + (int) number3 + ": " + (result));
    }

    public void fibonacci(double number3) {
        int[] fibo1 = new int[(int) number3 + 1];

        fibo1[0] = 0;

        if (number3 > 0) {
            fibo1[1] = 1;

            for (int i = 2; i <= number3; i++) {
                fibo1[i] = fibo1[i - 1] + fibo1[i - 2];
            }
        }

        System.out.println("Число Фибоначчи под номером " + (int) number3 + ": " + fibo1[(int) number3]);

    }

}
