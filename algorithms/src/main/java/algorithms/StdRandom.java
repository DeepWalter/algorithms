package algorithms;

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
     */
    public static double[] uniform(int size)
    {
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = uniform();
        }

        return array;
    }
}