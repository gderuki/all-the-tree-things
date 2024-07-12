import lv.psanatovs.BinaryTree;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TreeTests {
    private static BinaryTree bt;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeAll
    public static void setup() {
        bt = new BinaryTree();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
    }

    @Test
    public void givenABinaryTree_TraversingLevelOrder() {
        System.setOut(new PrintStream(outContent));

        bt.traversePreOrder(bt.find(6));
        assertEquals("6 4 3 5 8 7", outContent.toString().trim());
        outContent.reset();

        bt.traverseInOrder(bt.find(6));
        assertEquals("3 4 5 6 7 8", outContent.toString().trim());
        outContent.reset();

        bt.traversePostOrder(bt.find(6));
        assertEquals("3 5 4 7 8 6", outContent.toString().trim());
        outContent.reset();

        System.setOut(originalOut);
        System.out.println("Alles goed!");
    }

    @Test
    public void givenABinaryTree_WhenAddingElements_ThenTreeContainsThoseElements() {
        assertTrue(bt.containsNode(6));
        assertTrue(bt.containsNode(4));
        assertFalse(bt.containsNode(1));
    }

    @Test
    public void givenABinaryTree_WhenDeletingElements_ThenTreeDoesNotContainThoseElements() {
        assertTrue(bt.containsNode(9));
        bt.delete(9);
        assertFalse(bt.containsNode(9));
    }
}
