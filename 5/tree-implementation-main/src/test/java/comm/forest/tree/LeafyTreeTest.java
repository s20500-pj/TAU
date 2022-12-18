package comm.forest.tree;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class LeafyTreeTest {

    Tree tree;

    @BeforeEach
    void setUp() {
        tree = new LeafyTree();
    }

    @AfterEach
    void tearDown() {
        tree = null;
    }

    @Test
    void shouldAddNegativeHeight() {
        //given

        //when
        tree.setHeight(123);
        //then
        assertEquals(123, tree.getHeight());
    }

    @Test
    void shouldProvideFutureDate() {
        //given
        Date futureDate = new Date(2050, 11, 11);
        //when

        //then
        assertThrows(DateTimeException.class, () -> tree.setPlantingDate(futureDate));
    }

    @Test
    void shouldAddNegativeRoot() {
        //given

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> tree.setRoot(-4));
    }
}