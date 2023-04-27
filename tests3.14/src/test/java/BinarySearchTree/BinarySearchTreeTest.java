import static org.junit.Assert.*;
import org.junit.Test;

public class BinarySearchTreeTest {

    @Test
    public void testInsert() {
        BinarySearchTree bst = new BinarySearchTree();
        Employee emp1 = new Employee("John", "Doe", "12345");
        Employee emp2 = new Employee("Jane", "Doe", "67890");
        bst.insert(emp1);
        bst.insert(emp2);
        assertEquals(bst.search("12345"), emp1);
        assertEquals(bst.search("67890"), emp2);
    }

    @Test
    public void testDelete() {
        BinarySearchTree bst = new BinarySearchTree();
        Employee emp1 = new Employee("John", "Doe", "12345");
        Employee emp2 = new Employee("Jane", "Doe", "67890");
        bst.insert(emp1);
        bst.insert(emp2);
        bst.delete("12345");
        assertNull(bst.search("12345"));
        assertEquals(bst.search("67890"), emp2);
    }

    @Test
    public void testSearch() {
        BinarySearchTree bst = new BinarySearchTree();
        Employee emp1 = new Employee("John", "Doe", "12345");
        Employee emp2 = new Employee("Jane", "Doe", "67890");
        bst.insert(emp1);
        bst.insert(emp2);
        assertEquals(bst.search("12345"), emp1);
        assertEquals(bst.search("67890"), emp2);
        assertNull(bst.search("99999"));
    }

}
