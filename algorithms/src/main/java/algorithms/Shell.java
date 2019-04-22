package algorithms;


/**
 * The {@code Shell} class implements the shell sort algorithm. It provides two
 * methods:
 * <ol>
 *   <li>{@code sort(array)} sorts the {@code array} in ascending order.</li>
 *   <li>{@code isSorted(array)} tests if the {@code array} is sorted in
 * ascending order.</li>
 * </ol>
 *
 * Shell sort is an improvement of the {@link Insertion} sort.
 *
 * @author DeepWalter
 *
 * @see Insertion
 * @see Selection
 */
public final class Shell extends AbstractSorted
{
    // Prevent this class from being instantiated.
    private Shell() {}

    /**
     * Sort {@code array} in ascending order.
     *
     * @param <T> the type of elements in {@code array}
     * @param array the array to be sorted
     */
    public static <T extends Comparable<? super T>> void sort(T[] array)
    {
        int N = array.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1;

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(array[j], array[j-h]); j -= h) {
                    swap(array, j, j - h);
                }
            }

            h /= 3;
        }
    }

    /**
     * Sort {@code array} in ascending order.
     * @param array the array to be sorted
     */
    public static void sort(double[] array)
    {
        int N = array.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1;

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && array[j-h] > array[j]; j -= h) {
                    swap(array, j, j - h);
                }
            }

            h /= 3;
        }
    }

    /**
     * Sort {@code array} in ascending order.
     * @param array the array to be sorted
     */
    public static void sort(int[] array)
    {
        int N = array.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1;

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && array[j-h] > array[j]; j -= h) {
                    swap(array, j, j - h);
                }
            }

            h /= 3;
        }
    }

    private static void swap(double[] array, int i, int j)
    {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static <T> void swap(T[] array, int i, int j)
    {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static <T extends Comparable<? super T>> boolean less(T a, T b)
    {
        return a.compareTo(b) < 0;
    }
}