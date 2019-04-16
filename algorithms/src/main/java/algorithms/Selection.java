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
 * <p>
 * Since finding the minimum among elements indexed from <em>i</em> to
 * <em>n - 1</em> takes <em>n - i</em> comparisons, the whole process takes
 * about <em>n^2 / 2</em> comparisons. Also note that the whole process needs
 * another <em>n</em> swaps. The time complexity of the selection sort is
 * {@code O(n^2)}.
 * </p>
 *
 * @author DeepWalter
 */
public class Selection
{
    /**
     * Sort {@code array} in ascending order.
     *
     * @param <T> the type of {@code array} elements
     * @param array the array to be sorted
     */
    public static <T extends Comparable<T>> void sort(T[] array)
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
     * Test if {@code array} is sorted in ascending order.
     *
     * @param <T> the type of {@code array} elements
     * @param array array to be tested
     * @return {@code true} if {@code array} is sorted in ascending order;
     * {@code false} otherwise
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] array)
    {
        for (int i = 1; i < array.length; i++) {
            if (less(array[i], array[i - 1])) return false;
        }
        return true;
    }


    // Swap array[i] with array[j].
    private static <T extends Comparable<T>> void swap(T[] array, int i, int j)
    {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Test if a is strictly less than b.
    private static <T extends Comparable<T>> boolean less(T a, T b)
    {
        return a.compareTo(b) < 0;
    }
}
