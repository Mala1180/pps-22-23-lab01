package lab01.tdd.iterators;

import lab01.tdd.CircularList;

import java.util.Iterator;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CircularListWithIteratorImpl implements CircularListWithIterators {

    private final CircularList circularList;

    public CircularListWithIteratorImpl(CircularList circularList) {
        this.circularList = circularList;
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        CircularList circularListCopy = this.circularList.copy();
        return this.iterator(() -> circularListCopy.next().get());
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        CircularList circularListCopy = this.circularList.copy();
        return this.iterator(() -> circularListCopy.previous().get());
    }

    private Iterator<Integer> iterator(Supplier<Integer> supplier) {
        return circularList.size() == 0 ?
                IntStream.empty().iterator() :
                Stream.generate(supplier).iterator();
    }
}
