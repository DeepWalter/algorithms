package algorithms;


/**
 *
 */
public final class Quick extends AbstractSorted
{
    private Quick() {}

    /**
     * Sort {@code array} in ascending order.
     *
     * @param <T> the type of elements in {@code array}
     * @param array the array to be sorted
     */
    public static <T extends Comparable<? super T>> void sort(T[] array)
    {
        sort(array, 0, array.length - 1);
    }

    public static void sort(double[] array)
    {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array)
    {
        sort(array, 0, array.length - 1);
    }

    /**
     * Sort the portion between index {@code lo} and index {@code hi} of
     * {@code array}.
     *
     * @param <T> the type of elements in {@code array}
     * @param array the array whose portion to be sorted
     * @param lo lower end of the portion
     * @param hi higher end of the portion
     */
    public static <T extends Comparable<? super T>> void sort(T[] array, int lo, int hi)
    {
        if (hi <= lo) return;

        int p = partition(array, lo, hi);
        sort(array, lo, p - 1);
        sort(array, p + 1, hi);
    }

    public static void sort(double[] array, int lo, int hi)
    {
        if (hi <= lo) return;

        int p = partition(array, lo, hi);
        sort(array, lo, p - 1);
        sort(array, p + 1, hi);
    }

    public static void sort(int[] array, int lo, int hi)
    {
        if (hi <= lo) return;

        int p = partition(array, lo, hi);
        sort(array, lo, p - 1);
        sort(array, p + 1, hi);
    }

    private static <T extends Comparable<? super T>> int partition(T[] array, int lo, int hi)
    {
        int p = StdRandom.randint(lo, hi + 1);
        T pivot = array[p];
        swap(array, p, lo);

        int j = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (less(array[i], pivot)) {
                j++;
                swap(array, i, j);
            }
        }
        swap(array, lo, j);

        return j;
    }


    private static int partition(double[] array, int lo, int hi)
    {
        int p = StdRandom.randint(lo, hi + 1);
        double pivot = array[p];
        swap(array, p, lo); // put the pivot at the low end

        int j = lo;
        for (int i = lo + 1; i <= hi; i++) {
            // Always keep those greater or equal element at the right side of j.
            if (array[i] < pivot) {
                j++;
                swap(array, i, j);
            }
        }
        swap(array, lo, j);

        return j;
    }

    private static int partition(int[] array, int lo, int hi)
    {
        int p = StdRandom.randint(lo, hi + 1);
        int pivot = array[p];
        swap(array, p, lo); // put the pivot at the low end

        int j = lo;
        for (int i = lo + 1; i <= hi; i++) {
            // Always keep those greater or equal element at the right side of j.
            if (array[i] < pivot) {
                j++;
                swap(array, i, j);
            }
        }
        swap(array, lo, j);

        return j;
    }

    private static <T> void swap(T[] array, int i, int j)
    {
        if (i == j) return;

        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void swap(double[] array, int i, int j)
    {
        if (i == j) return;

        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void swap(int[] array, int i, int j)
    {
        if (i == j) return;

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static <T extends Comparable<? super T>> boolean less(T a, T b)
    {
        return a.compareTo(b) < 0;
    }
}
