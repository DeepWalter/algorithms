package algorithms;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CounterTest
{
    @Test
    public void testInitialization()
    {
        Counter head = new Counter("Head");
        assertEquals(head.tally(), 0);
    }

    @Test
    public void testIncrement()
    {
        Counter head = new Counter("head");
        for (int i = 0; i < 10; i++) {
            assertEquals(head.tally(), i);
            head.increment();
        }
    }
}