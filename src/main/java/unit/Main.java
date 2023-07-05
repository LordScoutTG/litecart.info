package unit;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        // получает от пользователя 2 числа и должна их сложить (предварительно проверить вводимое)
        String str;
        String str1;
        Integer result = 0;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Введите число, которое нужно просуммировать : ");
            str = input.nextLine();
        } while (Checker.isEmpty(str) || !Checker.isNumber(str) || !Checker.isLengthCorrect(str, 3));

        String sym;

        do {
            System.out.print("Введите символ умножения, сложения, деления или вычитания: ");
            sym = input.nextLine();
        } while (!Checker.isEmpty(sym) && !Checker.isSymbol(sym));


        do {
            System.out.print("Введите число, которое нужно просуммировать : ");
            str1 = input.nextLine();
        } while (Checker.isEmpty(str1) || !Checker.isNumber(str1) || !Checker.isLengthCorrect(str1, 3));

        switch (sym) {
            case "+":
                result = Integer.valueOf(str + str1);
                break;
            case "-":
                result = parseInt(str) - parseInt(str1);
                break;
            case "*":
                result = parseInt(str) * parseInt(str1);
                break;
            case "/":
                result = parseInt(str) / parseInt(str1);
                break;
        }
        System.out.println("Ваш результат : " + result);
    }
}