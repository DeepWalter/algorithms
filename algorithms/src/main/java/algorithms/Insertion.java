package algorithms;


/**
 * The {@code Insertion} class implements the insertion sort algorithm. It
 * provides two methods:
 * <ol>
 *   <li>{@code sort(array)} sorts the {@code array} in ascending order.</li>
 *   <li>{@code isSorted(array)} tests if the {@code array} is sorted in
 * ascending order.</li>
 * </ol>
 *
 * <p>
 * The idea of insertion sort is simple: for element at index <em>i</em>, we
 * insert it into the right place of the sub-array indexed from 0 to
 * <em>i - 1</em>. If the elements are processed successively from index 0 to
 * <em>n - 1</em>, it's clear that the invariant is <em>after processing the
 * element indexed at <em>i</em>, the sub-array indexed from 0 to i is sorted
 * </em>. Hence after the last element is processed, the whole array is sorted.
 * </p>
 *
 * <p>
 * The insertion process takes advantage of the fact that the sub-array indexed
 * from 0 to <em>i - 1</em> is already sorted when inserting the element at
 * index <em>i</em>. That is, we insert from right -- if the element to the
 * left of the element to be inserted is greater, we swap those two elements
 * and we continue this until we find the right position for the element to be
 * inserted.
 * </p>
 *
 * <p>
 * An <em>inversion</em> is a pair of elements that are out of order in the
 * array. For example, in array {@code [3, 1, 2]}, both {@code (3, 1)} and
 * {@code (3, 2)} are inversions. Since the insertion algorithm only swaps two
 * adjacent elements, which can only reduce the number of inversions by one,
 * the number of swaps it takes to sort the array amounts to the total number
 * of inversions. And the number of comparisons is at least equal to the number
 * of swaps.
 * </p>
 *
 * <p>
 * For a randomly ordered array with {@code n} elements, insertion sort takes
 * about {@code n^2 / 4} comparisons and about {@code n^2 / 4} swaps on the
 * average to sort it in ascending order. The worst case is about
 * {@code n^2 / 2} swaps and about {@code n^2 / 2} comparisons while the best
 * case is {@code n - 1} comparisons and {@code 0} swaps. Hence for a large
 * array (with potentially more inversions) insertion sort may takes longer
 * time than selection sort. But for a small array, it usually takes less time
 * than selection sort.
 * </p>
 *
 * @author DeepWalter
 *
 * @see Shell
 * @see Selection
 */
public final class Insertion extends Sorted
{
    // Prevent this class from being instantiated.
    private Insertion() {}

    /**
     * Sort {@code array} in ascending order.
     *
     * @param <T> the type of elements in {@code array}
     * @param array the array to be sorted
     */
    public static <T extends Comparable<? super T>> void sort(T[] array)
    {
        for (int i = 1; i < array.length; i++) {
            // for (int j = i; j > 0 && less(array[j], array[j-1]); j--) {
            //     swap(array, j, j - 1);
            // }
            /* Note that array[i] is shift left to its right position through
             * swapping. This is not necessary since we only need to find its
             * right position first and then put it there.
             */
            T temp = array[i];
            int j = i;

            while (j > 0 && less(temp, array[j-1])) {
                /* Any element greater than temp should be moved to the right
                 * one position.
                 */
                array[j] = array[j-1];
                j--;
            }
            array[j] = temp;
        }
    }

    /**
     * Sort {@code array} in ascending order.
     *
     * @param array the array to be sorted
     */
    public static void sort(int[] array)
    {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;

            while (j > 0 && array[j-1] > temp) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = temp;
        }
    }

    /**
     * Sort {@code array} in ascending order.
     *
     * @param array the array to be sorted
     */
    public static void sort(double[] array)
    {
        for (int i = 1; i < array.length; i++) {
            double temp = array[i];
            int j = i;

            while (j > 0 && array[j-1] > temp) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = temp;
        }
    }

    private static <T extends Comparable<? super T>> boolean less(T a, T b)
    {
        return a.compareTo(b) < 0;
    }
}
