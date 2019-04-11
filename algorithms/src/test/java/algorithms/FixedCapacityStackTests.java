package algorithms;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Iterator;



public class FixedCapacityStackTests
{
    @Test
    public void testPush()
    {
        Stack<String> strs = new FixedCapacityStack<>(10);
        assertEquals(strs.size(), 0);

        strs.push("hello");
        strs.push("world");
        assertEquals(strs.size(), 2);

        Iterator<String> iter = strs.iterator();
        String str = iter.next();
        assertEquals(str, "world");
        str = iter.next();
        assertEquals(str, "hello");
    }
}