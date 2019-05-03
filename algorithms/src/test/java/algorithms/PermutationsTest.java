package algorithms;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PermutationsTest
{
    private int[] a;
    private int[][] permutations;

    @Before
    public void setUp()
    {
        a = new int[] {1, 2, 3};
        permutations = new int[][] { {1, 2, 3},
                                     {1, 3, 2},
                                     {2, 1, 3},
                                     {2, 3, 1},
                                     {3, 1, 2},
                                     {3, 2, 1}};
    }

    @After
    public void tearDown()
    {
        a = null;
        permutations = null;
    }

    @Test
    public void testNext()
    {
        for (int i = 0; i < 6; i++) {
            assertArrayEquals(a, permutations[i]);
            Permutations.next(a);
        }

        assertFalse(Permutations.hasNext(a));
    }
}