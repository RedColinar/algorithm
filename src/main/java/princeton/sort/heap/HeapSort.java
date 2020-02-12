package princeton.sort.heap;

public class HeapSort {
    public static <T> void sort(Comparable<T>[] array) {
        // 堆排序， 数组第一个元素空置
        int n = array.length - 1;
        for (int k = n / 2; k >= 1; k--)
            sink(array, k, n);

        while (n > 1) {
            exch(array, 1, n--);
            sink(array, 1, n);
        }
    }

    private static <T> void sink(Comparable<T>[] array, int index, int length) {
        while (index * 2 <= length) {
            int n = index * 2;
            if (n < length && array[n].compareTo((T) array[n + 1]) < 0) n++;
            if (array[index].compareTo((T) array[n]) >= 0) break;
            exch(array, index, n);
            index = n;
        }
    }

    private static <T> void exch(Comparable<T>[] array, int index, int index2) {
        Comparable<T> a = array[index];
        array[index] = array[index2];
        array[index2] = a;
    }
}
