package EmployeeListTests;

import EmployeeList.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testToString() {
        Employee employee = new Employee("Анна", "Петрова", "Менеджер", "Средний", 5, 12345645432123L);
        String expected = "Анна, Иванова, Менеджер, Средний, 5, 1234567890123";
        assertEquals(expected, employee.toString());
    }

    @Test
    void testGetSurname() {
        Employee employee = new Employee("Петр", "Ангельчев", "Аналитик", "Средний", 7, 9876509430987L);
        assertEquals("Ангельчев", employee.getSurname());
    }

    @Test
    void testGetName() {
        Employee employee = new Employee("Мария", "Антонова", "Разработчик", "Высокий", 3, 4567899876456L);
        assertEquals("Мария", employee.getName());
    }

    @Test
    void testGetIdnp() {
        Employee employee = new Employee("Андрей", "Смирнов", "Тестировщик", "Средний", 4, 1357902468113L);
        assertEquals(1357902468113L, employee.getIdnp());
    }
}
