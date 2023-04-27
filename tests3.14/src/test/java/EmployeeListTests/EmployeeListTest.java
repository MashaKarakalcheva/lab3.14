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
        Employee employee2 = new Employee("Петр", "Петров", "Аналитик", "Высокий", 7, 9876543210987
