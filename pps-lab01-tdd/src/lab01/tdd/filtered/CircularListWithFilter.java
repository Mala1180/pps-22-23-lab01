package lab01.tdd.filtered;

import java.util.Optional;
import java.util.function.Predicate;

public interface CircularListWithFilter {

    /**
     * Adds an element to the list, namely, after the last inserted one.
     * @param element the element to be added to the list
     */
    void add(final int element);

    /**
     * Finds and returns the next element that satisfies a given condition.
     * @param predicate the predicate which has to be satisfied
     * @return the element found, if no such element is found returns an empty Optional.
     */
    Optional<Integer> filteredNext(Predicate<Integer> predicate);
}
