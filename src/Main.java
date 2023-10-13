import java.util.Random;

public class Main {

    private final static Employee[] EMPLOYEES = new Employee[10];

    private static final Random RANDOM = Random();
    private final static String[] MALE_NAMES = {"Вася", "Петя", "Алёша", "Никита", "Фома"};
    private final static String[] FEMALE_NAMES = {"Светлана", "Ката", "Марфа", "Анжелика", "Фатима"};
    private final static String[] MALE_SURNAMES = {"Гольперов", "Сурков", "Иванов", "Журавлёв", "Лошкин"};
    private final static String[] FEMALE_SURNAMES = {"Галустян", "Мишуткина", "Владимировна", "Суворова", "Попова"};

    private static Employee generateEmployee() {
        boolean male = RANDOM.nextBoolean();

    }
    public static void main(String[] args) {
        EMPLOYEES[0] = new Employee();

    }
}