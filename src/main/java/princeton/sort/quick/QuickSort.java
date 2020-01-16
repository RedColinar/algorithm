package princeton.sort.quick;

@SuppressWarnings("all")
public class QuickSort {
    public static void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int low, int high) {
        if (low >= high) return;
        int o = patition(array, low, high);
        sort(array, low, o - 1);
        sort(array, o + 1, high);
    }

    private static int patition(Comparable[] array, int low, int high) {
        int i = low;
        int j = high + 1;
        Comparable comparable = array[low];
        while (true) {
            while (array[++i].compareTo(comparable) < 0) if (i == high) break;
            while (array[--j].compareTo(comparable) > 0) if (j == low) break;
            if (i >= j) break;
            exchange(array, i, j);
        }
        exchange(array, low, j);
        return j;
    }


    private static void exchange(Comparable[] array, int i, int j) {
        Comparable<Object> tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
