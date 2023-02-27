package lab01.tdd.iterators;

import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class CircularListWithIteratorsTest {


    private CircularListWithIterators circularListWithIterators;

    @BeforeEach
    void beforeEach() {
        CircularList circularList = new CircularListImpl();
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        circularList.add(4);
        circularListWithIterators = new CircularListWithIteratorImpl(circularList);
    }

    @Test
    void testForwardIterator() {
        Iterator<Integer> iterator = circularListWithIterators.forwardIterator();
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(4, iterator.next());
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
    }

    @Test
    void testBackwardIterator() {
        Iterator<Integer> iterator = circularListWithIterators.backwardIterator();
        assertEquals(4, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(1, iterator.next());
        assertEquals(4, iterator.next());
        assertEquals(3, iterator.next());
        assertTrue(iterator.hasNext());
    }

}