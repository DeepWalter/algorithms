package algorithms;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Alogrithms for computing permutations.
 */
public final class Permutations
{
    /**
     * Tests if the current permutation has a successor in lexicographic order.
     *
     * <p>
     * <strong>Note:</strong><br>
     * {@code array} has no successor iff its elements are in decreasing order. That is, the current
     * permutation is the last one in lexicographic order.
     *
     * @param array the current permutation
     * @return {@code true} if the current permutation has a successor in lexicographic order;
     * {@code false} otherwise
     */
    public static boolean hasNext(int[] array)
    {
        // array has a next permutation iff it is not in decreasing order.
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return true;
            }
        }

        return false;
    }

    /**
     * Tests if the current permutation has a successor in lexicographic order.
     *
     * <p>
     * <strong>Note:</strong><br>
     * {@code array} has no successor iff its elements are in decreasing order. That is, the current
     * permutation is the last one in lexicographic order.
     *
     * @param array the current permutation
     * @return {@code true} if the current permutation has a successor in lexicographic order;
     * {@code false} otherwise
     */
    public static boolean hasNext(double[] array)
    {
        // array has a next permutation iff it is not in decreasing order.
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return true;
            }
        }

        return false;
    }

    /**
     * Tests if the current permutation has a successor in lexicographic order.
     *
     * <p>
     * <strong>Note:</strong><br>
     * {@code array} has no successor iff its elements are in decreasing order. That is, the current
     * permutation is the last one in lexicographic order.
     *
     * @param <T> the type of elements in {@code array}
     * @param array the current permutation
     * @return {@code true} if the current permutation has a successor in lexicographic order;
     * {@code false} otherwise
     */
    public static <T extends Comparable<? super T>> boolean hasNext(T[] array)
    {
        // array has a next permutation iff it is not in decreasing order.
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) < 0) {
                return true;
            }
        }

        return false;
    }

    /**
     * Computes next permutation in-place.
     *
     * @param array the current permutation
     */
    public static void next(int[] array)
    {
        int length = array.length;

        // Find the largest j s.t. array[j] < array[j+1].
        int j = length - 2;   // index of the second to last element
        while (j >= 0 && array[j] >= array[j+1]) {
            j--;
        }
        if (j < 0) {    // no such j; or equivalently, array is in decreasing order
            return;
        }

        // Find the first l from right side s.t. array[l] > array[j].
        int l = length - 1;
        while (array[l] <= array[j]) {
            l--;
        }

        // at this point l >= j+1
        swap(array, j, l);
        reverse(array, j+1, length - 1);
    }

    /**
     * Computes next permutation in-place.
     *
     * @param array the current permutation
     */
    public static void next(double[] array)
    {
        int length = array.length;

        // Find the largest j s.t. array[j] < array[j+1].
        int j = length - 2;   // index of the second to last element
        while (j >= 0 && array[j] >= array[j+1]) {
            j--;
        }
        if (j < 0) {    // no such j; or equivalently, array is in decreasing order
            return;
        }

        // Find the first l from right side s.t. array[l] > array[j].
        int l = length - 1;
        while (array[l] <= array[j]) {
            l--;
        }

        // at this point l >= j+1
        swap(array, j, l);
        reverse(array, j+1, length - 1);
    }

    /**
     * Computes next permutation in-place.
     *
     * @param array the current permutation
     */
    public static <T extends Comparable<? super T>> void next(T[] array)
    {
        int length = array.length;

        // Find the largest j s.t. array[j] < array[j+1].
        int j = length - 2;   // index of the second to last element
        while (j >= 0 && array[j].compareTo(array[j+1]) >= 0) {
            j--;
        }
        if (j < 0) {    // no such j; or equivalently, array is in decreasing order
            return;
        }

        // Find the first l from right side s.t. array[l] > array[j].
        int l = length - 1;
        while (array[l].compareTo(array[j]) <= 0) {
            l--;
        }

        // at this point l >= j+1
        swap(array, j, l);
        reverse(array, j+1, length - 1);
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

    private static <T extends Comparable<? super T>> void swap(T[] array, int i, int j)
    {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Reverse the elements between index i and j (both included).
    private static void reverse(int[] array, int i, int j)
    {
        while (i < j) {
            swap(array, i++, j--);
        }
    }

    // Reverse the elements between index i and j (both included).
    private static void reverse(double[] array, int i, int j)
    {
        while (i < j) {
            swap(array, i++, j--);
        }
    }

    // Reverse the elements between index i and j (both included).
    private static <T extends Comparable<? super T>> void reverse(T[] array, int i, int j)
    {
        while (i < j) {
            swap(array, i++, j--);
        }
    }

    public static <T extends Comparable<? super T>> Iterable<T[]> permutations(T[] array)
    {
        return () -> new Iterator<T[]>() {
            private final int N = array.length;
            private T[] arrayCopy = Arrays.copyOf(array, array.length);
            private int j;  // largest index s.t. arrayCopy[j] < arrayCopy[j+1].
            private boolean isFirst;    // whether to fetch the first permutation

            {
                Quick.sort(arrayCopy);
                isFirst = true;
            }

            @Override
            public boolean hasNext()
            {
                if (isFirst) {
                    return true;
                }

                // set j to the largest index s.t. arrayCopy[j] < arrayCopy[j+1] if there is any.
                j = N - 2;
                while (j >= 0 && arrayCopy[j].compareTo(arrayCopy[j+1]) >= 0) {
                    j--;
                }

                return j >= 0;
            }

            @Override
            public T[] next()
            {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                if (isFirst) {
                    isFirst = false;
                    return arrayCopy;
                }

                // Find the first l from right side s.t. array[l] > array[j].
                int l = N - 1;
                while (arrayCopy[l].compareTo(arrayCopy[j]) <= 0) {
                    l--;
                }

                // at this point l >= j+1
                swap(arrayCopy, j, l);
                reverse(arrayCopy, j+1, N - 1);

                return arrayCopy;
            }
        };
    }

    public static Iterable<int[]> permutations(int[] array)
    {
        return () -> new Iterator<int[]>() {
            private final int N = array.length;
            private int[] arrayCopy = Arrays.copyOf(array, array.length);
            private int j;
            private boolean isFirst;    // whether to fetch the first permutation

            {
                Quick.sort(arrayCopy);
                isFirst = true;
            }

            @Override
            public boolean hasNext()
            {
                if (isFirst) {
                    return true;
                }

                j = N - 2;
                while (j >= 0 && arrayCopy[j] >= arrayCopy[j+1]) {
                    j--;
                }

                return j >= 0;
            }

            @Override
            public int[] next()
            {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                if (isFirst) {
                    isFirst = false;
                    return arrayCopy;
                }

                // Find the first l from right side s.t. array[l] > array[j].
                int l = N - 1;
                while (arrayCopy[l] <= arrayCopy[j]) {
                    l--;
                }

                // at this point l >= j+1
                swap(arrayCopy, j, l);
                reverse(arrayCopy, j+1, N - 1);

                return arrayCopy;
            }
        };
    }

    public static Iterable<double[]> permutations(double[] array)
    {
        return () -> new Iterator<double[]>() {
            private final int N = array.length;
            private double[] arrayCopy = Arrays.copyOf(array, array.length);
            private int j;
            private boolean isFirst;    // whether to fetch the first permutation

            {
                Quick.sort(arrayCopy);
                isFirst = true;
            }

            @Override
            public boolean hasNext()
            {
                if (isFirst) {
                    return true;
                }

                j = N - 2;
                while (j >= 0 && arrayCopy[j] >= arrayCopy[j+1]) {
                    j--;
                }

                return j >= 0;
            }

            @Override
            public double[] next()
            {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                if (isFirst) {
                    isFirst = false;
                    return arrayCopy;
                }

                // Find the first l from right side s.t. array[l] > array[j].
                int l = N - 1;
                while (arrayCopy[l] <= arrayCopy[j]) {
                    l--;
                }

                // at this point l >= j+1
                swap(arrayCopy, j, l);
                reverse(arrayCopy, j+1, N - 1);

                return arrayCopy;
            }
        };
    }
}
