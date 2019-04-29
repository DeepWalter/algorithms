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
        String[] list = {"b", "e", "d", "c", "a"};
        for (String s: list) {
            ost.put(s, "value: " + s);
        }
        assertEquals(list.length, ost.size());

        assertEquals("e", ost.max());
        assertEquals("a", ost.min());
    }
}