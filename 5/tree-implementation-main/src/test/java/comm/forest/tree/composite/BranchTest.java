package comm.forest.tree.composite;

import comm.forest.tree.TreeComponent;
import comm.forest.tree.component.Fruit;
import comm.forest.tree.component.Leaf;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class BranchTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    TreeComponent branch;
    TreeComponent leaf;
    TreeComponent fruit;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        branch = new Branch();
        leaf = new Leaf();
        fruit = new Fruit();
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        branch = null;
        leaf = null;
        fruit = null;
    }

    @Test
    public void shouldAddTreeComponent() {
        //given

        //when
        branch.add(leaf);
        //then
        assertFalse(branch.getTreeComponents().isEmpty());
        assertEquals(1, branch.getTreeComponents().size());
    }

    @Test
    public void shouldRemoveTreeComponent() {
        //given

        //when
        branch.add(fruit);
        branch.remove(fruit);
        //then
        assertTrue(branch.getTreeComponents().isEmpty());
        assertEquals(0, branch.getTreeComponents().size());
    }

    @Test
    public void shouldDisplayColor() {
        //given
        fruit.setColor("red");
        branch.add(fruit);
        //when
        branch.displayColor();
        //then
        assertFalse(outContent.toString().isEmpty());
    }

    @Test
    public void shouldThrowErrorWhenPassingNegativeSize() {
        //given

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            branch.setSize(-1);
        });
    }

    @Test
    public void shouldGrowTreeComponent() {
        //given
        branch.setSize(1);
        //when
        branch.grow(5);
        //then
        assertEquals(6, branch.getSize());
    }

    @Test
    public void shouldThrowErrorWhenGrowResultsInNegativeSize() {
        //given
        branch.setSize(1);
        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            branch.grow(-7);
        });
    }

    @Test
    public void shouldAddNullTreeComponent() {
        //given

        //when

        //then
        assertThrows(NullPointerException.class, () -> branch.add(null));
    }


}