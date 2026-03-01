import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.LinkedList;

public class TestBST {

    @Test
    void testBstSearchTraceList1() {

        // Creating a BST and inserting values (same tree as mentioned in assignment)
        BST bst=new BST();
        bst.insert(15);
        bst.insert(6);
        bst.insert(18);
        bst.insert(3);
        bst.insert(7);
        bst.insert(17);
        bst.insert(20);
        bst.insert(2);
        bst.insert(4);
        bst.insert(13);
        bst.insert(9);

        // Expected linked list trace route: 15->6->7->13
        List<Integer> expectedList1= new LinkedList<>();
        expectedList1.add(15);
        expectedList1.add(6);
        expectedList1.add(7);
        expectedList1.add(13);

        // Returned linked list trace route (Key=13)
        List<Integer> actualList1=BSTprob.bstSearchTrace(bst.root, 13);

        // Testing if they are equal
        assertEquals(expectedList1, actualList1);

    }

    @Test
    void testBstSearchTraceList2() {

        // Creating a BST and inserting values (same tree as mentioned in assignment)
        BST bst=new BST();
        bst.insert(15);
        bst.insert(6);
        bst.insert(18);
        bst.insert(3);
        bst.insert(7);
        bst.insert(17);
        bst.insert(20);
        bst.insert(2);
        bst.insert(4);
        bst.insert(13);
        bst.insert(9);

        // Expected linked list trace route: 15->6->7->13, (14 does not exist in tree)
        List<Integer> expectedList2= new LinkedList<>();
        expectedList2.add(15);
        expectedList2.add(6);
        expectedList2.add(7);
        expectedList2.add(13);

        // Returned linked list trace route (Key=14)
        List<Integer> actualList2=BSTprob.bstSearchTrace(bst.root, 14);

        // Testing if they are equal
        assertEquals(expectedList2, actualList2);

    }

}
