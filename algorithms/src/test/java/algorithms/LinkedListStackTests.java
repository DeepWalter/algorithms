package algorithms;

import java.util.NoSuchElementException;
import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;

public class LinkedListStackTests
{
    private Stack<String> stack;

    @Before
    public void setUp()
    {
        stack = new LinkedListStack<>();
    }

    @After
    public void tearDown()
    {
        stack = null;
    }

    @Test
    public void testInitialization()
    {
        assertEquals(stack.size(), 0);
        assertTrue(stack.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void testPopEmptyStack()
    {
        stack.pop();
    }

    @Test
    public void testPush()
    {
        stack.push("hello");
        stack.push("world");
        assertEquals(stack.size(), 2);

        Iterator<String> iter = stack.iterator();
        String str = iter.next();
        assertEquals(str, "world");
        str = iter.next();
        assertEquals(str, "hello");
    }
}