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
        addElements(1, 2, 3);
        assertEquals(3, circularList.size());
    }

    @Test
    void testGetNext() {
        addElements(1, 2, 3);
        assertEquals(1, circularList.next().get());
        assertEquals(2, circularList.next().get());
        assertEquals(3, circularList.next().get());
    }

    @Test
    void testGetNextIfListIsEmpty() {
        assertEquals(Optional.empty(), circularList.next());
    }

    @Test
    void testGetNextAndGetPrevious() {
        addElements(1, 2, 3);
        assertEquals(1, circularList.next().get());
        assertEquals(2, circularList.next().get());
        assertEquals(3, circularList.next().get());
        assertEquals(2, circularList.previous().get());
        assertEquals(1, circularList.previous().get());
    }

    @Test
    void testGetNextCircular() {
        addElements(1, 2, 3);
        assertEquals(1, circularList.next().get());
        assertEquals(2, circularList.next().get());
        assertEquals(3, circularList.next().get());
        assertEquals(1, circularList.next().get());

    }

    @Test
    void testGetPreviousCircular() {
        addElements(1, 2, 3);
        assertEquals(3, circularList.previous().get());
    }

    private void addElements(int... elements) {
        for (int element : elements) {
            this.circularList.add(element);
        }
    }

}
