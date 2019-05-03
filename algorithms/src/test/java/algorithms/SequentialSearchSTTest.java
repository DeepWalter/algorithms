package algorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SequentialSearchSTTest
{
    private ST<String, String> st;

    @Before
    public void setUp()
    {
        st = new SequentialSearchST<>();
    }

    @After
    public void tearDown()
    {
        st = null;
    }

    @Test
    public void testInitialization()
    {
        assertTrue(st.isEmpty());
    }

    @Test
    public void testPut()
    {
        assertTrue(st.isEmpty());

        st.put("beijing", "good");
        st.put("tianjin", "cool");
        st.put("shanghai", "hmmm");
        assertEquals(3, st.size());
        assertEquals("good", st.get("beijing"));

        // lazy deletion
        st.put("beijing", null);
        assertEquals(2, st.size());
        assertNull(st.get("beijing"));

        st.put("beijing", "goodagain");
        assertEquals(3, st.size());
        assertEquals("goodagain", st.get("beijing"));
    }

    @Test
    public void testInterable()
    {
        assertTrue(st.isEmpty());

        st.put("beijing", "good");
        st.put("tianjin", "cool");
        st.put("shanghai", "hmmm");
        assertEquals(3, st.size());

        st.put("beijing", null);
        int count = 0;
        for (String s: st.keys()) {
            assertNotEquals("beijing", s);
            count++;
        }
        assertEquals(2, count);
    }
}