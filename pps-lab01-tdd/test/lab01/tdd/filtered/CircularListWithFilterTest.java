package lab01.tdd.filtered;

import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CircularListWithFilterTest {


    private CircularListWithFilter circularListWithFilter;
    private CircularList circularList;
    @BeforeEach
    void beforeEach() {
        circularList = new CircularListImpl();
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        circularList.add(4);
        circularListWithFilter = new CircularListWithFilterImpl(circularList.copy());
    }

}