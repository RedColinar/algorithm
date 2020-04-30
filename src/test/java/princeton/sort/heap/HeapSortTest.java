package princeton.sort.heap;

import org.junit.Assert;
import org.junit.Test;
import princeton.Resources;

import java.io.BufferedReader;
import java.io.IOException;

public class HeapSortTest {

    @Test
    public void sort() {
        BufferedReader reader = Resources.getSortReader();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String[] actual = line.split(",");
                Integer[] actualInteger = new Integer[actual.length + 1];
                for (int i = 1; i <= actual.length; i++) {
                    actualInteger[i] = Integer.valueOf(actual[i - 1]);
                }

                String[] expect = reader.readLine().split(",");
                Integer[] expectInteger = new Integer[expect.length + 1];
                for (int i = 1; i <= expect.length; i++) {
                    expectInteger[i] = Integer.valueOf(expect[i - 1]);
                }

                HeapSort.sort(actualInteger);

                Assert.assertArrayEquals(expectInteger, actualInteger);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}