import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Program {
    class Employee {
        String firstName;
        String lastName;

        Employee(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    private ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Program prog = new Program();
        prog.start();
    }

    public void start() {
        this.fillEmployeeList();
        System.out.println(this.findDuplicateNames());
    }

    private void fillEmployeeList() {
        this.employees.add(new Employee("Иван", "Иванов"));
        this.employees.add(new Employee("Светлана", "Петрова"));
        this.employees.add(new Employee("Кристина", "Белова"));
        this.employees.add(new Employee("Анна", "Мусина"));
        this.employees.add(new Employee("Анна", "Крутова"));
        this.employees.add(new Employee("Иван", "Юрин"));
        this.employees.add(new Employee("Петр", "Лыков"));
        this.employees.add(new Employee("Павел", "Чернов"));
        this.employees.add(new Employee("Петр", "Чернышов"));
        this.employees.add(new Employee("Мария", "Федорова"));
        this.employees.add(new Employee("Марина", "Светлова"));
        this.employees.add(new Employee("Мария", "Савина"));
        this.employees.add(new Employee("Мария", "Рыкова"));
        this.employees.add(new Employee("Марина", "Лугова"));
        this.employees.add(new Employee("Анна", "Владимирова"));
        this.employees.add(new Employee("Иван", "Мечников"));
        this.employees.add(new Employee("Петр", "Петин"));
        this.employees.add(new Employee("Иван", "Ежов"));
    }

    private Map<String, Integer> findDuplicateNames() {
        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < this.employees.size(); i++) {
            String name = this.employees.get(i).firstName;
            int repeats = 1;
            if (result.containsKey(name)) {
                repeats += result.get(name);
            }

            result.put(name, repeats);
        }

        return result.entrySet()
            .stream()
            .filter(repeats -> repeats.getValue() > 1)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}
