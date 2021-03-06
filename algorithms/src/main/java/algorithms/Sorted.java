package algorithms;


/**
 * The {@code Sorted} interface provides a utility method {@code isSorted(array)} to test
 * whether the array {@code array} is sorted in <em>ascending</em> order.
 *
 * @author DeepWalter
 */
public interface Sorted
{
    /**
     * Tests if {@code array} is sorted in ascending order.
     *
     * @param <T> the type of {@code array} elements
     * @param array array to be tested
     * @return {@code true} if {@code array} is sorted in ascending order; {@code false} otherwise
     */
    static <T extends Comparable<? super T>> boolean isSorted(T[] array)
    {
        for (int i = 1; i < array.length; i++) {
            if (less(array[i], array[i - 1])) return false;
        }
        return true;
    }

    /**
     * Tests if {@code array} is sorted in ascending order.
     *
     * @param array an {@code int} array to be tested
     * @return {@code true} if {@code array} is sorted in ascending order; {@code false} otherwise
     */
    static boolean isSorted(int[] array)
    {
        int N = array.length;
        for (int i = 1; i < N; i++) {
            if (array[i] < array[i-1]) return false;
        }
        return true;
    }

    /**
     * Tests if {@code array} is sorted in ascending order.
     *
     * @param array a {@code double} array to be tested
     * @return {@code true} if {@code array} is sorted in ascending order; {@code false} otherwise
     */
    static boolean isSorted(double[] array)
    {
        int N = array.length;
        for (int i = 1; i < N; i++) {
            if (array[i] < array[i-1]) return false;
        }
        return true;
    }

    // Test if a is strictly less than b.
    private static <T extends Comparable<? super T>> boolean less(T a, T b)
    {
        return a.compareTo(b) < 0;
    }
}
