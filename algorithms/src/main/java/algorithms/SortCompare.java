package algorithms;


public final class SortCompare
{
    // Prevent this class from being instantiated.
    private SortCompare() {}

    /**
     * Return the time an algorithm takes to sort an array.
     *
     * @param <T> the type of elements in {@code array}
     * @param alg the name of an algorithm
     * @param array the array to be sorted
     * @return the time the algorithm takes to sort an array
     */
    public static <T extends Comparable<? super T>>
    double time(String alg, T[] array)
    {
        Stopwatch timer = new Stopwatch();

        switch (alg.toLowerCase()) {
            case "insertion":
                Insertion.sort(array);
                break;
            case "selection":
                Selection.sort(array);
                break;
            case "shell":
                Shell.sort(array);
                break;

            default:
                break;
        }

        return timer.elapsedTime();
    }


    public static double time(String alg, double[] array)
    {
        Stopwatch timer = new Stopwatch();

        switch (alg.toLowerCase()) {
            case "insertion":
                Insertion.sort(array);
                break;
            case "selection":
                Selection.sort(array);
                break;
            case "shell":
                Shell.sort(array);
                break;

            default:
                break;
        }

        return timer.elapsedTime();
    }

    /**
     * Return the time an algorithm takes to sort random arrays.
     *
     * @param alg name of the algorithm
     * @param N length of the array to be sorted
     * @param T number of arrays to be sorted
     * @return the time the algorithm takes
     */
    public static double timeRandomInput(String alg, int N, int T)
    {
        double total = 0.0;
        double[] array;
        for (int i = 0; i < T; i++) {
            array = StdRandom.uniformArray(N);
            total += time(alg, array);
        }

        return total;
    }

    public static void main(String[] args)
    {
        int N = 1000;
        int T = 100;
        String alg1 = "insertion";
        String alg2 = "shell";
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);

        System.out.println(alg1 + "/" + alg2 + ": " + t1/t2);
    }
}
