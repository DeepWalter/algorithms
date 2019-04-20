package algorithms;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortTests
{
    private double[] arr;
    private int size = 1000;

    @Before
    public void setUP()
    {
        arr = StdRandom.uniform(size);
    }

    @After
    public void tearDown()
    {
        arr = null;
    }

    @Test
    public void testSelection()
    {
        assertFalse(Selection.isSorted(arr));
        Selection.sort(arr);
        assertTrue(Selection.isSorted(arr));
    }

    @Test
    public void testInsertion()
    {
        assertFalse(Insertion.isSorted(arr));
        Selection.sort(arr);
        assertTrue(Insertion.isSorted(arr));
    }


}