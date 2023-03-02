package lab01.tdd.filtered;

import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CircularListWithFilterTest {

    private CircularListWithFilter circularListWithFilter;

    @BeforeEach
    void beforeEach() {
        circularListWithFilter = new CircularListWithFilterImpl();
        circularListWithFilter.add(1);
        circularListWithFilter.add(2);
        circularListWithFilter.add(3);
        circularListWithFilter.add(4);
    }

    @Test
    void testFilteredNext() {
        assertEquals(Optional.of(3), this.circularListWithFilter.filteredNext((element) -> element == 3));
    }

    @Test
    void testFilteredNextWithWrongCondition() {
        assertEquals(Optional.empty(), this.circularListWithFilter.filteredNext((element) -> element == 10));
    }

    @Test
    void testFilteredNextMultipleTimes() {
        assertEquals(Optional.of(2), this.circularListWithFilter.filteredNext((element) -> element % 2 == 0));
        assertEquals(Optional.of(4), this.circularListWithFilter.filteredNext((element) -> element % 2 == 0));
        assertEquals(Optional.of(2), this.circularListWithFilter.filteredNext((element) -> element % 2 == 0));
        assertEquals(Optional.of(4), this.circularListWithFilter.filteredNext((element) -> element % 2 == 0));
    }

}