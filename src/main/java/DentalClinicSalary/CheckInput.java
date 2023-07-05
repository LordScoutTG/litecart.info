package DentalClinicSalary;

import java.util.Scanner;

public class CheckInput {

    protected static double inputDoubleTrue(double overallSum) throws NumberFormatException {
        Scanner inputOverallSum = new Scanner(System.in);           // Создаём сканнер с названием inputOverallSum
        System.out.print("Input overall sum: ");                    // Сообщения для ввода из консоли
        boolean isValid = false;                                    // Задали переменную для цикла проверки исключения
        while (!isValid) {                                          // Открыли цикл проверки
            isValid = true;                                         // Ловим ошибку. Если не поймали - выходим из цикла. Если поймали - циклим.
            try {
                overallSum = Integer.parseInt(inputOverallSum.nextLine());  // Присваиваем введённо значение переменной overallSum
            } catch (NumberFormatException e) {
                System.out.print("Please input number: ");
                isValid = false;
            }
        }
        return overallSum;                                          // возвращаем переменную в метод
    }
}
