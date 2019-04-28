package algorithms;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchOSTTests
{
    private OST<String, String> ost;

    @Before
    public void setUp()
    {
        ost = new BinarySearchOST<String, String>(20);
    }

    @After
    public void tearDown()
    {
        ost = null;
    }

    @Test
    public void TestPut()
    {
        ost.put("beijing", "good");
        assertEquals(1, ost.size());

        ost.put("bei", null);
        assertEquals(1, ost.size());
    }
}