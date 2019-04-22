package algorithms;


/**
 * The {@code Selection} class implements the selection sort alogrithm. It
 * provides two methods:
 * <ol>
 *   <li>{@code sort(array)} sorts the {@code array} in ascending order.</li>
 *   <li>{@code isSorted(array)} tests if the {@code array} is sorted in
 * ascending order.</li>
 * </ol>
 *
 * <p>
 * The selection sort algorithm keeps the following invariant: for index
 * <em>i</em>, we select the minimum among the elements indexed from <em>i</em>
 * to <em>n - 1</em> and then put it at index <em>i</em>. Here, <em>n</em> is
 * the length of the array and the array is indexed from 0. It is clear that
 * after processing from index 0 to <em>n - 1</em> successively, the array is
 * sorted in ascending order.
 * </p>
 *
 * <p>
 * Since finding the minimum among elements indexed from <em>i</em> to
 * <em>n - 1</em> takes {@code n - i} comparisons, the whole process takes
 * about {@code n^2 / 2} comparisons. Also note that the whole process needs
 * another {@code n} swaps. The time complexity of the selection sort is
 * {@code O(n^2)}.
 * </p>
 *
 * @author DeepWalter
 *
 * @see Insertion
 */
public final class Selection extends AbstractSorted
{
    // Prevent this class from being instantiated.
    private Selection() {}

    /**
     * Sort {@code array} in ascending order.
     *
     * @param <T> the type of {@code array} elements
     * @param array the array to be sorted
     */
    public static <T extends Comparable<? super T>> void sort(T[] array)
    {
        int N = array.length;
        for (int i = 0; i < N; i++) {
            // Find the index of minimal element among array[i] ... array[N-1].
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(array[j], array[min])) min = j;
            }

            swap(array, i, min);
        }
    }

    /**
     * Sort {@code array} in ascending order.
     *
     * @param array the {@code int} array to be sorted
     */
    public static void sort(int[] array)
    {
        int N = array.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for ( int j = i+1; j < N; j++) {
                if (array[j] < array[min]) min = j;
            }

            swap(array, i, min);
        }
    }

    /**
     * Sort {@code array} in ascending order.
     *
     * @param array the {@code double} array to be sorted
     */
    public static void sort(double[] array)
    {
        int N = array.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for ( int j = i+1; j < N; j++) {
                if (array[j] < array[min]) min = j;
            }

            swap(array, i, min);
        }
    }

    // Swap array[i] with array[j].
    private static <T> void swap(T[] array, int i, int j)
    {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void swap(double[] array, int i, int j)
    {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Test if a is strictly less than b.
    private static <T extends Comparable<? super T>> boolean less(T a, T b)
    {
        return a.compareTo(b) < 0;
    }
}
