import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    @Test
    public void testConstructor() {
        BinarySearchTree bst = new BinarySearchTree();
        assertNull(bst.root);
    }

    @Test
    public void testInsert() {
        BinarySearchTree bst = new BinarySearchTree();
        Employee employee1 = new Employee("Иван", "Матвиенко", "Секретарь", "Средний", 5, 1234567890L);
        Employee employee2 = new Employee("Юлия", "Сидорова", "Менеджер", "Низкий", 3, 2345678901L);
        bst.insert(employee1);
        bst.insert(employee2);
        assertEquals(employee1, bst.root.employee);
        assertEquals(employee2, bst.root.right.employee);
    }

    @Test
    public void testDelete() {
        BinarySearchTree bst = new BinarySearchTree();
        Employee employee1 = new Employee("Иван", "Петрова", "Тестировщик", "Средний", 5, 1234567890L);
        Employee employee2 = new Employee("Юлия", "Попова", "Ассистент", "Низкий", 3, 2345678901L);
        Employee employee3 = new Employee("Анна", "Сидорова", "Разработчик", "Высокий", 7, 3456789012L);
        bst.insert(employee1);
        bst.insert(employee2);
        bst.insert(employee3);
        bst.delete(2345678901L);
        assertNull(bst.search(2345678901L));
        assertEquals(employee1, bst.root.employee);
        assertEquals(employee3, bst.root.right.employee);
    }

    @Test
    public void testSearch() {
        BinarySearchTree bst = new BinarySearchTree();
        Employee employee1 = new Employee("Анна", "Иванова", "Дизайнер", "Высокий", 5, 1234567890L);
        Employee employee2 = new Employee("Кира", "Кошкина", "Aссистент", "Низкий", 2, 1234567891L);
Employee employee3 = new Employee("Алексей", "Алексеев", "Инженер", "Высокий", 10, 1234567892L);
bst.insert(employee1);
bst.insert(employee2);
bst.insert(employee3);
    
    assertEquals(bst.search(1234567890L).employee, employee1);

    assertNull(bst.search(1234567893L));
}

@Test
public void testInOrder() {
    BinarySearchTree bst = new BinarySearchTree();
    Employee employee1 = new Employee("Анна", "Иванова", "Дизайнер", "Высокий", 5, 1234567890L);
    Employee employee2 = new Employee("Кира", "Кошкина", "Aссистент", "Низкий", 2, 1234567891L);
    Employee employee3 = new Employee("Алексей", "Алексеев", "Инженер", "Высокий", 10, 1234567892L);
    bst.insert(employee1);
    bst.insert(employee2);
    bst.insert(employee3);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    bst.InOrder();
    assertEquals(outContent.toString(), "Анна, Иванова, Дизайнер, Высокий, 5, 1234567890 \n" +
            "Кира Кошкина, Aссистент, Низкий, 2, 12345678910 \n" +
            "Алексей, Алексеев, Инженер, Высокий, 10, 1234567892 \n");
    System.setOut(System.out);
}

@Test
public void testPreOrder() {
    BinarySearchTree bst = new BinarySearchTree();
    Employee employee1 = new Employee("Анна", "Иванова", "Дизайнер", "Высокий", 5, 1234567890L);
    Employee employee2 = new Employee("Кира", "Кошкина", "Aссистент", "Низкий", 2, 1234567891L);
    Employee employee3 = new Employee("Алексей", "Алексеев", "Инженер", "Высокий", 10, 1234567892L);
    bst.insert(employee1);
    bst.insert(employee2);
    bst.insert(employee3);

    // Test PreOrder traversal
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    bst.PreOrder(bst.root);
    assertEquals(outContent.toString(), "Анна, Иванова, Дизайнер, Высокий, 5, 1234567890 \n" +
            "Кира Кошкина, Aссистент, Низкий, 2, 12345678910 \n" +
            "Алексей, Алексеев, Инженер, Высокий, 10, 1234567892 \n");
    System.setOut(System.out);
}

@Test
public void testPostOrder() {
    BinarySearchTree bst = new BinarySearchTree();
    Employee employee1 = new Employee("Анна", "Иванова", "Дизайнер", "Высокий", 5, 1234567890L);
    Employee employee2 = new Employee("Кира", "Кошкина", "Aссистент", "Низкий", 2, 1234567891L);
    Employee employee3 = new Employee("Алексей", "Алексеев", "Инженер", "Высокий", 10, 1234567892L);
    bst.insert(employee1);
    bst.insert(employee2);
    bst.insert(employee3);

   ByteArrayOutputStream outContent = new ByteArrayOutputStream();
System.setOut(new PrintStream(outContent));
bst.PostOrder(bst.root);
assertEquals(outContent.toString(), "Анна, Иванова, Дизайнер, Высокий, 5, 1234567890 \n" +
            "Кира Кошкина, Aссистент, Низкий, 2, 12345678910 \n" +
            "Алексей, Алексеев, Инженер, Высокий, 10, 1234567892 \n");
    System.setOut(System.out);
}
