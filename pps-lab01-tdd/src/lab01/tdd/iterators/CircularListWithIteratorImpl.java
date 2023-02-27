package lab01.tdd.iterators;

import lab01.tdd.CircularList;

import java.util.Iterator;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class CircularListWithIteratorImpl implements CircularListWithIterators {

    private CircularList circularList;

    public CircularListWithIteratorImpl(CircularList circularList) {
        this.circularList = circularList;
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return this.iterator(() -> this.circularList.next().get());
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return this.iterator(() -> this.circularList.previous().get());
    }

    private Iterator<Integer> iterator(IntSupplier supplier) {
        return circularList.size() == 0 ?
                IntStream.empty().iterator() :
                IntStream.generate(supplier).iterator();
    }
}
