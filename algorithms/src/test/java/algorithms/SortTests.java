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
    private int size = 1000;
    private String alg;

    public SortTests(String name)
    {
        alg = name;
    }

    @Parameters(name = "Test {index}: {0}")
    public static Iterable<? extends Object> data()
    {
        return Arrays.asList("selection", "insertion");
    }

    @Before
    public void setUP()
    {
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
        assertFalse(Sorted.isSorted(arr));

        switch (alg.toLowerCase()) {
            case "selection":
                Selection.sort(arr);
                break;
            case "insertion":
                Insertion.sort(arr);
                break;

            default:
                break;
        }

        assertTrue(Sorted.isSorted(arr));
    }
}