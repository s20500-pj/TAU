package comm.forest.tree.component;

import comm.forest.tree.enums.LeafType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeafTest {

    Leaf leaf;

    @BeforeEach
    void setUp() {
        leaf = new Leaf();
    }

    @AfterEach
    void tearDown() {
        leaf = null;
    }

    @Test
    void shouldAddLeafType() {
        //given

        //when
        leaf.setLeafType(LeafType.SIMPLE);
        //then
        assertEquals(LeafType.SIMPLE, leaf.getLeafType());
    }
}