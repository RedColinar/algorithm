package princeton.sort.quick;

import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {

    @Test
    public void slice() {

    }

    @Test
    public void testSort() {
        Comparable[] array = new Comparable[]{4, 1, 5, 3, 8, 6, 7, 9, 2, 0};
        QuickSort.sort(array);
        for (int i = 0; i < array.length; i++) {
            Assert.assertEquals(i, array[i]);
        }
    }
}
