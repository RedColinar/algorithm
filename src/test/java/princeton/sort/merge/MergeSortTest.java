package princeton.sort.merge;

import org.junit.Assert;
import org.junit.Test;
import princeton.Resources;
import princeton.sort.quick.QuickSort;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class MergeSortTest {

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

                MergeSort.sort(actualInteger);

                Assert.assertArrayEquals(expectInteger, actualInteger);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}