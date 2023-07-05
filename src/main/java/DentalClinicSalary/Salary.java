package DentalClinicSalary;


public class Salary extends Main {
    private final int overallPlan;                                      // Назначаем сумму общего плана
    private final int partialPlan;                                      // Назначаем сумму промежуточного плана
    private final int minPlan;                                          // Назначаем сумму минимального плана
    public double salaryMainAdmin;                                      // Создаём переменную ЗП главного админа
    public double salarySecondAdmin;                                    // Создаём переменную ЗП второго админа
    public static double overallSum;                                        // Создаём переменную фактической суммы выполнения

    protected Salary(int overallPlan, int partialPlan, int minPlan, double salaryMainAdmin, double salarySecondAdmin) {
        this.overallPlan = overallPlan;
        this.partialPlan = partialPlan;
        this.minPlan = minPlan;
        this.salaryMainAdmin = salaryMainAdmin;
        this.salarySecondAdmin = salarySecondAdmin;

        overallSum = CheckInput.inputDoubleTrue(overallSum);                // Обращаемся к методу в отдельном классе - проверяем на эксепшн

    }

    final protected void salaryAdmin(double overallSum) {   // Используем метод salaryAdmin, который принимает в себя значние из консоли
        if (overallSum >= overallPlan) {                 // Ниже условия для расчёта процентов в зависимости от выполнения плана
            salaryMainAdmin = overallSum * 0.015;
            salarySecondAdmin = overallSum * 0.013;
        } else if (overallSum >= partialPlan) {
            salaryMainAdmin = overallSum * 0.013;
            salarySecondAdmin = overallSum * 0.011;
        } else if (overallSum >= minPlan) {
            salaryMainAdmin = overallSum * 0.01;
            salarySecondAdmin = overallSum * 0.009;
        } else {
            salaryMainAdmin = overallSum * 0.009;
            salarySecondAdmin = overallSum * 0.009;
        }
    }
}