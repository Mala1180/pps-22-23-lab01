package lab01.tdd.iterators;

import lab01.tdd.CircularList;

import java.util.Iterator;

public class CircularListWithIteratorImpl implements CircularListWithIterators {

    private CircularList circularList;

    public CircularListWithIteratorImpl(CircularList circularList) {
        this.circularList = circularList;
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return null;
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return null;
    }
}
