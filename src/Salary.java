import java.util.Calendar;

public class Salary{
    public static void main(String[] args) {
        double hourlyRate = 10.0; // Вартість години
        double taxRate = 0.20; // Відсоток податку

        int workingDaysPerWeek = 5; // Кількість робочих днів на тиждень
        int workingHoursPerDay = 8; // Кількість робочих годин на день

        int totalWorkingDays = 0; // Загальна кількість робочих днів в році
        double totalSalaryBeforeTax = 0; // Загальна зарплата до оподаткування
        double totalSalaryAfterTax = 0; // Загальна зарплата після оподаткування

        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);

        for (int month = 0; month < 12; month++) {
            calendar.set(currentYear, month, 1);
            int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

            for (int day = 1; day <= daysInMonth; day++) {
                calendar.set(currentYear, month, day);
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

                if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                    totalWorkingDays++;
                    totalSalaryBeforeTax += hourlyRate * workingHoursPerDay;
                }
            }
        }

        double monthlySalaryBeforeTax = totalSalaryBeforeTax / 12;
        double monthlySalaryAfterTax = monthlySalaryBeforeTax * (1 - taxRate);

        System.out.println("Зарплата на місяць до оподаткування: " + monthlySalaryBeforeTax);
        System.out.println("Зарплата на місяць після оподаткування: " + monthlySalaryAfterTax);
        System.out.println("Загальна річна зарплата до оподаткування: " + totalSalaryBeforeTax);
        System.out.println("Загальна річна зарплата після оподаткування: " + (totalSalaryBeforeTax - (totalSalaryBeforeTax * taxRate)));
    }
}