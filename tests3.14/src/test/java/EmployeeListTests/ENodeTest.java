package EmployeeListTests;

import EmployeeList.ENode;
import EmployeeList.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ENodeTest {

    @Test
    void testGetEmployee() {
        Employee employee = new Employee("Иван", "Ангельчев", "Менеджер", "Низкий", 5, 9834567890123L);
        ENode node = new ENode(employee);
        assertEquals(employee, node.getEmployee());
    }

    @Test
    void testSetNext() {
        Employee employee1 = new Employee("Иван", "Ангельчев", "Менеджер", "Низкий", 5, 9834567890123L);
        Employee employee2 = new Employee("Петр", "Петров", "Менеджер", "Высокий", 7, 9876543210987L);
        ENode node1 = new ENode(employee1);
        ENode node2 = new ENode(employee2);
        node1.setNext(node2);
        assertEquals(node2, node1.getNext());
    }
}
