package algorithms;

public class Counter
{
    private final String name;  // counter name
    private int count = 0;      // current value

    /**
     * Initializes a new counter starting at 0, with the given id.
     *
     * @param id the name of the counter
     */
    public Counter(String id)
    {
        name = id;
    }

    /**
     * Increases the counter by 1.
     */
    public void increment()
    {
        count++;
    }

    /**
     * Returns the current value of this counter.
     * @return the current value of this counter
     */
    public int tally()
    {
        return count;
    }

    /**
     * @return a string representation of this counter
     */
    @Override
    public String toString()
    {
        return name + ": " + count;
    }

}