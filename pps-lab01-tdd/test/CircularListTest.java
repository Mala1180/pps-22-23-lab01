import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    //TODO: test implementation
    private CircularList circularList;

    @BeforeEach
    void beforeEach() {
        circularList = new CircularListImpl();
    }

    @Test
    void testIsInitiallyEmpty() {
        assertTrue(circularList.isEmpty());
    }

    @Test
    void testAddThreeIntegers() {
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        assertEquals(3, circularList.size());
    }
}
