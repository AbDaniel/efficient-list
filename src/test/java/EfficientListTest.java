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
        List<Object> list = new EfficientList<>();

        assertEquals(0, list.size());
    }

    @Test
    public void isEmptyShouldReturnZeroForAEmptyList() {
        List<Object> list = new EfficientList<>();

        assertTrue(list.isEmpty());
    }

}