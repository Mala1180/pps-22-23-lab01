package lab01.tdd.iterators;

import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class CircularListWithIteratorsTest {


    private static final int NUMBER_OF_ITERATIONS = 10;
    private CircularListWithIterators circularListWithIterators;
    private CircularList circularList;

    @BeforeEach
    void beforeEach() {
        circularList = new CircularListImpl();
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        circularList.add(4);
        circularListWithIterators = new CircularListWithIteratorImpl(circularList.copy());
    }

    @Test
    void testForwardIterator() {
        Iterator<Integer> iterator = circularListWithIterators.forwardIterator();
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            assertEquals(circularList.next().get(), iterator.next());
        }
        assertTrue(iterator.hasNext());
    }

    @Test
    void testBackwardIterator() {
        Iterator<Integer> iterator = circularListWithIterators.backwardIterator();
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            assertEquals(circularList.previous().get(), iterator.next());
        }
        assertTrue(iterator.hasNext());
    }

    @Test
    void testForwardIteratorAndBackwardIterator() {
        this.testForwardIterator();
        beforeEach();
        this.testBackwardIterator();
    }
}