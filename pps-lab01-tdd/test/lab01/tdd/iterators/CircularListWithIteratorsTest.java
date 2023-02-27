package lab01.tdd.iterators;

import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;

class CircularListWithIteratorsTest {


    private CircularListWithIterators circularListWithIterators;

    @BeforeEach
    void beforeEach() {
        CircularList circularList = new CircularListImpl();
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        circularList.add(4);
        circularListWithIterators = new CircularListWithIteratorImpl(circularList);
    }

}