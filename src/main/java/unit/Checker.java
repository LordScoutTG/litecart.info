package unit;

import java.util.Scanner;

public class Checker {

    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            System.out.println("Это не цифры, это не возможно сложить");
            return false;
        }
    }

    public static boolean isEmpty(String str) {
        if (str.isEmpty()) {
            System.out.println("Вы ничего не ввели");
            return true;
        }
        return false;
    }

    public static boolean isLengthCorrect(String str, int limit) {
        if (str.length() > limit) {
            System.out.printf("Длина вашего числа > %d%n", limit);
            return false;
        }
        return true;
    }

    public static boolean isSymbol(String sym) {
        if (sym.equals("+") || sym.equals("-") || sym.equals("/") || sym.equals("*")) {

            return true;
        }
        System.out.println("Это не знак сложения, деления, умножения или вычитания");
        return false;
    }


    public static int checkString() {
        String str;
        do {
            System.out.println("Введите число, которое нужно просуммировать");
            Scanner input = new Scanner(System.in);
            str = input.nextLine();
        } while (Checker.isEmpty(str) || !Checker.isNumber(str) || !Checker.isLengthCorrect(str, 3));
        return Integer.parseInt(str);
    }
}
