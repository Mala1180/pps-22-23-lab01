package lab01.tdd.filtered;

import java.util.Optional;

public interface CircularListWithFilter {

    /**
     * Finds and returns the next element that satisfies a given condition.
     * @return the element found, if no such element is found returns an empty Optional.
     */
    Optional<Integer> filteredNext();

}
