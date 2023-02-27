package lab01.tdd.iterators;

import java.util.Iterator;

public interface CircularListWithIterators {

    Iterator<Integer> forwardIterator();

    Iterator<Integer> backwardIterator();

}
