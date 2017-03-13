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

    @Test
    public void shouldBeAbleToAddElementInTheMiddleOfTheList() {
        EfficientList<Character> list = new EfficientList<>();
        list.add(0, 'a');
        list.add(1, 'b');
        list.add(1, 'c');


        char acutal = list.get(0);
        assertEquals('a', acutal);
        acutal = list.get(1);
        assertEquals('c', acutal);
        acutal = list.get(2);
        assertEquals('b', acutal);
    }

    @Test
    public void shouldBeAbleToBuildAListWithMoreThanTenElements() {
        EfficientList<Character> list = new EfficientList<>();
        list.add('h');
        list.add(0, 'e');
        list.add(2, 'l');
        list.add(0, 'b');
        list.add(0, 'a');
        list.add(2, 'd');
        list.add(2, 'c');
        list.add(5, 'f');
        list.add(6, 'g');
        list.add(8, 'j');
        list.add(8, 'i');
        list.add(10, 'k');


        assertEquals(new Character('a'), list.get(0));
        assertEquals(new Character('b'), list.get(1));
        assertEquals(new Character('c'), list.get(2));
        assertEquals(new Character('d'), list.get(3));
        assertEquals(new Character('e'), list.get(4));
        assertEquals(new Character('f'), list.get(5));
        assertEquals(new Character('g'), list.get(6));
        assertEquals(new Character('h'), list.get(7));
        assertEquals(new Character('i'), list.get(8));
        assertEquals(new Character('j'), list.get(9));
        assertEquals(new Character('k'), list.get(10));
        assertEquals(new Character('l'), list.get(11));
    }

    @Test
    public void shouldBeAbleToAddElementInTheMiddleOfALongList() {
        EfficientList<Character> list = new EfficientList<>();
        list.add('h');
        list.add(0, 'e');
        list.add(2, 'l');
        list.add(0, 'b');
        list.add(0, 'a');
        list.add(2, 'd');
        list.add(2, 'c');
        list.add(5, 'f');
        list.add(6, 'g');
        list.add(8, 'j');
        list.add(8, 'i');
        list.add(10, 'k');

        list.add(5, 'm');

        assertEquals(new Character('m'), list.get(5));
    }

}