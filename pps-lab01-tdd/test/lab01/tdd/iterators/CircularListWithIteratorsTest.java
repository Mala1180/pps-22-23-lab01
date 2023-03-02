package lab01.tdd.iterators;

import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.function.IntSupplier;

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
        this.testIterator(iterator, () -> circularList.next().get());
    }

    @Test
    void testBackwardIterator() {
        Iterator<Integer> iterator = circularListWithIterators.backwardIterator();
        this.testIterator(iterator, () -> circularList.previous().get());
    }

    @Test
    void testForwardIteratorAndBackwardIterator() {
        this.testForwardIterator();
        beforeEach();
        this.testBackwardIterator();
    }

    private void testIterator(Iterator iterator, IntSupplier supplierOfExpectedValue) {
        for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
            assertEquals(supplierOfExpectedValue.getAsInt(), iterator.next());
        }
        assertTrue(iterator.hasNext());
    }
}