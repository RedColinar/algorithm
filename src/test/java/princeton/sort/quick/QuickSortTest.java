package princeton.sort.quick;

import org.junit.Assert;
import org.junit.Test;
import princeton.sort.Resources;
import princeton.sort.heap.HeapSort;

import java.io.BufferedReader;
import java.io.IOException;

public class QuickSortTest {

    @Test
    public void sort() {
        BufferedReader reader = Resources.getSortReader();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String[] actual = line.split(",");
                Integer[] actualInteger = Resources.getIntArray(actual);

                String[] expect = reader.readLine().split(",");
                Integer[] expectInteger = Resources.getIntArray(expect);

                QuickSort.sort(actualInteger);

                Assert.assertArrayEquals(expectInteger, actualInteger);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
