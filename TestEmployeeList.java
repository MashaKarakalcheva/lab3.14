import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class EmployeeList1Test {

    private EmployeeList1 employeeList;

    @BeforeEach
    public void setUp() {
        employeeList = new EmployeeList1();
        employeeList.insert(new Employee("Анна", "Иванова", "Менеджер", "Высокий", 2, 123456787653L));
        employeeList.insert(new Employee("Петр", "Афанасьев", "Администратор", "Низкий", 3, 2340954901234L));
        employeeList.insert(new Employee("Мира", "Сергеева", "Разработчик", "Высокий", 7, 3409467012345L));
    }

    @Test
    public void InsertTеsting() {
        Employee employee = new Employee("Мария", "Иванова", "Тестировщик", "Средний", 2, 4567890123456L);
        employeeList.insert(employee);
        Assertions.assertTrue(employeeList.search(employee.getIdnp()));
    }

    @Test
    public void SearchTesting() {
        long idnp = 1234567890123L;
        Assertions.assertTrue(employeeList.search(idnp));
        idnp = 1111111111111L;
        Assertions.assertFalse(employeeList.search(idnp));
    }

    @Test
    public void SearchByNameAndSurnameTesting() {
        String name = "Петр";
        String surname = "Петров";
        Employee employee = employeeList.searchByNameAndSurname(name, surname);
        Assertions.assertNotNull(employee);
        Assertions.assertEquals(name, employee.getName());
        Assertions.assertEquals(surname, employee.getSurname());
        name = "Елена";
        surname = "Евгеньева";
        employee = employeeList.searchByNameAndSurname(name, surname);
        Assertions.assertNull(employee);
    }

    @Test
    public void testofDelete() {
        long idnp = 2345678901234L;
        employeeList.delete(idnp);
        Assertions.assertFalse(employeeList.search(idnp));
    }

    @Test
    public void testofDeleteNonExisting() {
        long idnp = 1111111111111L;
        employeeList.delete(idnp);
        Assertions.assertFalse(employeeList.search(idnp));
    }

    @Test
    public void testDisplay() {
        String expectedOutput = "Сергей, Матвиенко, Админ, Высокий, 8, 3456789012345\n" +
                "Анастасия, Попова, Администратор, Низкий, 3, 2345678901234\n" +
                "Иван, Алексеев, Менеджер, Средний, 5, 1234567890123\n";
        Assertions.assertEquals(expectedOutput, getOutputFromDisplayMethod());
    }

    private String getOutputFromDisplayMethod() {
        StringBuilder output = new StringBuilder();
        Arrays.stream(employeeList.display().split(System.lineSeparator())).sorted()
                .forEach(line -> output.append(line).append(System.lineSeparator()));
        return output.toString();
    }
}
