import java.text.NumberFormat;
import java.util.Random;

public class Main {

    private final static Employee[] EMPLOYEES = new Employee[10];

    private static final Random RANDOM = new Random();
    private final static String[] MALE_NAMES = {"Вася", "Петя", "Алёша", "Никита", "Фома"};
    private final static String[] FEMALE_NAMES = {"Светлана", "Ката", "Марфа", "Анжелика", "Фатима"};
    private final static String[] MALE_SURNAMES = {"Гольперов", "Сурков", "Иванов", "Журавлёв", "Лошкин"};
    private final static String[] FEMALE_SURNAMES = {"Галустян", "Мишутина", "Владимировна", "Суворова", "Попова"};
    private final static String[] MALE_MIDDLEMAMES = {"Евгеньевич", "Анатольевич", "Семёнович", "Валентинович", "Васильевич"};
    private final static String[] FEMALE_MIDDLEMAMES = {"Александровна", "Андреевна", "Констонтиновна", "Васильевна", "Петровна"};

    private static Employee generateEmployee() {
        boolean male = RANDOM.nextBoolean();
        String name = male ?
                MALE_NAMES[RANDOM.nextInt(MALE_NAMES.length)] :
                FEMALE_NAMES[RANDOM.nextInt(FEMALE_NAMES.length)];
        String surname = male ?
                MALE_SURNAMES[RANDOM.nextInt(MALE_SURNAMES.length)] :
                FEMALE_SURNAMES[RANDOM.nextInt(FEMALE_SURNAMES.length)];
        String middlename = male ?
                MALE_MIDDLEMAMES[RANDOM.nextInt(MALE_MIDDLEMAMES.length)] :
                FEMALE_MIDDLEMAMES[RANDOM.nextInt(FEMALE_MIDDLEMAMES.length)];
        int department = RANDOM.nextInt(1,6);
        int salary = RANDOM.nextInt(25000,150000);
        return new Employee(name + " " + surname + " " + middlename, department, salary);
    }
    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        for (int i = 0; i < EMPLOYEES.length; i++) {
            EMPLOYEES[i] = generateEmployee();

        }
        print();
        System.out.println("Сотрудник с максимальной зарплатой: " + findEmployeeWithMaxSalary());
        System.out.println("Сотрудник с минимальной зарплатой: " + findEmployeeWithMinSalary());
        System.out.println("Сумма затрат на зарплаты: " + numberFormat.format(calculateSumOfSalaries()));
        System.out.println("Средняя зарплата сотрудника: " + numberFormat.format(calculateAverageSalary()));
        printFullNames();
    }
    private static void print() {
for (Employee employee : EMPLOYEES) {
    System.out.println(employee);
}
    }
    private static void printFullNames() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getFullName());
        }
    }
    private static int calculateSumOfSalaries() {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            sum = sum + employee.getSalary();
        }
        return sum;
    }
    private static Employee findEmployeeWithMaxSalary() {
        Employee EmployeeWithMaxSalary = null;
        int maxSalary = Integer.MIN_VALUE;
        for (Employee employee : EMPLOYEES) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                EmployeeWithMaxSalary = employee;
            }
        }
        return EmployeeWithMaxSalary;
    }
    private static Employee findEmployeeWithMinSalary() {
        Employee EmployeeWithMinSalary = null;
        int minSalary = Integer.MAX_VALUE;
        for (Employee employee : EMPLOYEES) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                EmployeeWithMinSalary = employee;
            }
        }
        return EmployeeWithMinSalary;
    }
private static double calculateAverageSalary() {
        if (EMPLOYEES.length == 0) {
            return 0;
        }
        return (double) calculateSumOfSalaries() / EMPLOYEES.length;
}
}