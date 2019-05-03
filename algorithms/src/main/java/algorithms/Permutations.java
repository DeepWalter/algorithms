package algorithms;


/**
 * Alogrithms for computing permutations.
 */
public final class Permutations
{
    public static boolean hasNext(int[] array)
    {
        int j = array.length - 2;   // index of the second to last element
        while (j >= 0 && array[j] >= array[j+1]) {
            j--;
        }

        return j >= 0;
    }
    public static void next(int[] array)
    {
        /** Length of {@code array}. */
        int length = array.length;

        int j = length - 2;   // index of the second to last element
        while (j >= 0 && array[j] >= array[j+1]) {
            j--;
        }
        if (j < 0) {
            return;
        }
        // at this point array[j] < array[j+1]
        int l = length - 1;
        while (array[l] <= array[j]) { // find the first l from right side s.t. array[l] > array[j]
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

    private static void reverse(int[] array, int i, int j)
    {
        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }
    }
}