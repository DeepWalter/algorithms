package algorithms;

import java.util.Arrays;
import java.util.Random;


/**
 * The {@code StdRandom} class provides some utility functions such as:
 * <ul>
 *  <li>{@code uniform()}</li>
 *  <li>{@code uniform(size)}</li>
 * </ul>
 *
 * @author DeepWalter
 */
public final class StdRandom
{
    private static Random random;
    private static long seed;

    static {
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    // Prevent the class from being instantiated.
    private StdRandom() {}

    /**
     * Set the seed of the random generator.
     *
     * @param s the seed
     */
    public static void setSeed(long s)
    {
        seed = s;
        random.setSeed(seed);
    }

    /**
     * Get the seed of the random generator.
     * @return the seed
     */
    public static long getSeed()
    {
        return seed;
    }

    /**
     * Return a uniformly distributed {@code double} value in [0, 1).
     *
     * @return a uniformly distributed {@code double} value in [0, 1)
     */
    public static double uniform()
    {
        return random.nextDouble();
    }

    /**
     * Return an array of {@code double} values that are uniformly distributed
     * in [0, 1).
     *
     * @param size length of the array
     * @return an array of {@code double} values that are uniformly distributed
     * in [0, 1)
     *
     * @see #uniform()
     */
    public static double[] uniformArray(int size)
    {
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = uniform();
        }

        return array;
    }

    /**
     * Return an uniformly distributed random integer.
     *
     * @return an uniformly distributed random integer
     */
    public static int randint() { return random.nextInt(); }

    /**
     * Return an uniformly distributed random integer in {@code [0, bound)}.
     * @param bound upper bound (exclusive)
     * @return an uniformly distributed random integer in {@code [0, bound)}
     */
    public static int randint(int bound) { return random.nextInt(bound); }

    /**
     * Return an uniformly distributed random integer in {@code [low, high)}.
     *
     * @param low lower bound (inclusive)
     * @param high higher bound (exclusive)
     * @return an uniformly distributed random integer in {@code [low, high)}
     */
    public static int randint(int low, int high)
    {
        return low + randint(high - low);
    }

    /**
     * Return an uniformly distributed random integer array.
     *
     * @param size length of the array
     * @return an uniformly distributed random integer array
     *
     * @see #randint()
     */
    public static int[] randintArray(int size)
    {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = randint();
        }

        return array;
    }

    /**
     * Return an uniformly distributed random integer array. The elements are
     * in range {@code [0, bound)}, the array length is {@code size}.
     *
     * @param bound higher bound of the elements (exclusive)
     * @param size length of the array
     * @return an uniformly distributed random integer array
     */
    public static int[] randintArray(int bound, int size)
    {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = randint(bound);
        }

        return array;
    }
}