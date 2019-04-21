package algorithms;


public final class Merge
{
    private static double[] aux;

    // Prevent this class from being instantiated.
    private Merge() {}

    public static void sort(double[] array)
    {
        int N = array.length;
        aux = new double[N];

        sort(array, 0, N - 1);
    }

    public static void sort(double[] array, int lo, int hi)
    {
        if (hi <= lo) return;

        int mid = (lo + hi) / 2;
        sort(array, lo, mid);
        sort(array, mid + 1, hi);
        merge(array, lo, mid, hi);
    }

    private static void merge(double[] array, int lo, int mid, int hi)
    {
        for (int i = lo; i <= hi; i++) {
            aux[i] = array[i];
        }

        int j = lo;
        int k = mid + 1;
        for (int i = lo; i <= hi; i++) {
            if (j > mid) {
                array[i] = aux[k++];
            } else if (k > hi) {
                array[i] = aux[j++];
            } else if (aux[j] < aux[k]) {
                array[i] = aux[j++];
            } else {
                array[i] = aux[k++];
            }
        }
    }
}