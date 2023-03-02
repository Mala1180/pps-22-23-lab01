package lab01.tdd.filtered;

import lab01.tdd.CircularList;

import java.util.Optional;

public class CircularListWithFilterImpl implements CircularListWithFilter {

    private CircularList circularList;

    public CircularListWithFilterImpl(CircularList circularList) {
        this.circularList = circularList;
    }

    @Override
    public Optional<Integer> filteredNext() {
        return Optional.empty();
    }

}
