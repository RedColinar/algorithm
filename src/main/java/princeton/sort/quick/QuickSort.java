package princeton.sort.quick;

@SuppressWarnings("all")
public class QuickSort {
    public static void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int low, int high) {
        if (low >= high) return;
        int o = partition(array, low, high);
        sort(array, low, o - 1);
        sort(array, o + 1, high);
    }

    private static int partition(Comparable[] array, int low, int high) {
        int i = low, j = high + 1;
        Comparable v = array[low];
        while (true) {
            while (array[++i].compareTo(v) < 0 && i < high);
            while (array[--j].compareTo(v) > 0 && j >= i);
            if (i >= j) break;
            exchange(array, i, j);
        }
        exchange(array, low, j);
        return j;
    }

    private static void exchange(Comparable[] array, int i, int j) {
        Comparable tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
