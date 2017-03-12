import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by daniel on 3/10/17.
 */
public class EfficientListTest {

    @Test
    public void sizeOfListShouldBeZeroWhenListIsEmpty() {
        EfficientList<Object> list = new EfficientList<>();

        assertEquals(0, list.size());
    }

    @Test
    public void isEmptyShouldReturnTrueForAEmptyList() {
        EfficientList<Object> list = new EfficientList<>();

        assertFalse(list.isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenIndexIsNegative() {
        List<Integer> list = new EfficientList<>();

        list.add(-1, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenIndexIsGreaterThanSize() {
        List<Integer> list = new EfficientList<>();

        list.add(1, 1);
    }


    @Test
    public void shouldBeAbleToRetriveElementWhenSizeOfListIsOne() {
        List<Integer> list = new EfficientList<>();
        list.add(0, 10);

        int acutal = list.get(0);

        assertEquals(10, acutal);
    }

    @Test
    public void shouldBeAbleAddElementAtIndexZeroWhenElementAlreadyPresentAtZero() {
        EfficientList<Integer> list = new EfficientList<>();
        list.add(0, 10);
        list.add(0, 11);

        int acutal = list.get(0);

        assertEquals(11, acutal);
    }

    @Test
    public void shouldBeAbleToAddElementToEndOfTheList() {
        EfficientList<Character> list = new EfficientList<>();
        list.add(0, 'a');
        list.add(1, 'b');


        char acutal = list.get(0);
        assertEquals('a', acutal);

        acutal = list.get(1);
        assertEquals('b', acutal);
    }

    @Test
    public void shouldReturnTheRightSizeForNonEmptyList() {
        EfficientList<Character> list = new EfficientList<>();
        list.add(0, 'a');
        list.add(1, 'b');


        int acutal = list.size();

        assertEquals(2, acutal);
    }
}