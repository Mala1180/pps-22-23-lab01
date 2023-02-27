import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

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

    @Test
    void testGetNext() {
        circularList.add(1);
        circularList.add(2);
        assertEquals(1, circularList.next().get());
        assertEquals(2, circularList.next().get());
        circularList.add(3);
        assertEquals(3, circularList.next().get());
    }

    @Test
    void testGetNextIfListIsEmpty() {
        assertEquals(Optional.empty(), circularList.next());
    }

    @Test
    void testGetNextAndGetPrevious() {
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        assertEquals(1, circularList.next().get());
        assertEquals(2, circularList.next().get());
        assertEquals(3, circularList.next().get());
        assertEquals(2, circularList.previous().get());
        assertEquals(1, circularList.previous().get());
    }

    @Test
    void testGetNextCircular() {
        circularList.add(1);
        circularList.add(2);
        assertEquals(1, circularList.next().get());
        assertEquals(2, circularList.next().get());
        assertEquals(1, circularList.next().get());
    }

    @Test
    void testGetPreviousCircular() {
        circularList.add(1);
        circularList.add(2);
        assertEquals(2, circularList.previous().get());
    }
}
