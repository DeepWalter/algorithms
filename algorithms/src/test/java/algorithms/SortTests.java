package algorithms;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SortTests
{
    private double[] arr;
    private static final long SEED = System.currentTimeMillis();
    private int size;
    private String alg;

    public SortTests(String name, int N)
    {
        alg = name;
        size = N;
    }

    @Parameters(name = "Test {index}: {0} on {1} elements")
    public static Iterable<Object[]> data()
    {
        return Arrays.asList(new Object[][] {
            {"selection", 100},
            {"insertion", 100},
            {"shell", 100},
            {"merge", 100},
            {"quick", 100},

            {"selection", 1000},
            {"insertion", 1000},
            {"shell", 1000},
            {"merge", 1000},
            {"quick", 1000},

            {"selection", 10000},
            {"insertion", 10000},
            {"shell", 10000},
            {"merge", 10000},
            {"quick", 10000}
        });
    }

    @Before
    public void setUP()
    {
        StdRandom.setSeed(SEED);
        arr = StdRandom.uniformArray(size);
    }

    @After
    public void tearDown()
    {
        arr = null;
    }

    // @Test
    // public void testSelection()
    // {
    //     assertFalse(Selection.isSorted(arr));
    //     Selection.sort(arr);
    //     assertTrue(Selection.isSorted(arr));
    // }

    // @Test
    // public void testInsertion()
    // {
    //     assertFalse(Insertion.isSorted(arr));
    //     Selection.sort(arr);
    //     assertTrue(Insertion.isSorted(arr));
    // }

    @Test
    public void testSort()
    {
        assertFalse(AbstractSorted.isSorted(arr));

        switch (alg.toLowerCase()) {
            case "selection":
                Selection.sort(arr);
                break;
            case "insertion":
                Insertion.sort(arr);
                break;
            case "shell":
                Shell.sort(arr);
                break;
            case "merge":
                Merge.sort(arr);
                break;
            case "quick":
                Quick.sort(arr);
                break;

            default:
                break;
        }

        assertTrue(AbstractSorted.isSorted(arr));
    }
}