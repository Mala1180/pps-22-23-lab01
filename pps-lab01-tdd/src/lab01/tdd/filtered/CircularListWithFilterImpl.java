package lab01.tdd.filtered;

import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CircularListWithFilterImpl implements CircularListWithFilter {

    private final CircularList circularList = new CircularListImpl();
    private final Set<Integer> elementsInList = new HashSet<>();

    @Override
    public void add(int element) {
        this.circularList.add(element);
        this.elementsInList.add(element);
    }

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> predicate) {
        return this.elementsInList.isEmpty() ||
                this.elementsInList.stream().noneMatch(predicate) ?
                Optional.empty() :
                Stream.generate(() -> circularList.next().get())
                        .filter(predicate)
                        .findFirst();
    }

}
