import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

    @Test
    public void testConstructor() {
        Employee employee = new Employee("Иван", "Петров", "Тестировщик", Высокий, 7, 1234567890123L);
        Node node = new Node(employee);
        assertEquals(employee, node.employee);
        assertNull(node.left);
        assertNull(node.right);
    }

    @Test
    public void testSetLeft() {
        Employee employee1 = new Employee("Анна", "Семенова", "Менеджер", Выский, 7, 1234567890123L);
        Node node1 = new Node(employee1);

        Employee employee2 = new Employee("Анна", "Иванова", "Секретарь", Низкий, 3, 9876543210987L);
        Node node2 = new Node(employee2);

        node1.setLeft(node2);
        assertEquals(node2, node1.left);
    }

    @Test
    public void testSetRight() {
        Employee employee1 = new Employee("Анатолий", "Петров", "Аналитик", Низкий, 2, 1234567890123L);
        Node node1 = new Node(employee1);

        Employee employee2 = new Employee("Ирина", "Ангельчева", "Ассистент", Средний, 3, 9876543210987L);
        Node node2 = new Node(employee2);

        node1.setRight(node2);
        assertEquals(node2, node1.right);
    }

}
