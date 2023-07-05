package DentalClinicSalary;

public class Main {
    public static void main(String[] args) {
        Salary masha = new Salary(3000000, 2500000, 2000000, 0, 0);  // Создали переменную masha, которую привязали к классу Salary
        Salary olya = masha;                            // Привязи переменную olya к классу Salary
        Salary margarita = masha;                       // Привязи переменную margarita к классу Salary

        masha.salaryAdmin(masha.overallSum);         // Вызвали переменной masha метод salaryAdmin (с данными overallSum)
        olya.salaryAdmin(olya.overallSum);           // то же самое для olya
        margarita.salaryAdmin(margarita.overallSum); // то же самое для margarita
        System.out.println("Зарплата Маши : " + masha.salaryMainAdmin); // вывели результат salaryMainAdmin из класса Salary
        System.out.println("Зарплата Оли : " + olya.salaryMainAdmin);
        System.out.println("Зарплата Маргариты : " + margarita.salarySecondAdmin); // вывели результат salarySecondAdmin из класса Salary
    }
}