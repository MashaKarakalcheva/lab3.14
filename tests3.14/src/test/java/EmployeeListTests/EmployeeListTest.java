package EmployeeListTests;

import EmployeeList.Employee;
import EmployeeList.EmployeeList1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeListTest {

    private EmployeeList1 list;

    @BeforeEach
    void setUp() {
        list = new EmployeeList1();
        Employee employee1 = new Employee("Иван", "Ангельчев", "Аналитик", "Средний", 6, 9834567890123L);
            Employee employee2 = new Employee("Петр", "Петров", "Аналитик", "Высокий", 3, 2345678901234L);
    Employee employee3 = new Employee("Сергей", "Сидоров", "Разработчик", "Высокий", 7, 3456789012345L);
    list.addEmployee(employee1);
    list.addEmployee(employee2);
    list.addEmployee(employee3);
}

@Test
void addEmployee() {
    Employee employee = new Employee("Михаил", "Андреев", "Тестировщик", "Средний", 2, 4567890123456L);
    assertTrue(list.addEmployee(employee));
    assertFalse(list.addEmployee(employee1));
}

@Test
void removeEmployee() {
    assertTrue(list.removeEmployee(employee1));
    assertFalse(list.removeEmployee(new Employee("Андрей", "Попов", "Разработчик", "Высокий", 7, 5678901234567L)));
}

@Test
void printList() throws FileNotFoundException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    list.printList();
    String expectedOutput = "Список сотрудников:\r\n" +
            "1. Андрей Иванов Тестировщик  Средний - Стаж: 5 - ID: 1234567890123\r\n" +
            "2. Петр Попов  Аналитик  Высокий  Стаж: 6  ID: 2345678901234\r\n" +
            "3. Анна Сидорова  Разработчик  Высокий  Стаж: 7  ID: 3456789012345\r\n";
    assertEquals(expectedOutput, outContent.toString());
    System.setOut(System.out);
}

@Test
void saveToFile() {
    File file = new File("employees.txt");
    assertTrue(list.saveToFile(file));
    assertTrue(file.exists());
    assertTrue(file.delete());
}

@Test
void loadFromFile() {
    File file = new File("employees.txt");
    assertTrue(list.saveToFile(file));
    EmployeeList1 newList = new EmployeeList1();
    assertTrue(newList.loadFromFile(file));
    assertEquals(list.getEmployees(), newList.getEmployees());
    assertTrue(file.delete());
}
}

class EmployeeTest {
private Employee employee;

@BeforeEach
void setUp() {
    employee = new Employee("Иван", "Алексеев", "Дизайнер", "Средний", 3, 1234567890123L);
}

@Test
void getFullName() {
    assertEquals("Иван Алексеев", employee.getFullName());
}

@Test
void getPosition() {
    assertEquals("Дизанер", employee.getPosition());
}

@Test
void getLevel() {
    assertEquals("Средний", employee.getLevel());
}

@Test
void getExperience() {
    assertEquals(3, employee.getExperience());
}

@Test
void getId() {
    assertEquals(1234567890123L, employee.getId());
}

@Test
void testToString() {
    String expectedOutput = "Иван Алексеев Дизайнер Средний Стаж: 3  ID: 1234567890123";
assertEquals(expectedOutput, employee.toString());
}

@Test
void testPrintListToFile() throws FileNotFoundException {
Employee employee2 = new Employee("Петр", "Попов", "Аналитик", "Высокий", 10, 4567890123456L);
Employee employee3 = new Employee("Анатолий", "Сидоров", "Тестировщик", "Низкий", 1, 7890123456789L);
list.addEmployee(employee1);
list.addEmployee(employee2);
list.addEmployee(employee3);
ByteArrayOutputStream outContent = new ByteArrayOutputStream();
System.setOut(new PrintStream(outContent));

list.printListToFile("employeeList.txt");

File file = new File("employeeList.txt");
assertTrue(file.exists());

String expectedOutput = "Список сотрудников:\n" +
        "Иван Алексеев Дизайнер Средний  Стаж: 3  ID: 1234567890123\n" +
        "Петр Попов Аналитик - Высокий  Стаж: 10  ID: 4567890123456\n" +
        "Анатолий Сидоров Тестировщик  Низкий  Стаж: 1 - ID: 7890123456789\n";
String actualOutput = outContent.toString();
assertEquals(expectedOutput, actualOutput);
}

