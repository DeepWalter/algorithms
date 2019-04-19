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
 * @author DeepWalter
 *
 * @see Selection
 */
public class Insertion
{
    /**
     * Sort {@code array} in ascending order.
     *
     * @param <T> the type of elements in {@code array}
     * @param array the array to be sorted
     */
    public static <T extends Comparable<? super T>> void sort(T[] array)
    {
        for (int i = 1; i < array.length; i++) {
            T temp = array[i];
            int j = i;

            while (j > 0 && less(temp, array[j-1])) {
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


    /**
     * Test if {@code array} is sorted in ascending order.
     *
     * @param <T> the type of {@code array} elements
     * @param array array to be tested
     * @return {@code true} if {@code array} is sorted in ascending order;
     * {@code false} otherwise
     */
    public static <T extends Comparable<? super T>> boolean isSorted(T[] array)
    {
        for (int i = 1; i < array.length; i++) {
            if (less(array[i], array[i - 1])) return false;
        }
        return true;
    }

    /**
     * Test if {@code array} is sorted in ascending order.
     *
     * @param array an {@code int} array to be tested
     * @return {@code true} if {@code array} is sorted in ascending order;
     * {@code false} otherwise
     */
    public static boolean isSorted(int[] array)
    {
        int N = array.length;
        for (int i = 1; i < N; i++) {
            if (array[i] < array[i-1]) return false;
        }
        return true;
    }

    /**
     * Test if {@code array} is sorted in ascending order.
     *
     * @param array an {@code double} array to be tested
     * @return {@code true} if {@code array} is sorted in ascending order;
     * {@code false} otherwise
     */
    public static boolean isSorted(double[] array)
    {
        int N = array.length;
        for (int i = 1; i < N; i++) {
            if (array[i] < array[i-1]) return false;
        }
        return true;
    }

    private static <T extends Comparable<? super T>> boolean less(T a, T b)
    {
        return a.compareTo(b) < 0;
    }
}