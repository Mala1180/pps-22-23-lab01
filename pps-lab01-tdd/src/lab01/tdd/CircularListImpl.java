package lab01.tdd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private final List<Integer> list = new ArrayList<>();
    private int currentElementIndex = -1;

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Optional<Integer> next() {
        if (this.list.isEmpty()) {
            return Optional.empty();
        }
        currentElementIndex = currentElementIndex + 1;
        if (currentElementIndex == this.list.size()) {
            currentElementIndex = 0;
        }
        return Optional.of(this.list.get(currentElementIndex));
    }

    @Override
    public Optional<Integer> previous() {
        if (this.list.isEmpty()) {
            return Optional.empty();
        }
        currentElementIndex = currentElementIndex - 1;
        if (currentElementIndex < 0) {
            currentElementIndex = this.list.size() - 1;
        }
        return Optional.of(this.list.get(currentElementIndex));
    }

    @Override
    public void reset() {

    }
}
